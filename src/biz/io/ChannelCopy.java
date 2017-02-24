//package biz.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		if(args.length != 2){
			System.out.println("arguments : sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		/*
		 * return The number of bytes read, possibly zero, or <tt>-1</tt> if the channel has reached end-of-stream
		 * FileChanel.read()  返回读到目标ByteBuffer的字节数，如果通道到达输入流的末尾时，返回-1
		 * */
		while(in.read(buffer) != -1){ 
			buffer.flip(); // Prepare for writing
			out.write(buffer);
			buffer.clear(); // Prepare for reading
		}
	}
}
