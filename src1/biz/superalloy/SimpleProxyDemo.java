package biz.superalloy;

interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{
	public void doSomething(){
		System.out.println("doSomething");
	}
	public void somethingElse(String arg){
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	public void doSomething(){
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}
	public void somethingElse(String arg){
		System.out.println("SimplePorxy somethingElse");
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args){
		
		consumer(new RealObject());
		System.out.println(1);
		SimpleProxy p = new SimpleProxy(new SimpleProxy(new SimpleProxy(new RealObject())));
		System.out.println(2);
		consumer(p);
		System.out.println(3);
		consumer(new RealObject());
		
	}
}
