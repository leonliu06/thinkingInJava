package net.mrliuli.generics;

import java.util.*;

public class GenericVarargs {

	/**
	 * 展示了与标准类库中java.util.Arrays.asList()方法相同的功能
	 * @param args
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<T>();
		for(T item : args){
			result.add(item);
		}
		return result;
	}

	public static void main(String[] args){
		List<String> ls = makeList("A");
		System.out.println(ls);
		ls = makeList("A", "B", "C");
		System.out.println(ls);
		ls = makeList("ABCEDFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}

}
