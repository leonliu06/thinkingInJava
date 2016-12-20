package biz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {
	public static void main(String[] args){
		try{
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		}catch(RuntimeException ue){
			// This statement will not execute!
			System.out.println("Exception has been handled!");
		}
	}
}
