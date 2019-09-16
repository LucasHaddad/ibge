package aed2.model.enumeration;

public enum CivilStatus {
	SINGLE("Single"), 
	MARRIED("Married"), 
	DIVORCED("Divorced"), 
	WIDOW("Widow");
	
	public String status;
	
	CivilStatus(String status) {
		this.status = status;
	}
	
	public static CivilStatus fromString(String civilStatus) {
		if(civilStatus.equals("Single")) {
			return CivilStatus.SINGLE;
		} else if(civilStatus.equals("Married")) {
			return CivilStatus.MARRIED;
		} else if(civilStatus.equals("Divorced")) {
			return CivilStatus.DIVORCED;
		} else {
			return CivilStatus.WIDOW;
		}
	}
}