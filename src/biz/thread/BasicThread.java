package biz.thread;

public class BasicThread {
	public static void main(String[] args){
		Thread t = new Thread(new LiftOff());//Thread构造器只需要一个Runnable对象。
		t.start();//调用Thread对象的start()方法为该线程执行必需的初始化操作，然后调用Runnable的run()方法，以便在这个新线程中启动该任务。
		/*尽管start()看起来是产生了一个对长期运行方法的调用，但是从输出中可以看到，start()方法迅速地返回了，因为Waiting for LiftOff消息在倒计时之前就出现了。
		 * 实际上，你产生的是对LiftOff.run()的方法调用，并且这个方法还没有完成，但是因为LiftOff.run()是由不同的线程执行的，因此你仍旧可以执行main()线程中的其他操作
		 * （这种能力并不局限于main()线程，任何线程都可以启动另一个线程）。因此，程序会同时运行两个方法，main()和LiftOff.run()是程序中与其它线程“同时”执行的代码。
		 * */
		
		System.out.println("Waiting for LiftOff");
	}
}
