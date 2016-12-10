package biz.superalloy;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class PrintingContainers {
	
	static void print(Object obj){
		System.out.println(obj);
	}
	
	static Collection fill(Collection<String> collection){
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String, String> map){
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
	
	public static void main(String[] args){
//		print(fill(new ArrayList<String>()));
//		print(fill(new LinkedList<String>()));
//		print(fill(new HashSet<String>()));
//		print(fill(new TreeSet<String>()));// sort by asc
//		print(fill(new LinkedHashSet<String>()));
//		print(fill(new HashMap<String, String>()));//
//		print(fill(new TreeMap<String, String>()));// sort by asc
//		print(fill(new LinkedHashMap<String, String>()));//
//		
//		List<String> testList = (List<String>) fill(new ArrayList<String>());
//		print(testList.size());
//		for(String str : testList){
//			//testList.remove(str);
//			print(testList.size());
//		}
		
		boolean receipt = false;
		System.out.println(receipt == true);
	}
}
