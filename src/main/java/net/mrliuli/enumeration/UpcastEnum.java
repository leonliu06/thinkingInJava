package net.mrliuli.enumeration;

enum Search { HITHER, YON }

public class UpcastEnum {
	public static void main(String[] args){
		Search[] vals = Search.values();
		for(Search s : vals)
			System.out.println(s);
		Enum e = Search.HITHER; // Upcast
		// e.values(); // No Values() in Enum
		for(Enum en : e.getClass().getEnumConstants())
			System.out.println(en);
	}
}
