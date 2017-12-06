package net.mrliuli.generics;

/**
 * Created by leon on 2017/12/6.
 */
public class Fibonacci implements Generator<Integer> {

    private static int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n){
        return n < 2 ? 1 : fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args){
        Fibonacci gen = new Fibonacci();
        for(int i = 0; i < 18; i++){
            System.out.print(gen.next() + " ");
        }
        System.out.println();
    }

}
