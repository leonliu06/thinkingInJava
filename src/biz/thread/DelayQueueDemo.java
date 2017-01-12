package biz.thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.*;

class DelayedTask implements Runnable, Delayed{
	
	private static int counter = 0;
	private final int id = counter++;
	private final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
	public DelayedTask(int delayInMilliseconds){
		//延迟时间
		delta = delayInMilliseconds;
		//延迟时间到达的时刻，用当时的系统时间来表示，到达这个时间(trigger)后，该对象进入DelayQueue队列
		trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		sequence.add(this);
	}
	
	public void run(){
		System.out.println(this + " ");
	}	
	
	//返回该对象的剩余延迟时间，或者说返回当前时间（系统时间）距该对象的到期时间（trigger）还有多久。
	//返回0或负数时，表示当前时间（系统时间）已到达或超过到期时间（即trigger）。
	public long getDelay(TimeUnit unit){
		return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	}
	
	//当前对象与所给对象arg比较，返回-1，表示当前对象比所给对象arg更早到期，返回1表示更晚到期。
	//更早到期的对象会排在DelayQueue的队头。
	public int compareTo(Delayed arg){
		DelayedTask that = (DelayedTask)arg;
		if(trigger < that.trigger) return -1;
		if(trigger > that.trigger) return 1;
		return 0;
	}
	
	public String toString(){
		return String.format("[%1$-4d]", delta) + " Task " + id;
	}
	
	public String summary(){
		return "(" + id + ":" + delta + ")";
	}
	
	//结束哨兵
	public static class EndSentinel extends DelayedTask{
		private ExecutorService exec;
		public EndSentinel(int delay, ExecutorService e){
			super(delay);
			exec = e;
		}
		public void run(){
			for(DelayedTask pt : sequence){
				System.out.println(pt.summary() + " ");
			}
			System.out.println();
			System.out.println(this + " Calling shutdownNow()");
			exec.shutdownNow();
		}
	}
	
}

class DelayedTaskConsumer implements Runnable{
	private DelayQueue<DelayedTask> q;
	public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
		this.q = q;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				/*
				 * 注意，因为DelayedTaskConsumer自身是一个任务，所以它有自己的Thread，它可以使用这个线程来运行从队列中获取的所有任务。
				 * */
				//long start = System.currentTimeMillis();
				q.take().run(); // Run task with the current thread
				//System.out.println(System.currentTimeMillis() - start);
			}
		}catch(InterruptedException e){
			// Acceptable way to exit
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
}

public class DelayQueueDemo {
	public static void main(String[] args){
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
		// Fill with tasks that have random delays:
		for(int i = 0; i < 20; i++){
			queue.put(new DelayedTask(rand.nextInt(5000)));
		}
		// Set the stopping point
		queue.add(new DelayedTask.EndSentinel(5000, exec));
//		try{
//			TimeUnit.MILLISECONDS.sleep(15000);
//		}catch(InterruptedException e){
//			//
//		}
		exec.execute(new DelayedTaskConsumer(queue));
	}
}
