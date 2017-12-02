package biz.superalloy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {
	public static void main(String[] args){
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		//Won't compile:
		//List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(), new Heavy());
		
		//Give a hint using an explicit type argument specification
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
	}
}
