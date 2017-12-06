package net.mrliuli.rtti.pets;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by li.liu on 2017/12/5.
 */

/**
 * 类型递归计数工具
 * Class.isAssignableFrom() ：调用类型可以被参数类型赋值，即判断传递进来的参数是否属于调用类型继承结构（是调用类型或调用类型的子类）
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    // 要计数的类型
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }

    // 计数
    public void count(Object obj){
        Class<?> type = obj.getClass();
        // 传递来的参数不属于要计数的类型继承结构，不计数
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    // 递归计数
    private void countClass(Class<?> type){
        Integer quantity = get(type);
        // 首先对该类的确切类型计数
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        // 存在超类，且超类也属于要计数的类型继承结构
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);     // count recursively
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>, Integer> pair : entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }

}
