package net.mrliuli.generics;

import sun.security.provider.SHA;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by leon on 2017/12/10.
 */
public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args){
        try{
            for(T t : seq){
                f.invoke(t, args);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){
        System.out.println(this + " rotate");
    }
    public void resize(int newSize){
        System.out.println(this + " resize" + newSize);
    }
}

class Squqre extends Shape{}

class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type, int size){
        try{
            for(int i = 0; i < size; i++){
                // Assume default constructor:
                add(type.newInstance());
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest{
    public static void main(String[] args) throws Exception{
        List<Shape> shapes = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
    }
}
