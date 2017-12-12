//package net.mrliuli;
//
//class BaseballException extends Exception{}
//class Foul extends BaseballException{}
//class Strike extends BaseballException{}
//
//abstract class Inning{
//	public Inning() throws BaseballException{}
//	public void event() throws BaseballException{
//		// doesn't actually have to throw anything
//	}
//	public abstract void atBat() throws Strike, Foul;
//	public void walk(){} // Throws no checked exceptions
//}
//
//class StormException extends Exception{}
//class RainedOut extends StormException{}
//class PopFoul extends Foul{}
//
//interface Storm{
//	public void event() throws RainedOut;
//	public void rainHard() throws RainedOut;
//}
//
//public class StormyInning extends Inning implements Storm {
//	// OK to add new exceptions for constructors, but you must deal with the base constructor exceptions:
//	public StormyInning() throws RainedOut, BaseballException{}
//	public StormyInning(String s) throws Foul, BaseballException{}
//
//	//public void walk() throws PopFoul{} // Compile error
//
//	public void event() throws RainedOut {}
//	public void rainHard() throws RainedOut {}
//
//
//    @Override
//    public void atBat() throws Strike, Foul {
//
//    }
//}
