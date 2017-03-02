import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//package biz.io;

public class FreezeAlien {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
		Alien quellek = new Alien();
		out.writeObject(quellek);
	}
}
