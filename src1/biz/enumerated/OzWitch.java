package biz.enumerated;

public enum OzWitch {
	// Instances must be defined first,  before methods:
	WEST("Miss Gulch, aka the Wicked Witch of the West"),
	NORTH("Glinda, the Goood Witch of the North"),
	EAST("Wicked Witch of the East, wearer of the Ruby " + "Slippers, Crushed by Dorothy's house"),
	SOUTH("Good by inference, but missing");
	
	private String descriptionString;
	
	// Constructor must be package or private access:
	private OzWitch(String description){
		this.descriptionString = description;
	}
	
	public String getDescription(){ return descriptionString; }
	
	public String toString() {
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) + lower;
	}
	
	public static void main(String[] args){
		for(OzWitch witch : OzWitch.values()){
			System.out.println(witch + ": " + witch.getDescription());
		}
	}
}
