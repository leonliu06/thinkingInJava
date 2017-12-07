package net.mrliuli.generics.wildcards;

import net.mrliuli.rtti.App;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 2017/12/8.
 */
public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> list = Arrays.asList(new Apple());
        Apple a = (Apple) list.get(0);
        System.out.println(list.contains(new Apple()));     // argument is Object
        System.out.println(list.indexOf(new Apple()));
        System.out.println(list.contains(a));
        System.out.println(list.indexOf(a));
    }
}
