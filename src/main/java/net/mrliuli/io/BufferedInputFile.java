package net.mrliuli.io;

import java.io.*;

public class BufferedInputFile {
	// Throw exceptions to console:
	public static String read(String fileName) throws IOException{
		// Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)//readLine()��ȡһ�У�����������ֹ��'\n'��'\r'(�س�)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException{
		String fileName = args.length == 1 ? args[0] : "BufferedInputFile.java";
		System.out.println(read(fileName));
	}
}
