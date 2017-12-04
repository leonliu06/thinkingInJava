package net.mrliuli.rtti;

/**
 * Created by li.liu on 2017/12/4.
 */
public class BoundedClassReferences {
    public static void main(String[] args){
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Or anything derived from Number
    }
}
