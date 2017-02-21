package biz.enumerated;

interface Competitor<T extends Competitor<T>>{
	Outcome compete(T competitor);
}

class RoShamBo{
	public static <T extends Competitor<T>>
	void match(T a, T b){
		System.out.println(a + " vs. " + b + ": " + a.compete(b));
	}
	public static <T extends Enum<T> & Competitor<T>>
	void play(Class<T> rsbClass, int size){
		for(int i = 0; i < size; i++)
			match(Enums.random(rsbClass), Enums.random(rsbClass));
	}
}

public enum RoShamBo2 implements Competitor<RoShamBo2> {
	PAPER(Outcome.DRAW, Outcome.LOSE, Outcome.WIN),
	SCISSORS(Outcome.WIN, Outcome.DRAW, Outcome.LOSE),
	ROCK(Outcome.LOSE, Outcome.WIN, Outcome.DRAW);
	
	private Outcome vPAPER, vSCISSORS, vROCK;
	RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
		// TODO Auto-generated constructor stub
		this.vPAPER = paper;
		this.vSCISSORS = scissors;
		this.vROCK = rock;
	}
	public Outcome compete(RoShamBo2 it){
		switch (it) {
		default:
		case PAPER:
			return vPAPER;
		case SCISSORS:
			return vSCISSORS;
		case ROCK:
			return vROCK;
		}
	}
	public static void main(String[] args){
		RoShamBo.play(RoShamBo2.class, 20);
	}
}
