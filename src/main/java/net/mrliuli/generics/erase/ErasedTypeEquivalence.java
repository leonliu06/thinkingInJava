package net.mrliuli.generics.erase;

import java.util.ArrayList;

/**
 * Created by li.liu on 2017/12/7.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args){
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);   // true
    }
}
