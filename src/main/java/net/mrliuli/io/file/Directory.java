package net.mrliuli.io.file;

import java.io.*;
import java.util.regex.*;
import java.util.*;


/**
 * 目录实用工具
 */
public final class Directory {
	public static File[] local(File dir, final String regex){
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
	}
	public static File[] local(String path, final String regex){ // Overloaded
		return local(new File(path), regex);
	}
	// A two-tuple for returning a pair of objects:
	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<>();
		// The default iterable element is the file list:
		public Iterator<File> iterator(){
			return files.iterator();
		}
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		public String toString(){
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
		}
	}
	public static TreeInfo walk(String start, String regex){ // Begin recursion
		return recurseDirs(new File(start), regex);
	}
	public static TreeInfo walk(File start, String regex){ // overloaded
		return recurseDirs(start, regex);
	}
	public static TreeInfo walk(File start){ // everything
		return recurseDirs(start, ".*");
	}
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
	static TreeInfo recurseDirs(File startDir, String regex){
		TreeInfo result = new TreeInfo();
		for(File item : startDir.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			}else {
				if(item.getName().matches(regex))
					result.files.add(item);
			}
		}		
		return result;
	}
	// Simple validation test:
	public static void main(String[] args){
		if(args.length == 0)
			System.out.println(walk("."));
		else
			for(String arg : args)
				System.out.println(walk(arg));
		
	}
}

class PPrint{
	public static String pformat(Collection<?> c){
		if(c.size() == 0) return "[]";
		StringBuilder result = new StringBuilder("[");
		for(Object elem : c){
			if(c.size() != 1)
				result.append("\n  ");
			result.append(elem);
		}
		if(c.size() != 1)
			result.append("\n");
		result.append("]");
		return result.toString();
	}
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}
	public static void pprint(Object[] c) {
		System.out.println(pformat(Arrays.asList(c)));
	}
}
