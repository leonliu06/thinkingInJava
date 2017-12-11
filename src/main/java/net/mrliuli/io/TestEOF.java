package net.mrliuli.io;

import java.io.*;

public class TestEOF {
	public static void main(String[] args) throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("TestEOF.java")));
		while(in.available() != 0) // .available() ��û������������£����пɱ���ȡ�ĵ��ֽ�����
			System.out.print((char)in.readByte());
	}
}
