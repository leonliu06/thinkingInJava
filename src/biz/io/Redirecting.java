package biz.io;

import java.io.*;

public class Redirecting {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("Redirecting.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("text.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null)
			System.out.println(s);
		out.close();
		System.out.println(console);
	}
}
