package net.mrliuli.io.fileutil;

import java.io.*;

/**
 * 读取二进制文件
 */
public class BinaryFile {
	public static byte[] read(File bFile) throws IOException {
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
		try{
			byte[] data = new byte[bf.available()];
			bf.read(data);
			return data;
		}finally{
			bf.close();
		}
	}
	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile).getAbsoluteFile());
	}
	public static void main(String[] args) throws IOException {
		System.out.println(new String(read(args[0])));
	}
}
