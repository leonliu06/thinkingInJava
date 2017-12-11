package net.mrliuli.io.processcontrol;

public class OSExecuteDemo {
	public static void main(String[] args){
		if(args.length > 0){
			StringBuilder sb = new StringBuilder();
			for(String s : args)
				sb.append(s + " ");
			OSExecute.command(sb.toString());
			return;
		}
		OSExecute.command("javap OSExecuteDemo");
	}
}
