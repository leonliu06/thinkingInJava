package net.mrliuli.rtti;

import java.util.regex.Pattern;
import java.lang.reflect.*;

/**
 * 类方法提取器
 * 第一个参数为要提取方法的类
 * 第二个参数：方法的特殊签名（返回类型，方法名，参数）如包含第二个参数，才匹配筛选出来
 */
public class ShowMethods {

    private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n" + "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" + "To search for methods involving 'word'";

    //private static Pattern p = Pattern.compile("\\w+\\.|native |final ");
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    // 方法特殊签名包含第二个参数字符串
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    // 方法特殊签名包含第二个参数字符串
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                    }
                    lines++;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
        System.out.println("lines = " +lines);
    }

}
