package biz.superalloy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.*;

import com.sun.swing.internal.plaf.metal.resources.metal;

@Target(ElementType.METHOD) //元注解，用来定义你的注解将应用于什么 地方（例如是一个方法 还是一个域）
@Retention(RetentionPolicy.RUNTIME) //元注解，用来定义该注解在哪一个级别可用，在源代码（SOURCES）、类文件（CLASS)或者运行时（RUNTIME)
@interface UseCase{	//定义注解
	public int id(); //注解的元素
	public String description() default "no description"; //description元素有一个default值，如果在注解某个方法时没有给出description的值，则该注解的处理器就会使用此元素的默认值。
}

class PasswordUtils{
	//被注解的方法与其他方法没有区别。注解@UseCase可以与任何修饰符共同作用于方法， 例如public、static或void。
	//从语法的角度看，注解的使用方式几乎与修饰符的使用一模一样
	@UseCase(id = 47, description = "Passwords must contain at least one number")
	public boolean validatePassword(String password){		
		return (password.matches("\\w*\\d\\w*")); //正则表达式
	}
	@UseCase(id = 48) public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	@UseCase(id = 49, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password){
		return !prevPasswords.contains(password);
	}
}

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCases, Class<?> cl){
		for(Method m : cl.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null){
				System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i : useCases){
			System.out.println("Warning: Missing use case-" + i);
		}
	}
	public static void main(String[] args){
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47, 48, 49, 50);
		trackUseCases(useCases, PasswordUtils.class);
	}
}
