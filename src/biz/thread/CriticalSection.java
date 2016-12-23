package biz.thread;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

class Pair{
	private int x, y;
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Pair(){
		this(0, 0);
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public void incrementX(){x++;}
	public void incrementY(){y++;}
	public String toString(){
		return "x: " + x + ", y: " + y;
	}
	public class PairValuesNotEqualException extends RuntimeException{
		public PairValuesNotEqualException(){
			super("Pair values not equal: " + Pair.this);
		}
	}
	// Arbitrary invariant -- both variables must be equal:
	public void checkState(){
		if(x != y){
			throw new PairValuesNotEqualException();
		}
	}
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager{
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
	public synchronized Pair getPair(){
		// Make a copy to keep the original safe:
		return new Pair(p.getX(), p.getY());
	}
	// Assume this is a time consuming operation
	protected void store(Pair p){
		storage.add(p);
		try{
			TimeUnit.MICROSECONDS.sleep(50);
		}catch(InterruptedException ignore){}
	}
	public abstract void increment();
}

public class CriticalSection {

}
