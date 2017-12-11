package net.mrliuli.io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ReadClassFile{
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileInputStream(args[0]).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(1024);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining())
			System.out.print(buff.get());
	}
}

