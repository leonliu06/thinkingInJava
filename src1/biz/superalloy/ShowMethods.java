package biz.superalloy;

import java.util.regex.Pattern;
import java.lang.reflect.*;

public class ShowMethods {
	private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n" + "To show all methods in class or:\n" + 
									"ShowMethods qualified.class.name word\n" + "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.|native |final ");
	
	private static String s = "aaaaaaaaaaaaaaaaaaaaaaaaa";
	
	private static final String sf = "sssssssssssssssssssssssss";
	
	public ShowMethods() {
		// TODO Auto-generated constructor stub
		System.out.println("cccccccccccccccccccccc");
	}
	
	static{
		System.out.println("InitalizationIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println(s);
		System.out.println(sf);
	}
	
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try{
			Class<?> c = Class.forName(args[0]);
			//c.newInstance();
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1){
				for(Method method : methods){
					System.out.println(1);
					//System.out.println(method.toString());
					System.out.println(p.matcher(method.toString()).replaceAll(""));
					System.out.println(2);
				}
				for(Constructor ctor : ctors){
					System.out.println(3);
					//System.out.println(ctor.toString());
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
					System.out.println(4);
				}
				lines = methods.length + ctors.length;
			}else{
				for(Method method : methods){
					if(method.toString().indexOf(args[1]) != -1){
						//System.out.println(method.toString());
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for(Constructor ctor : ctors){
					if(ctor.toString().indexOf(args[1]) != -1){
						//System.out.println(ctor.toString());
						System.out.println(p.matcher(ctor.toString()).replaceAll(""));
					}
					lines++;
				}
			}
		}catch(ClassNotFoundException e){
			System.out.println("No such class: " + e);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
