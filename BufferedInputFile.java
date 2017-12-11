package net.mrliuli.io.uses;

import java.io.*;

/**
 * 缓冲输入文件
 * 打开一个文件用于字符输入
 */
public class BufferedInputFile {

	// Throw exceptions to console:
	public static String read(String fileName) throws IOException{

		// Reading input by lines:
		// 为了提高速度，对文件进行缓冲
		BufferedReader in = new BufferedReader(new FileReader(fileName));

		// 用来累积文件的全部内容
		StringBuilder sb = new StringBuilder();

		String s;
		while((s = in.readLine()) != null)	//
			sb.append(s + "\n");			// 包括换行符，因为readLine()已将换行符删掉

		in.close();

		return sb.toString();
	}

	public static void main(String[] args) throws IOException{
		String fileName = args.length == 1 ? args[0] : "BufferedInputFile.java";
		System.out.println(read(fileName));
	}

}
