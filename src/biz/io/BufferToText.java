//package biz.io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class BufferToText {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception{
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// Doesn't work:
		System.out.println(buff.asCharBuffer());
		// Decode using this system's default Charset:
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
		System.out.println("Decoding using " + encoding + ": " + Charset.forName(encoding).decode(buff));// decode解码，将字节流buff解码成this的CharSet字符集中的字符流
		// Or, we could encode with something that will print:
		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		// Now try reading again:
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		// Use a CharBuffer to write through:
		fc = new FileOutputStream("data2.txt").getChannel();
		buff = ByteBuffer.allocate(24); // More than needed
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		// Read and display
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
//		System.out.println("=======================");
//		ByteBuffer bf = ByteBuffer.wrap("hello world".getBytes("UTF-16BE"));
//		//bf.flip();
//		while(bf.hasRemaining())
//			System.out.println(bf.get());
//		
//		System.out.println("----------------");
//		
//		ByteBuffer bf1 = ByteBuffer.wrap("hello world".getBytes(encoding));
//		//bf1.flip();
//		while(bf1.hasRemaining())
//			System.out.println(bf1.get());
		
	}
}
