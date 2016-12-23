//package biz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class IntGenerator {
	private volatile boolean canceled = false;
	public abstract int next();
	// Allow this to be canceled:
	public void cancel(){ canceled = true; }
	public boolean isCanceled(){ return canceled; }
}

class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g, int ident){
		generator = g;
		id = ident;
	}	
	public void run(){
		while(!generator.isCanceled()){
			int val = generator.next();
			if(val % 2 != 0){
				System.out.println(val + " not even!");
				generator.cancel(); // Cancels all EvenCheckers
			}
		}
	}
	// Test any type of IntGenerator:
	public static void test(IntGenerator gp, int count){
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < count; i++){
			exec.execute(new EvenChecker(gp, count));
		}
		exec.shutdown();
	}
	// Default value for count:
	public static void test(IntGenerator gp){
		test(gp, 10);
	}
}

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	public synchronized int next(){
		++currentEvenValue; // Danger point here!
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args){
		EvenChecker.test(new EvenGenerator());
	}
}
