import java.util.ArrayList;

public class Officers {
	private static Officers officers;
	private ArrayList<Officer> officerList;
	
	private Officers() {
		officerList = DataLoader.loadOfficer();
	}
	
	public static Officers getInstance() {
		if(officers == null) {
			officers = new Officers();
		}
		return officers;
	}
	
	//check if have criminal.
	public boolean haveOfficer(String officerName) {
		for(Officer officer : officerList) {
			if(officer.getOfficerName().equals(officerName)) 
				return true;
		}
		return false;
	}
	
	
	public Officer getOfficer(String officerName) {
		for(Officer officer: officerList) {
			if(officer.getOfficerName().equals(officerName)) {
				return officer;
			}
		}
		return null;
	}
	
	public ArrayList<Officer> getOfficers(){
		return officerList;
	}
	
	public boolean addOfficer(String firstName,  String lastName) {
		if(haveOfficer(firstName))
			return false;
		officerList.add(new Officer(firstName, lastName));
		return true;
	}
	
	public void saveOfficers() {
		DataWriter.saveOfficers();
	}



}
