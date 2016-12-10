package com.zhaogang;

class Homer{
	char doh(char c){
		System.out.println("doh(char)");
		return 'd';
	}
	float doh(float f){
		System.out.println("doh(float)");
		return 1.0f;
	}
}

class Milhouse{}

class Lisa extends Homer{
	@Override char doh(char m){
		System.out.println("doh(Milhouse)");
		return 'm';
	}
}

class Bart extends Homer {

	final int i;
	void doh(Milhouse m){
		m = new Milhouse();
		System.out.println("doh(Milhouse)");
	}
	
	Bart(){
		i = 1;
	}
	//biz.superalloy.Demo1 d1 = new Demo1();

}

public class ZgDemo{
	public static void main(String[] args){
		Bart b = new Bart();
		b.doh(1);
		b.doh('x');
		b.doh(1.0f);
		b.doh(new Milhouse());
	}
}


class Qian{
	int i;
}


