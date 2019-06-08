package aed2.model.enumeration;

public enum Area {
	URBAN("Urban"), 
	RURAL("Rural");
	
	public String area;
	
	Area(String area) {
		this.area = area;
	}
	
	public static Area fromString(String area) {
		if(area.equals("Urban")) {
			return Area.URBAN;
		} else {
			return Area.RURAL;
		}
	}
}