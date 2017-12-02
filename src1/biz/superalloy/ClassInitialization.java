package biz.superalloy;

import java.util.Random;

class Initable{
	static final int staticFinal = 47;//��̬�����ڳ���
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);//��̬�Ǳ����ڳ���
	static{
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception {
		Class initalbe = Initable.class;
		Object
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);//Does trigger initialization
		System.out.println(Initable2.staticNonFinal);//����final�ģ�Does trigger initialization
		Class initable3 = Class.forName("Initable3");// Does trigger initialization
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}

}
