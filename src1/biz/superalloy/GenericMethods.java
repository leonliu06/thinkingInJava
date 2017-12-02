package biz.superalloy;

public class GenericMethods {
	public <T> void f(T x){//要定义泛型方法，只需要将泛型参数列表置于返回值之前
		System.out.println(x.getClass().getName());
	}
	public static void main(String[] args){
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0f);
		gm.f('c');
		gm.f(gm);
	}
}
