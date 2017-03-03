package biz.io;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class Logon implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String name, String pwd){
		username = name;
		password = pwd;
	}
	public String toString(){
		return "login info: \n	username: " + username + "\n	date: " + date + "\n	password: " + password; 
	}
	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("Logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(2); // Delay
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
		System.out.println("Recovering object at " + new Date());
		a = (Logon)in.readObject();
		in.close();
		System.out.println("logon a = " + a);
	}
}
