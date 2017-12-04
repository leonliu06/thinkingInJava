package net.mrliuli.rtti;

public class GenericToyTest {
	public static void main(String[] args) throws Exception{

		Class<FancyToy> ftClass = FancyToy.class;
		// Produces exact type:
		FancyToy fancyToy = ftClass.newInstance();

		Class<? super FancyToy> up = ftClass.getSuperclass();	//

		// This won't compile:
		// Toy toy = up.newInstance();
		// Class<Toy> up2 = up.getSuperclass(); 	// 这里 getSuperclass() 已经知道结果是Toy.class了，却不能赋给 Class<Toy>，这就是所谓的含糊性（vagueness）

		// Only produces Object:	(because of the vagueness)
		Object obj = up.newInstance();
		
	}
}
