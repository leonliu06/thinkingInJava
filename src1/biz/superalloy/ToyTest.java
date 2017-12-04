//package biz.superalloy;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy {
//	Toy(){
//		System.out.println(1);
//		System.out.println(this.getClass());
//		System.out.println(Toy.class);
//		try{
//			System.out.println(Class.forName("Toy"));
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		System.out.println(2);
//	}
	Toy(int i){System.out.println("Toy(int i) " + i);}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
	public FancyToy() {
		super(1);
	}
}

public class ToyTest {

	static void printInfo(Class cc){
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name : " + cc.getCanonicalName());
	}
	
	
	public static void main(String[] args){
		try{
			Toy t = Toy.class.getDeclaredConstructor(int.class).newInstance(10000);//??��????????????????????????Toy????
			System.out.println(t.toString());
			System.out.println(t.hashCode());
			System.out.println(t.getClass());
		}catch(NoSuchMethodException e){
			System.out.println(e.getMessage());
		}catch(InstantiationException e){
			System.out.println(e.getMessage());
		}catch(IllegalAccessException e){
			System.out.println(e.getMessage());
		}catch(InvocationTargetException e){
			System.out.println(e.getMessage());
		}
		
		Class c = null;
		try{
			c = Class.forName("FancyToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		
		printInfo(c);
		for(Class face : c.getInterfaces()){
			printInfo(face);
		}
		
		Class up = c.getSuperclass();
		Object obj = null;
		try{
			obj = up.newInstance();
		}catch(InstantiationException e){
			System.out.println("Cannot instantiate");
			System.exit(1);
		}catch(IllegalAccessException e){
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
		
	}
	
}
