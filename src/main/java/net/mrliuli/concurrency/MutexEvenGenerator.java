package net.mrliuli.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();
	public int next(){
		lock.lock();
		try{
			++currentEvenValue;
			Thread.yield(); // Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		}finally{
			lock.lock();
		}
	}
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
