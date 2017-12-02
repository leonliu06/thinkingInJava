package biz.superalloy;

public class DatabaseException extends Exception {
	public DatabaseException(int transactionId, int queryId, String message){
		super(String.format("(t%d, q%d) %s", transactionId, queryId, message));
	}
	
	
	public static void main(String[] args){
		try{
			throw new DatabaseException(3, 7, "Write failed");
		}catch(Exception e){
			System.out.println(e);
			test t = new test();
			System.out.println(t.toString());
		}
	}
}

class test{
	
	int i = 10;
	long l = 100L;
	float f = 2.5f;
	double d = 3.222d;
	
	public String toString(){
		String s = String.format("i = %d, l = %L, f = %f, d = %d", i, l, f, d);
		System.out.println(s);
		return s;
	}
}
