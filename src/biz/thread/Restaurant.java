package biz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
	private final int orderNum;
	public Meal(int orderNum){ this.orderNum = orderNum; }
	public String toString(){ return "Meal " + orderNum; }
}

class WaitPerson implements Runnable{
	private Restaurant restaurant;
	public WaitPerson(Restaurant r){ restaurant = r; }
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized (this) {
					while(null == restaurant.meal){
						wait(); // ... for the chef to produce a meal
					}
				}
				System.out.println("Waitperson got " + restaurant.meal);
				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		}catch(InterruptedException e){
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable{
	private int count = 0;
	private Restaurant restaurant;
	public Chef(Restaurant r){ restaurant = r; }
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized (this) {
					while(restaurant.meal != null){
						wait(); // ... for the meal to be taken
					}
				}
				if(++count == 10){
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("Order up! ");
				synchronized(restaurant.waitPerson){
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MICROSECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.println("Chef interrupted");
		}
	}
}

public class Restaurant {
	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	ExecutorService exec = Executors.newCachedThreadPool();
	public Restaurant(){
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	public static void main(String[] args){
		new Restaurant();
	}
	
}
