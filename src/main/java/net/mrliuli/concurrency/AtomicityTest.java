package net.mrliuli.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	private int i = 0;
	/*����return iȷʵ���ԵĲ���������ȱ��ͬ��ʹ������ֵ�����ڴ��ڲ��ȶ����м�״̬ʱ�� ��ȡ��
	 * ����֮�⣬����iҲ����volatile�ģ���˻����ڿ��������⡣
	 * getValue()��evenIntcrement()������synchronized�ġ�
	 * */
	public int getValue(){ return i; }
	private synchronized void evenIncrement(){ i++; i++; }
	public void run(){
		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while(true){
			int val = at.getValue();
			if(val % 2 != 0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
