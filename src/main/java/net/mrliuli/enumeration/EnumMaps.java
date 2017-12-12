package net.mrliuli.enumeration;

import java.util.EnumMap;
import java.util.Map;

interface Command { void action(); }

public class EnumMaps {
	public static void main(String[] args){
		
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		
		em.put(AlarmPoints.KITCHEN, new Command(){
			public void action(){
				System.out.println("Kitchen fire!");
			}
		});
		
		em.put(AlarmPoints.BATHROMM, new Command(){
			public void action(){
				System.out.println("Bathroom alert!");
			}
		});
		
		for(Map.Entry<AlarmPoints, Command> e : em.entrySet()){
			System.out.print(e.getKey() + ": ");
			e.getValue().action();
		}
		
		try{ // If there's no value for a particular key:
			em.get(AlarmPoints.UTILITY).action();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
