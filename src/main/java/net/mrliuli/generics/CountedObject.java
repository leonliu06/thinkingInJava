package net.mrliuli.generics;

/**
 * Created by leon on 2017/12/7.
 */

/**
 * 能够记录下它创建了多少个CountedObject实例，并通过toString()方法告诉我们其编号
 */
public class CountedObject {
    private static int counter = 0;
    private final long id = counter++;
    public long id(){
        return id;
    }
    public String toString(){
        return "CountedObject " + id;
    }
}
