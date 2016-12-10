package biz.superalloy;

public class MyClass {
	
	int i;
	
	private static int j;
	
	public static void main(String[] args){
		MyClass m = new MyClass();
		System.out.println("m.i = " + m.i);
		MyClassA a = new MyClassA();
		System.out.println("a.i = " + a.i);
		Demo d = new Demo();
		System.out.println("d.i = " + d.i);
		DemoA da = new DemoA();
		System.out.println("da.i = " + da.i);
		
		System.out.println("j = " + j);
		
		com.zhaogang.ZgDemo z = new com.zhaogang.ZgDemo();
		
		//com.zhaogang.Qian q = new com.zhaogang.Qian();	
		
		Integer i = 2;
		Integer g = 2;
		
		System.out.println("i == g is " + (i == g));
		
		//String s = "";
		String t = "";
		
		System.out.println(i.equals(g));
		
		System.out.println("" == t);
		System.out.println(t.equals(""));
		
		Demo1 d1 = new Demo1();
		
		System.out.println(d1.i);
		
	}

}

class Demo{
	protected int i;
}
