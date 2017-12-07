
package net.mrliuli.generics;

import java.util.*;

public class Sets {

  /**
   * 并集
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 交集
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T>
  Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }

  /**
   * 差集 Subtract subset from superset:
   * @param superset
   * @param subset
   * @param <T>
   * @return
   */
  public static <T> Set<T>
  difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }

  // 并集-交集，Reflexive--everything not in the intersection:
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }

}
