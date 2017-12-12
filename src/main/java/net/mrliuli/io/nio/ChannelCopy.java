package net.mrliuli.io.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ChannelCopy {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {

		if(args.length != 2){
			System.out.println("arguments : sourcefile destfile");
			System.exit(1);
		}

		// 打开一个FileChaanel用于读（输入）
		FileChannel in = new FileInputStream(args[0]).getChannel();

		// 打开一个FileChannel用于写（输出）
		FileChannel out = new FileOutputStream(args[1]).getChannel();

		// 一个缓冲器，分配了BSIZE个字节
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

		/*
		 * return The number of bytes read, possibly zero, or <tt>-1</tt> if the channel has reached end-of-stream
		 * FileChanel.read()  ���ض���Ŀ��ByteBuffer���ֽ��������ͨ��������������ĩβʱ������-1
		 * */

		// -1 一个分界符（源于Unix和C），表示到达了输入的末尾
		while(in.read(buffer) != -1){

			buffer.flip(); // Prepare for writing
			out.write(buffer);

			// write()操作之后，信息仍在缓冲器中，clear()操作对所有的内部指针重新安排，以便缓冲器在另一个read()操作期间能够做好接受数据的准备。
			buffer.clear(); // Prepare for reading
		}

	}

}
