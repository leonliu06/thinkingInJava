package net.mrliuli.concurrency;

class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name, int sleepTime){
		super(name);
		duration = sleepTime;
		start();
	}
	public void run(){
		try{
			System.out.println(getName() + " is sleepping");
			sleep(duration);			
		}catch(InterruptedException e){
			System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run(){
		try{
			sleeper.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class Joining {
	public static void main(String[] args){
		Sleeper sleepy = new Sleeper("Sleepy", 2500);
		Sleeper grumy = new Sleeper("Grumpy", 2500);
		Joiner dopey = new Joiner("Dopey", sleepy);
		Joiner doc = new Joiner("Doc", grumy);
		grumy.interrupt();
	}
}
