package biz.superalloy;

import java.util.*;
import java.lang.*;

class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	
	public Iterable<T> reversed(){
		
		return new Iterable<T>(){	// anonymous inner class
			public Iterator<T> iterator(){	// override iterator method
				return new Iterator<T>(){	// anonymous inner class
					int current = size() - 1;
					public boolean hasNext(){ return current > -1; }
					public T next() { return get(current--); }
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
		};
		
	}
}

class Switch{
	private boolean state = false;
	public void on(){
		state = true; 
		System.out.println(this);
	}
}

class FourException extends Exception{}

public class AdapterMethodIdiom {
	public static void main(String[] args){
		ReversibleArrayList<String> ral = new ReversibleArrayList(Arrays.asList("To be or not to be".split(" ")));
		// Grabs the ordinary iterator via iterator():
		for(String s : ral){
			System.out.print(s + " ");
		}
		System.out.println();
		
		// Hand it the Iterable of your choice
		for(String s : ral.reversed()){
			System.out.print(s + " ");
		}
		System.out.println();
		
		Integer a = 1001;
		Integer b = 1001;
		System.out.println(a == b);
	
		Switch sw = new Switch();
		
		sw.on();
		
		try{
			System.out.println("entering second try block");
			try{
				throw new FourException();
			}finally{
				System.out.println("finally in 2nd try block");
			}
		}catch(FourException e){
			System.out.println("Caught FourException in 1st try block");
		}finally{
			System.out.println("finally in 1st try block");
		}
		
	}
}
