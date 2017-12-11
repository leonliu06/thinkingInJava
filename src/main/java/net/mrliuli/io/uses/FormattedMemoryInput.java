package net.mrliuli.io.uses;

import java.io.*;

/**
 * 格式化的内存输入
 */
public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException{
		try{
			// 字节数组传给ByteArrayInputStream
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("FormattedMemoryInput.java").getBytes()));

			// DataInputStream用ReadByte()一次一个字节地读取字符，那么任何字节的值都是合法结果，因此返回值不能用来检测输入是否结束。
			while(true)
				System.out.print((char)in.readByte());

		}catch(EOFException e){
			System.err.println("End of stream");
		}
	}

}
