package net.mrliuli.rtti;

import java.util.Random;

class Initable{
	static final int staticFinal = 47;		// 常数静态域
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);		// 非常数静态域（不是编译期常量）
	static{
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;	// 非常数静态域
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;		// 非常数静态域
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception {
		Class initalbe = Initable.class;				// 使用类字面常量.class获取Class对象引用，不会初始化
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);		// 常数静态域首次引用，不会初始化
		System.out.println(Initable.staticFinal2);		// 非常数静态域首次引用，会初始化
		System.out.println(Initable2.staticNonFinal);	// 非常数静态域首次引用，会初始化
		Class initable3 = Class.forName("net.mrliuli.rtti.Initable3");		// 使用Class.forName()获取Class对象引用，会初始化
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);	// 已初始化过
	}

}
