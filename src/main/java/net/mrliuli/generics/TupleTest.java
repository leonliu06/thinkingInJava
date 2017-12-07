package net.mrliuli.generics;

public class TupleTest {

    static TwoTuple<String, Integer> f(){
        return Tuple.tuple("hi", 47);
    }

    static TwoTuple f2(){
        return Tuple.tuple("hi", 47);
    }


}
