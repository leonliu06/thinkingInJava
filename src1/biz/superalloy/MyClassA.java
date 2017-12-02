package biz.superalloy;

public class MyClassA {

	Integer i;
	static int j;
	String st;
	static String s;
	char cc;
	static char c;
	
	public static void main(String[] args){
		
		System.out.println("static int j; " + MyClassA.j);
		System.out.println("static String s; " + MyClassA.s);
		System.out.println("static char c; " + MyClassA.c);
		
		MyClassA a = new MyClassA();
		System.out.println(a.i);
		System.out.println(a.st);
		System.out.println(a.cc);
		
	}
	
}

class DemoA{
	int i;
}
