package biz.superalloy;

import java.util.*;

public class ForEachCollections {
	
	static <T> void test(Iterable<T> ib){
		for(T t : ib){
			System.out.println(t + " ");
		}
	}
	
	public static void main(String[] args){
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for(String s : cs){
			System.out.print("'" + s + "'");
		}	
		
		for(Map.Entry entry : System.getenv().entrySet()){
			System.out.println(entry.getKey() + ": " + entry.getValue()); 
		}
		
		test(Arrays.asList(1, 2, 3));
		
		String[] strings = { "A", "B", "C" };
		
		// An array works in foreach, but it's not Iterable:
		//! test(strings);
		// Must explicitly convert it to an Iterable:		
		test(Arrays.asList(strings));
		
	}
	
}
