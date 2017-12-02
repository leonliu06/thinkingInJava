package biz.thread;

public class LiftOff implements Runnable{
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;//标识符，用来区分多个任务的实例。它是final的，因为它一旦被初始化后就不希望被修改。
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
	/*
	 * 当从Run导出一个类时，它必须肯有Run()方法，但是这个方法并无特殊之外——它不会产生任何内在的线程能力。
	 * 要实现线程行为，你必须显式地将一个任务附着到线程上。
	 * */
	public void run(){
		while(countDown-- > 0){
			System.out.print(status());
			/*
			 * 在run()中对静态方法Thread.yield()的调用是对线程调度器（Java线程机制的一部分，可以将CPU从一个线程转移给另一个线程）的一种建议，
			 * 它在声明：“我已经执行完生命周期中最重要的部分了，此刻正是切换其他任务执行一段时间的大好时机。”这完全是选择性的，但是这里使用它是因为
			 * 它会在这些示例中产生更加有趣的输出：你更有可能会看到任务换进换出的证据。
			 * */
			Thread.yield();
		}
		System.out.println("");
	}
}
