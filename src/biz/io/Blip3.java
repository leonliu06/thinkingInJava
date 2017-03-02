//package biz.io;

import java.io.*;

public class Blip3 implements Externalizable {
	private int i;
	private String s; // No initilaization
	public Blip3(){
		System.out.println("Blip3 Constructor");
		// s, i not initialized
	}
	public Blip3(String x, int a){
		System.out.println("Blip3(String x, in a)");
		s = x;
		i = a;
		// s & i initialized only in non-default constructor.
	}
	public String toString(){ return s + i; }
	public void writeExternal(ObjectOutput out) throws IOException{
		System.out.println("Blip3.writeExternal");
		// You must do this
		out.writeObject(s);
		out.writeObject(i);
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip3.readExternal");
		// You must do this:
		s = (String)in.readObject();
		i = (int)in.readObject();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println("Constructing objects:");
		Blip3 b3 = new Blip3("A Strnig ", 47);
		System.out.println(b3);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		System.out.println("Saving object:");
		o.writeObject(b3);
		o.close();
		// Now get it back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		System.out.println("Recovering b3:");
		b3 = (Blip3)in.readObject();
		System.out.println(b3);
	}
}
