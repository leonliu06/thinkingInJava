package net.mrliuli.generics.wildcards;

import java.util.*;

/**
 * Created by li.liu on 2017/12/8.
 */
public class GenericReading {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static List<Apple> appleList = Arrays.asList(new Apple());
    static List<Fruit> fruitList = Arrays.asList(new Fruit());

    // A static method adapts to each call:
    static void f1(){
        Apple a = readExact(appleList);
        Fruit f = readExact(fruitList);
        f = readExact(appleList);
    }

    static class Reader<T>{
        T readExact(List<T> list){ return list.get(0); }
    }

    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruitList);
        // Fruit a = fruitReader.readExact(appleList); // Error
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list){ return list.get(0); }
    }

    static void f3(){
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<Fruit>();
        Fruit f = fruitCovariantReader.readCovariant(fruitList);
        Fruit a = fruitCovariantReader.readCovariant(appleList);
    }

    public static void main(String[] args){
        f1(); f2();; f3();
    }
}
