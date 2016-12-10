package biz.superalloy;

import java.util.Formatter;

public class Receipt {
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	
	private int width = 10;
	
	public void printTitle(){
		f.format("%-" + width * 3 + "s %" + width + "s %" + width * 2 + "s\n", "Item", "Qty", "Price");
		f.format("%-" + width * 3 + "s %" + width + "s %" + width * 2 + "s\n", "---", "---", "-----");
	}
	
	public void print(String name, int qty, double price){
		f.format("%-" + width * 3 + "." + width * 3 + "s %" + width + "s %" + width * 2 + ".2f\n", name, qty, price);
		total += price;
	}
	
	public void printTotal(){
		f.format("%-" + width * 3 + "s %" + width + "s %" + width * 2 + ".2f\n", "Tax", "", total * 0.06);
		f.format("%-" + width * 3 + "s %" + width + "s %" + width * 2 + "s\n", "", "", "-----");
		f.format("%-" + width * 3 + "s %" + width + "s %" + width * 2 + ".2f\n", "Total", "", total * 1.06);
	}
	
	public static void main(String[] args){
		Receipt receipt = new Receipt();
		receipt.printTitle();
		receipt.print("Jack's Magic Beans", 4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTotal();
		int i = 0;
		receipt.f.format("b: %b\n", i);
		int j = 1;
		receipt.f.format("b: %b\n", j);
		boolean b = false;
		receipt.f.format("b: %b\n", b);
		char c = 'a';
		receipt.f.format("b: %b\n", c);
		Object object = null;
		receipt.f.format("b: %b\n", object);
		
		receipt.f.format("b: %b\n", receipt);
		
		String str = new String();
		String str1 = null;
		
		String str2 = "";
		String str3 = "a";
		String str4 = "a";
		String str5 = new String();
		
		System.out.println("--------------");
		
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
		System.out.println(str3 == str4);
		
		System.out.println(str5);
		System.out.println(str2.equals(str5));
		System.out.println(str2 == str5);
		
		System.out.println("--------------");
		String s = " a ";
		String ss = "  ";
		System.out.print(ss);
		System.out.print(s);
		System.out.print("---");
		System.out.println(s.trim());
		System.out.println(ss.trim());
		
	}
}
