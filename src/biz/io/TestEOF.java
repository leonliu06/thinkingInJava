package biz.io;

import java.io.*;

public class TestEOF {
	public static void main(String[] args) throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
		while(in.available() != 0) // .available() 在没有阻塞的情况下，流中可被读取的的字节数量
			System.out.print((char)in.readByte());
	}
}
