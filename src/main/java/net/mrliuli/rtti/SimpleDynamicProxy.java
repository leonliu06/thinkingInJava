package net.mrliuli.rtti;

import java.lang.reflect.*;

/**
 * 调用处理器（在动态代理上所做的所有调用都会被重定向到单一的调用处理器上）
 */
class DynamicProxyHandler implements InvocationHandler {

	private Object proxied;

	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("***** proxy: " + proxy.getClass() + ". method: " + method + ". args: " + args);
		if(args != null){
			for(Object arg : args){
				System.out.println("   " + arg);
			}
		}
		return method.invoke(proxied, args);
	}

}

public class SimpleDynamicProxy{

	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args){

		RealObject real = new RealObject();
		consumer(real);

		System.out.println("================================================================================");

		// Insert a proxy and call again:
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class},	new DynamicProxyHandler(real));
		consumer(proxy);

	}

}
