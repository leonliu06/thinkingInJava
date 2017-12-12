package net.mrliuli.innerclass;

import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;

abstract class Event{
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTimme){
		this.delayTime = delayTimme;
		start();
	}
	public void start(){
		eventTime = System.currentTimeMillis() + delayTime;
	}
	public boolean ready(){
		return System.currentTimeMillis() >= eventTime;
	}
	public abstract void action();
}

class Controller{
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c){ eventList.add(c); }
	public void run(){
		while(eventList.size() > 0){
			for(Event e : new ArrayList<Event>(eventList)){
				if(e.ready()){
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
}

class GreenhouseControls extends Controller{
	private boolean light = false;
	private boolean water = false;
	private String thermostat = "Day";
	public class LightOn extends Event{
		public LightOn(long delayTime){
			super(delayTime);
		}
		public void action(){
			light = true;
		}
		public String toString(){
			return "Light is on";
		}
	}
	public class LightOff extends Event{
		public LightOff(long delayTime){
			super(delayTime);
		}
		public void action(){
			light = false;
		}
		public String toString(){
			return "Light is off";
		}
	}
	public class WaterOn extends Event{
		public WaterOn(long delayTime){
			super(delayTime);
		}
		public void action() {
			water = true;
		}
		public String toString(){
			return "Greenhouse water is on";
		}
	}
	public class WaterOff extends Event{
		public WaterOff(long delayTime){
			super(delayTime);
		}
		public void action(){
			water = false;
		}
		public String toString(){
			return "Greenhouse water is off";
		}
	}
	public class ThermostatNight extends Event{
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		public void action(){
			thermostat = "Night";
		}
		public String toString(){
			return "Thermostat on night setting";
		}
	}
	public class ThermostatDay extends Event{
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		public void action(){
			thermostat = "Day";
		}
		public String toString(){
			return "Thermostat is on day setting";
		}
	}
	public class Bell extends Event{
		public Bell(long delayTime){
			super(delayTime);
		}
		public void action(){
			addEvent(new Bell(delayTime));
		}
		public String toString(){
			return "Bing!";
		}
	}
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList){
			super(delayTime);
			this.eventList = eventList;
			for(Event e : eventList){
				addEvent(e);
			}
		}
		public void action(){
			for(Event e : eventList){
				e.start();// Rerun each event
				addEvent(e);
			}
			start(); // Rerun this Event
			addEvent(this);
		}
		public String toString(){
			return "Restarting system";
		}
	}
	public static class Terminate extends Event{
		public Terminate(long delayTime){
			super(delayTime);
		}
		public void action(){
			System.exit(0);
		}
		public String toString(){
			return "Terminating";
		}
	}
}

public class GreenhouseController {
	public static void main(String[] args){
		GreenhouseControls gc = new GreenhouseControls();
		gc.addEvent(gc.new Bell(100));
		Event[] eventList = {
				gc.new ThermostatNight(0),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400)
		};
		gc.addEvent(gc.new Restart(6000, eventList));
		if(args.length == 1){
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		}
		gc.run();
	}
}
