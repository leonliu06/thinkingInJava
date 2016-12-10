package biz.superalloy;

public class ToString {

	int i = 10;
	long l = 100;
	float f = 2.5f;
	double d = 3.222;
	
	public String toString(){
		return String.format("i = %d, l = %d, f = %g, d = %g" + super.toString(), i, l, f, d);
	}
	
	public static void main(String[] args){
		ToString t = new ToString();
		System.out.println(t.toString());
	}
}
