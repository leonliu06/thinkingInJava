package biz.superalloy;

public class GenericMethods {
	public <T> void f(T x){//Ҫ���巺�ͷ�����ֻ��Ҫ�����Ͳ����б����ڷ���ֵ֮ǰ
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
