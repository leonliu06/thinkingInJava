package net.mrliuli.io.uses;

import java.io.*;

public class TestEOF {
	public static void main(String[] args) throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
		// available()方法查看还有多少可供使用的字符。
		while(in.available() != 0)
			System.out.print((char)in.readByte());
	}
}
