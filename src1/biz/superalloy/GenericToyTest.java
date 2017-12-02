package biz.superalloy;


public class GenericToyTest {
	public static void main(String[] args){
		Class<FancyToy> fitClass = FancyToy.class;
		Class<? super FancyToy> up = fitClass.getSuperclass();

		try{
			FancyToy fancyToy = fitClass.newInstance();//Produces exact type
			//Class<Toy> up2 = fitClass.getSuperclass();//won't compile
			Object obj = up.newInstance();//only produces Object
			if(fancyToy instanceof FancyToy){
				System.out.println("true");
			}else{
				System.out.print("false" + "\n");
			}
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(e.getMessage());
			//e.getMessage().toString().indexOf(str)
		}
		//FancyToy fancyToy = fitClass.newInstance();
		
	}
}
