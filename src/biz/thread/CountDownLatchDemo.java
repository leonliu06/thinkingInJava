package biz.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPortion implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	TaskPortion(CountDownLatch latch){
		this.latch = latch;
	}
	public void run(){
		try{
			doWork();
			latch.countDown();
		}catch(InterruptedException e){
			// Acceptable way to exit
		}
	}
	public void doWork() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(200));
		System.out.println(this + "completed");
	}
	public String toString(){
		return String.format("%1$-3d ", id);
	}
}

class WaitingTask implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch){
		this.latch = latch;
	}
	public void run() {
		try{
			latch.await();//调用wait()的任务挂起自己，直至计数到0,即等待到问题的初始部分完成为止（TaskPortion完成）。
			System.out.println("Latch barrier passed for " + this);
		}catch(InterruptedException e){
			System.out.println(this + " interrupted");
		}
	}
}

public class CountDownLatchDemo {
	static final int SIZE = 100;
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		// All must share a single CountDownLatch object:
		CountDownLatch latch = new CountDownLatch(SIZE);//值为SIZE的CountDownLatch。
		for(int i = 0; i < 10; i++){
			exec.execute(new WaitingTask(latch));
		}
		for(int i = 0; i < SIZE; i++){
			exec.execute(new TaskPortion(latch)); //SIZE 个任务，每个任务执行完成都countDown(),所有任务完成时，计数达到0.
		}
		System.out.println("Launched all tasks");
		TimeUnit.SECONDS.sleep(3);
		exec.shutdownNow();
	}
}
