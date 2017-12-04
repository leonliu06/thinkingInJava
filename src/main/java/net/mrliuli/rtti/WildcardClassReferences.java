package net.mrliuli.rtti;

/**
 * Created by li.liu on 2017/12/4.
 */
public class WildcardClassReferences {
    public static void main(String[] args){
        Class<?> intClass = int.class;  // 与 Class intClass = int.class 是等价的
        intClass = double.class;
    }
}
