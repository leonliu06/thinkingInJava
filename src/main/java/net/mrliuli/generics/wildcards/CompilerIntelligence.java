package net.mrliuli.generics.wildcards;

import java.util.*;

/**
 * Created by leon on 2017/12/8.
 */

public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> list = Arrays.asList(new Apple());
        Apple a = (Apple) list.get(0);
        System.out.println(list.contains(new Apple()));     // argument is Object
        System.out.println(list.indexOf(new Apple()));
        System.out.println(list.contains(new Tree()));
        System.out.println(list.indexOf(a));
    }
}

class Tree{}
