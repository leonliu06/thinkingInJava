package net.mrliuli.rtti;

public class GenericClassReferences {
	public static void main(String[] args){
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; 	// Same thing
		intClass = double.class;
		// genericIntClass = double.class; 	// Illegal, genericIntClass 限制为Integer 的Class对象
	}
}
