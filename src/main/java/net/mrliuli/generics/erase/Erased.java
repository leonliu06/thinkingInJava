package net.mrliuli.generics.erase;

/**
 * Created by leon on 2017/12/7.
 */
public class Erased<T> {
    private final int SIZE = 100;
    public static void f(Object arg){
        //if(arg instanceof T){}      // Error
        //T var = new T();            // Error
        //T[] array = new T[SIZE];    // Error
        //T[] array = (T)new Object[SIZE];    // Unchecked warning
    }
}
