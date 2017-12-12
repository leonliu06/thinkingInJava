package net.mrliuli.concurrency;

public class LiftOff implements Runnable{
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;//��ʶ�����������ֶ�������ʵ��������final�ģ���Ϊ��һ������ʼ����Ͳ�ϣ�����޸ġ�
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
	/*
	 * ����Run����һ����ʱ�����������Run()�������������������������֮�⡪������������κ����ڵ��߳�������
	 * Ҫʵ���߳���Ϊ���������ʽ�ؽ�һ�������ŵ��߳��ϡ�
	 * */
	public void run(){
		while(countDown-- > 0){
			System.out.print(status());
			/*
			 * ��run()�жԾ�̬����Thread.yield()�ĵ����Ƕ��̵߳�������Java�̻߳��Ƶ�һ���֣����Խ�CPU��һ���߳�ת�Ƹ���һ���̣߳���һ�ֽ��飬
			 * ���������������Ѿ�ִ������������������Ҫ�Ĳ����ˣ��˿������л���������ִ��һ��ʱ��Ĵ��ʱ����������ȫ��ѡ���Եģ���������ʹ��������Ϊ
			 * ��������Щʾ���в���������Ȥ�����������п��ܻῴ�����񻻽�������֤�ݡ�
			 * */
			Thread.yield();
		}
		System.out.println("");
	}
}
