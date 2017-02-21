package biz.enumerated;

import java.util.*;
import biz.io.*;

import biz.enumerated.Mail.GeneralDelivery;
import biz.superalloy.Generator;

enum Category{
	MONEY(Input.NICKEL, Input.DIME, Input.QUARTER, Input.DOLLAR),
	ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS, Input.SODA, Input.SOAP),
	QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
	SHUT_DOWN(Input.STOP);
	
	private Input[] values;
	Category(Input... types){ values = types; }
	private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);
	
	static{
		for(Category c : Category.class.getEnumConstants())
			for(Input type : c.values)
				categories.put(type, c);
	}
	
	public static Category categorize(Input input){
		return categories.get(input);
	}
}

public class VendingMachine {
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Input selecttion = null;
	
	enum StateDuration { TRANSIENT } // Tagging enum
	
	enum State{
		RESTING{
			void next(Input input){
				switch(Category.categorize(input)){
				case MONEY:
						amount += input.amount();
						state = ADDING_MONEY;
						break;
				case SHUT_DOWN:
					state = TERMINAL;
					default:
				}
			}
		},
		ADDING_MONEY{
			void next(Input input){
				switch (Category.categorize(input)) {
				case MONEY:
					amount += input.amount();
					break;
				case ITEM_SELECTION:
					selecttion = input;
					if(amount < selecttion.amount())
						System.out.println("Insufficient money for " + selecttion);
					else 
						state = DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT){
			void next(){
				System.out.println("here is your " + selecttion);
				amount -= selecttion.amount();
				state = GIVING_CHANGE;
			}
		},
		GIVING_CHANGE(StateDuration.TRANSIENT){
			void next(){
				if(amount > 0){
					System.out.println("Your change: " + amount);
					amount = 0;
				}
				state = RESTING;
			}
		},
		TERMINAL{
			void output(){ System.out.println("Halted"); }
		};
		
		private boolean isTransient = false;
		State(){}
		State(StateDuration trans){ isTransient = true; }
		void next(Input input){
			throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
		}
		void next(){
			throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
		}
		void output() { System.out.println(amount); }
	}
	
	static void run(Generator<Input> gen){
		while(state != State.TERMINAL){
			state.next(gen.next());
			while(state.isTransient)
				state.next();
			state.output();
		}
	}
	public static void main(String[] args){
		Generator<Input> gen = new RandomInputGenerator();
		if(args.length == 1){
			gen = new FileInputGenerator(args[0]);
		}
		run(gen);
	}	
}

	//For a basic sanity check:
	class RandomInputGenerator implements Generator<Input>{
		public Input next() { return Input.randomSelection(); }
	}
	
	// Create Inputs from a file of ";" -separated strings:
	class FileInputGenerator implements Generator<Input>{
		private Iterator<String> input;
		public FileInputGenerator(String filename){
			input = new TextFile(filename, ";").iterator();
		}
		public Input next(){
			if(!input.hasNext())
				return null;
			return Enum.valueOf(Input.class, input.next().trim());
		}
	}
