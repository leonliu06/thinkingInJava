package biz.superalloy;

import java.util.*;

public class AddingGroups {
	public static void main(String[] args){
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);//底层表示的是数组，不能调整尺寸
		list.set(1,  99);//ok, modify an element
		//list.add(21);//runtime error because Arrays.asList() is an array who can't be resized!
		
	}
}
