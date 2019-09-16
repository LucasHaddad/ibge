package aed2.model.enumeration;

public enum Race {
	BLACK("Black"), 
	WHITE("White"), 
	ASIAN("Asian"), 
	NATIVE("Native"), 
	BROWN("Brown");
	
	public String race;
	
	Race(String race) {
		this.race = race;
	}
	
	public static Race fromString(String race) {
		if(race.equals("Black")) {
			return Race.BLACK;
		} else if(race.equals("White")) {
			return Race.WHITE;
		} else if(race.equals("Asian")) {
			return Race.ASIAN;
		} else if(race.equals("Native")) {
			return Race.NATIVE;
		} else {
			return Race.BROWN;
		}
	}
}