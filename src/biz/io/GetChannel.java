package biz.io;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		// Write a file:
		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		/*
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer); 											// NonReadableChannelException
		System.out.println((char)buffer.get());
		*/
		fc.close();
		// Add to the end of the file:
		fc = new RandomAccessFile("data.txt", "rw").getChannel();	// Readable and Writable		
		fc.position(fc.size()); // Move to the end		
		fc.write(ByteBuffer.wrap("some more".getBytes()));
		fc.close();
		// Read the file:
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);		
		fc.read(buff);
		//fc.write(ByteBuffer.wrap("again".getBytes())); 			//NonWritableChannelException
		buff.flip();
		while(buff.hasRemaining())
			System.out.print((char)buff.get()); // ByteBuffer.get() returns a byte
	}
}
