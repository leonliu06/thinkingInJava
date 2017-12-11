package net.mrliuli.io.stdio;

import java.io.*;

/**
 * 从标准输入中读取
 */
public class Echo {
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = stdin.readLine()) != null && s.length() != 0)
			System.out.println(s);
	}
}
