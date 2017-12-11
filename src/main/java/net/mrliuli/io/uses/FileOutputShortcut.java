package net.mrliuli.io.uses;

import java.io.*;

/**
 * 文本文件输出的快捷方式
 */
public class FileOutputShortcut {
	static String file = "Data.txt";
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("Data.txt")));
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		out.close();
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}
}
