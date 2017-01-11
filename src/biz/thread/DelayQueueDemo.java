package biz.thread;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Runnable, Delayed{
	public void run(){
		
	}	
	
	public long getDelay(TimeUnit unit){
		return 0;
	}
	
	public int compareTo(Delayed arg){
		
		return 0;
	}


}

public class DelayQueueDemo {

}
