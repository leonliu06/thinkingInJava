package biz.superalloy;

import java.util.Iterator;
import java.util.Random;

import coffee.*;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{
	
	private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class };
	
	private static Random rand = new Random(47);
	
	public CoffeeGenerator(){}
	
	// for iterator
	private int size = 0;
	
	public CoffeeGenerator(int sz){ size = sz; }//用于foreach迭代
	
	public Coffee next(){
		try{
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count = size;
		public boolean hasNext() { return count > 0; }
		public Coffee next(){
			count--;
			return CoffeeGenerator.this.next();//类名.this访问外部类对象
		}
		public void remove(){// Not implemented
			throw new UnsupportedOperationException();
		}
	};
	
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}
	
	public static void main(String[] args){
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i = 0; i < 5; i++){
			System.out.println(gen.next());
		}
		for(Coffee c : new CoffeeGenerator(5)){//实现Iterator,可foreach迭代
			System.out.println(c);
		}
	}
	
}
