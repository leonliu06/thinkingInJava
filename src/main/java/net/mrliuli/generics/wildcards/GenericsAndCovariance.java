package net.mrliuli.generics.wildcards;

import java.util.*;

/**
 * Created by leon on 2017/12/8.
 */
public class GenericsAndCovariance {
    public static void main(String[] args){

        // Compile Error: incompatible types:
        //List<Fruit> list = new ArrayList<Apple>();

        // Wildcards allow covariance:
        List<? extends Fruit> flists = new ArrayList<Apple>();

        // But, 编译器并不知道flists持有什么类型对象。实际上上面语句使得向上转型，丢失掉了向List中传递任何对象的能力，甚至是传递Object也不行。
        //flists.add(new Apple());
        //flists.add(new Fruit());
        //flists.add(new Object());

        flists.add(null);   // legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flists.get(0);
    }
}
