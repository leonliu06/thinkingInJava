package net.mrliuli;

public class RandomBounds {
	static void usage(){
		System.out.println("Usage:");
		System.out.println("\tRandomBounds lower");
		System.out.println("\tRandomBounds upper");
		System.exit(1);
	}
	public static void main(String[] args){
		if(args.length != 1) usage();
		double d = 0.5;
		if(args[0].equals("lower")){
			while(d != 0.0){
				d = Math.random();
				System.out.println(d);
			}//keep trying
			System.out.println("Produced 0.0!");
		}
		if(args[0].equals("upper")){
			while(Math.random() != 1.0);//keep trying
			System.out.println("Produced 1.0!");
		}
	}
}
