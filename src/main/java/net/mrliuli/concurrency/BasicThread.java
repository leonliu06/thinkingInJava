package net.mrliuli.concurrency;

public class BasicThread {
	public static void main(String[] args){
		Thread t = new Thread(new LiftOff());//Thread������ֻ��Ҫһ��Runnable����
		t.start();//����Thread�����start()����Ϊ���߳�ִ�б���ĳ�ʼ��������Ȼ�����Runnable��run()�������Ա���������߳�������������
		/*����start()�������ǲ�����һ���Գ������з����ĵ��ã����Ǵ�����п��Կ�����start()����Ѹ�ٵط����ˣ���ΪWaiting for LiftOff��Ϣ�ڵ���ʱ֮ǰ�ͳ����ˡ�
		 * ʵ���ϣ���������Ƕ�LiftOff.run()�ķ������ã��������������û����ɣ�������ΪLiftOff.run()���ɲ�ͬ���߳�ִ�еģ�������Ծɿ���ִ��main()�߳��е���������
		 * ��������������������main()�̣߳��κ��̶߳�����������һ���̣߳�����ˣ������ͬʱ��������������main()��LiftOff.run()�ǳ������������̡߳�ͬʱ��ִ�еĴ��롣
		 * */
		
		System.out.println("Waiting for LiftOff");
	}
}
