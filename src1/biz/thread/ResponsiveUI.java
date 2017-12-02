package biz.thread;

import java.util.concurrent.ExecutionException;

class UnresponsiveUI{
	private volatile double d = 1;
	public UnresponsiveUI() throws Exception{
		while(d > 0){
			d = d + (Math.PI + Math.E) / d;
		}
		System.in.read(); // never gets here
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;
	public ResponsiveUI(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true){
			d = d + (Math.PI + Math.E) / d;
		}
	}
	public static void main(String[] args) throws Exception{
		//new UnresponsiveUI(); // Must kill this process
		new ResponsiveUI();
		System.in.read();
		System.out.println(d); // Shows progress
	}
	
}
