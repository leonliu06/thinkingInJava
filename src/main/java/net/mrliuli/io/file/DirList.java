package net.mrliuli.io.file;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 目录列表器，显示当前路径下的所在目录
 */
public class DirList {
	public static void main(String[] args){
		// 参数"."表示当前路径
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			// list()返回给定路径下所有文件（路径）列表
			list = path.list();
		else
			// 按DirFilter过滤文件集
			list = path.list(new DirFilter(args[0]));
		// 排序
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name){ //�ص���dir��·����name��·���µ��ļ���
		return pattern.matcher(name).matches();
	}
}
