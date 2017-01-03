package biz.thread;

import java.net.*;
import java.util.concurrent.*;
import java.io.*;

public class CloseResource {
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InputStream socketInput = new Socket("localhost", 8080).getInputStream();
		exec.execute(new IOBlocked(socketInput));
		exec.execute(new IOBlocked(System.in));
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Shutting down all threads");
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Closing " + socketInput.getClass().getName());
		socketInput.close(); // Releases blocked thread
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Closing " + System.in.getClass().getName());
		System.in.close(); // Releases blocked thread
	}
}