package net.mrliuli.enumeration;

import java.util.*;
//import static biz.enumerated.AlarmPoints.*;

public class EnumSets {
	public static void main(String[] args){
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set
		points.add(AlarmPoints.BATHROMM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}
