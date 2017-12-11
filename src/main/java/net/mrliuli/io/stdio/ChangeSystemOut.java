package net.mrliuli.io.stdio;

import java.io.*;

/**
 * 将System.out转换成PrintWriter
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello world");
	}
}
