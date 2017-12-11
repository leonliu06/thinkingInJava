package net.mrliuli.io.uses;

import java.io.*;

/**
 * 从内存输入
 */
public class MemoryInput {

	public static void main(String[] args) throws IOException{

		// 从BufferedInputFile.read()读入的String结果被用来创建一个StringReader
		StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));

		int c;
		// 调用reader()每次读取一个字符，并把它发送到控制台
		while((c = in.read()) != -1)
			System.out.print((char)c);	// reader()以int形式返回一个字节，所以必须转换为char

	}

}
