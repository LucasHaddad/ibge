package aed2.model.enumeration;

public enum Sex {
	MALE("M"), 
	FEMALE("F");
	
	public String sex;
	
	Sex(String sex) {
		this.sex = sex;
	}
	
	public static Sex fromString(String sex) {
		if(sex.equals("M")) {
			return Sex.MALE;
		} else {
			return Sex.FEMALE;
		}
	}
}