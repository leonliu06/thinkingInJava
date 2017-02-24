//package biz.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ViewBuffers {
	public static void main(String[] args){
		ByteBuffer bb = ByteBuffer.wrap(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind();
		System.out.print("Byte Buffer ");
		while(bb.hasRemaining())
			System.out.print(bb.position() + " -> " + bb.get() + ", ");
		System.out.println();
		CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
		System.out.print("Char Buffer ");
		while(cb.hasRemaining())
			System.out.print(cb.position() + " -> " + cb.get() + ", ");
		System.out.println();
	}
}
