package biz.enumerated;

import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

import biz.superalloy.Generator;

enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private Random rand = new Random(47);
	public CartoonCharacter next(){
		return values()[rand.nextInt(values().length)];
	}
}

public class EnumImplementation {
	public static <T> void printNext(Generator<T> gr){
		System.out.println(gr.next() + ", ");
	}
	public static void main(String[] args){
		// Choose any instance:
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i = 0; i < 10; i++)
			printNext(cc);
	}
}
