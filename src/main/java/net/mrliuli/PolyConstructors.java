package net.mrliuli;

class Glyph{
	void draw(){
		System.out.println("Glyph.draw()");
	}
	Glyph(){
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph{
	RoundGlyph(int r){
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}	
	private int radius = 1;
	void draw(){
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
	
}

public class PolyConstructors {
	public static void main(String[] args){
		new RoundGlyph(5);
	}
}
