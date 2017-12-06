package net.mrliuli.rtti;

/**
 * Created by li.liu on 2017/12/6.
 */

import java.lang.reflect.Method;

/**
 * 通过反射调用所有方法（包括私有的）
 */
public class HiddenImplementation {

    static void callHiddenMethod(Object obj, String methodName, Object[] args) throws Exception{
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj, args);
    }

    public static void main(String[] args) throws Exception{
        callHiddenMethod(new B(), "g", null);
    }
}

interface A {
    void f();
}
class B implements A{
    @Override
    public void f(){}
    private void g(){
        System.out.println("B.g()");
    }
}
