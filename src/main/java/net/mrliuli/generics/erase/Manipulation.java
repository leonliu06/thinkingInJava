package net.mrliuli.generics.erase;

/**
 * Created by li.liu on 2017/12/7.
 */

import java.lang.reflect.Array;

/**
 * 由于有了擦除，Java编译器无法将manipulate()必须能够在obj上调用f()这一需求映射到HasF拥有f()这一事实上。
 * @param <T>
 */
class Manipulator<T>{
    private T obj;
    public Manipulator(T x){ obj = x; }

    // Error: Cannot resolve method 'f()'
    //public void manipulate(){ obj.f(); }
}

/**
 * 为了调用f()，我们必须协助泛型类，给定泛型类的边界，以此告知编译器只能接受遵循这个边界的类型。由于有了边界，下面的代码就可以编译了。
 * @param <T>
 */
class Manipulator2<T extends HasF>{
    private T obj;
    public Manipulator2(T x){ obj = x; }
    public void manipulate(){ obj.f(); }
}

public class Manipulation {
    public static void main(String[] args){
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        //manipulator.manipulate();
        Manipulator2<HasF> manipulator2 = new Manipulator2<>(hf);
        manipulator2.manipulate();
    }
}
