package net.mrliuli.rtti.factory;

/**
 * Created by li.liu on 2017/12/5.
 */

/**
 * @param <T> 泛型参数T使得create()可以在每种Factory实现中返回不同的类型。这也充分利用了协变返回类型。
 */
public interface Factory<T> {
    T create();
}
