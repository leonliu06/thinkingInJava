package net.mrliuli.generics.wildcards;

import java.util.*;

/**
 * Created by li.liu on 2017/12/8.
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item){
        list.add(item);
    }
    static List<Apple> appleList = new ArrayList<Apple>();
    static List<Fruit> fruitList = new ArrayList<Fruit>();
    static void f1(){
        writeExact(appleList, new Apple());
        writeExact(fruitList, new Apple());
    }
    static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }
    static void f2(){
        writeWithWildcard(appleList, new Apple());
        writeWithWildcard(fruitList, new Apple());
    }
    public static void main(String[] args){
        f1();
        f2();
    }
}
