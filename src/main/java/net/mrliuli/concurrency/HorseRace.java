package net.mrliuli.concurrency;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	private static CyclicBarrier barrier;
	public Horse(CyclicBarrier b){ barrier = b; }
	public synchronized int getStrides() { return strides; }
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized (this) {
					strides += rand.nextInt(3); // Produces 0, 1, or 2
				}
				/*
				 * ��ȫ�����ȴ�ʱ��CyclicBarrier�е�Runnable��ִ��һ�Ρ���������ֹͣ�ȴ�����ʼ���С�
				 * */
				barrier.await();// Waits until all other thread have invoked await on this barrier. after when, the given barrier action will execute the run task
			}
		}catch(InterruptedException e){
			// A legitimate way to exit
		}catch(BrokenBarrierException e){
			// This one we want to know about
			throw new RuntimeException(e);
		}
	}
	public String toString(){ return "Horse " + id + " "; }
	public String tracks(){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < getStrides(); i++){
			s.append("*");
		}
		s.append(id);
		return s.toString();
	}
}

public class HorseRace{
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRace(int nHorses, final int pause){
		barrier = new CyclicBarrier(nHorses, new Runnable(){// "դ������"����ȫ�����ȴ�ʱ��CyclicBarrier�е�Runnable��ִ��һ�Ρ�
			public void run(){// Will trip when the given number of threads(parties) are waiting upon it, and the given barrier action will be executed
				StringBuilder s = new StringBuilder();
				for(int i = 0; i < FINISH_LINE; i++){
					s.append("="); // The fence on the race track
				}
				System.out.println(s);
				for(Horse horse : horses){
					System.out.println(horse.tracks());
				}
				for(Horse horse : horses){
					if(horse.getStrides() >= FINISH_LINE){
						System.out.println(horse + "won!");
						exec.shutdownNow();
						return;
					}
				}
				try{
					TimeUnit.MILLISECONDS.sleep(pause);
				}catch(InterruptedException e){
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		for(int i = 0; i < nHorses; i++){
			Horse horse = new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}
	public static void main(String[] args){
		int nHorses = 7;
		int pause = 200;
		if(args.length > 0){
			int n = new Integer(args[0]);
			nHorses = n > 0 ? n : nHorses;
		}
		if(args.length > 1){
			int p = new Integer(args[1]);
			pause = p > -1 ? p : pause;
		}
		new HorseRace(nHorses, pause);
	}
}
