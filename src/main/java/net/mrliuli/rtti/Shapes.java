package net.mrliuli.rtti;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 2017/12/3.
 */

abstract class Shape{
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();  //要求子类需要实现 toString()
}

class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle";
    }
    public void drawCircle(){}
}

class Square extends Shape{
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape{
    @Override
    public String toString() {
        return "Triangle";
    }
}
public class Shapes {
    public static  void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()  // 向上转型为 Shape，此处会丢失原来的具体类型信息！！对于数组而言，它们只是Shape类对象！
        );
        for(Shape shape : shapeList){
            shape.draw();   // 数组实际上将所有事物都当作Object持有，在取用时会自动将结果转型回声明类型即Shape。
        }
        //shapeList.get(0).drawCircle(); //这里会编译错误：在Shape类中找不到符号drawCircle()，证实了具体类型信息的丢失!!
    }
}
