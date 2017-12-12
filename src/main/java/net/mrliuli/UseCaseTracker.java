package net.mrliuli;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.*;

@Target(ElementType.METHOD) //Ԫע�⣬�����������ע�⽫Ӧ����ʲô �ط���������һ������ ����һ����
@Retention(RetentionPolicy.RUNTIME) //Ԫע�⣬���������ע������һ��������ã���Դ���루SOURCES�������ļ���CLASS)��������ʱ��RUNTIME)
@interface UseCase{	//����ע��
	public int id(); //ע���Ԫ��
	public String description() default "no description"; //descriptionԪ����һ��defaultֵ�������ע��ĳ������ʱû�и���description��ֵ�����ע��Ĵ������ͻ�ʹ�ô�Ԫ�ص�Ĭ��ֵ��
}

class PasswordUtils{
	//��ע��ķ�������������û������ע��@UseCase�������κ����η���ͬ�����ڷ����� ����public��static��void��
	//���﷨�ĽǶȿ���ע���ʹ�÷�ʽ���������η���ʹ��һģһ��
	@UseCase(id = 47, description = "Passwords must contain at least one number")
	public boolean validatePassword(String password){		
		return (password.matches("\\w*\\d\\w*")); //������ʽ
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
