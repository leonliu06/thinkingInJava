package net.mrliuli.generics.wildcards;

import java.util.*;

public class SuperTypeWildcards {
    /**
     * 超类型通配符使得可以向泛型容器写入。超类型边界放松了在可以向方法传递的参数上所作的限制。
     * @param apples    参数apples是Apple的某种基类型的List，这样你就知道向其中添加Apple或Apple的子类型是安全的。
     */
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit());    // Error
    }
}
