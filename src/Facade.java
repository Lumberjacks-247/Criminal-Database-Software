package src;
public class Facade {

	// private People people;
	// private Crimes crime;
	private Users users;
	// private User currentUser;
	// private Criminals criminal;
	// private Evidences evidence;
	// private Officers officer;
	// private POIs poi;
	// private Suspects suspect;
	// private Victims victim;
	// private Witnesses witness;
	// private HospitalReports hospitalreport;

	
	public Facade() {


		users = Users.getInstance();
		// people = People.getInstance(); 
		// crime = Crimes.getInstance();
		// criminal = Criminals.getInstance();
		// evidence = Evidences.getInstance();
		// officer = Officers.getInstance();
		// poi = POIs.getInstance();
		// suspect = Suspects.getInstance();
		// victim = Victims.getInstance();
		// witness = Witnesses.getInstance();
		// hospitalreport = HospitalReports.getInstance();
	}
	/*
	public boolean findPerson(String personName) {
		return people.havePerson(personName);
	}

	public boolean checkPerson(String personName) {
		if(!findPerson(personName)) 
			return false;
		return true;
	}
	
	public boolean editPerson(String personName, String editInfo) {
		if(findPerson(personName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addPerson(String personName, String newPerson) {
		if(!findPerson(personName)) {
			person.addPerson(null, null, null, null, null, null, null, null, null, null);
			return false;
		}
		return true;
	}

	public boolean findCrime(String crimeName) {
		return crime.haveCrime(crimeName);
	}

	public boolean checkCrime(String crimeName) {
		if(!findCrime(crimeName)) 
			return false;
		return true;
	}
	
	public boolean editCrime(String crimeName, String editInfo) {
		if(findCrime(crimeName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addCrime(String crimeName, String newCrime) {
		if(!findCrime(crimeName)) {
			criminal.addCriminal(null, null, null, null, null, false);
			return false;
		}
		return true;
	}
	*/
	public boolean createAccount(String userName, String firstName, String lastName, int accessLevel, String userPassword)
	{
		return users.addUser(userName,  firstName,  lastName,  accessLevel,  userPassword);
	}
	/*
  */
	public boolean findUser(String username, String password) {
		return users.haveUser(username, password);
	}
	/*
	public User getCurrentUser() {
		return currentUser;
	}
	*/
	public boolean login(String username, String password) {
		if(!users.haveUser(username, password))
			return false;
      
		//currentUser = users.getUser(userName);
		return true;
	}

	public void logout() {
		users.saveUsers();
	}
	/*
	public boolean findCriminal(String criminalName) {
		return criminal.haveCriminal(criminalName);
	}

	public boolean checkCriminal(String criminalName) {
		if(!findCriminal(criminalName)) 
			return false;
		return true;
	}
	
	public boolean editCriminal(String criminalName, String editInfo) {
		if(findCriminal(criminalName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addCriminal(String criminalName, String newCriminal) {
		if(!findCriminal(criminalName)) {
			criminal.addCriminal(null, null, null, null, null, false);
			return false;
		}
		return true;
	}
	
	public boolean findEvidence(String evidenceName) {
		return evidence.haveEvidence(evidenceName);
	}

	public boolean checkEvidence(String evidenceName) {
		if(!findEvidence(evidenceName)) 
			return false;
		return true;
	}
	
	public boolean editEvidence(String evidenceName, String editInfo) {
		if(findEvidence(evidenceName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addEvidence(String evidenceName, String newEvidence) {
		if(!findEvidence(evidenceName)) {
			evidence.addEvidences(null, 0, null, null);
			return false;
		}
		return true;
	}
	
	public boolean findOfficer(String officerName) {
		return officer.haveOfficer(officerName);
	}

	public boolean checkOfficer(String officerName) {
		if(!findOfficer(officerName)) 
			return false;
		return true;
	}
	
	public boolean editOfficer(String officerName, String editInfo) {
		if(findOfficer(officerName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addOfficer(String officerName, String newOfficer) {
		if(!findOfficer(officerName)) {
			officer.addOfficer(null, null, newOfficer, newOfficer);
			return false;
		}
		return true;
	}
	
	public boolean findPOI(String poiName) {
		return poi.havePOI(poiName);
	}

	public boolean checkPOI(String poiName) {
		if(!findPOI(poiName)) 
			return false;
		return true;
	}
	
	public boolean editPOI(String poiName, String editInfo) {
		if(findPOI(poiName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addPOI(String poiName) {
		if(!findPOI(poiName)) {
			poi.addPOI(null, null, poiName, poiName, poiName, poiName, null);
			return false;
		}
		return true;
	}
	
	public boolean findSuspect(String suspectName) {
		return suspect.haveSuspect(suspectName);
	}

	public boolean checkSuspect(String suspectName) {
		if(!findSuspect(suspectName)) 
			return false;
		return true;
	}
	
	public boolean editSuspect(String suspectName, String editInfo) {
		if(findSuspect(suspectName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addSuspect(String suspectName) {
		if(!findSuspect(suspectName)) {
			suspect.addSuspect(suspectName, suspectName, suspectName, suspectName, null, suspectName, suspectName, suspectName, suspectName, suspectName, suspectName);
			return false;
		}
		return true;
	}
	
	public boolean findVictim(String victimName) {
		return victim.haveVictim(victimName);
	}

	public boolean checkVictim(String victimName) {
		if(!findVictim(victimName)) 
			return false;
		return true;
	}
	
	public boolean editVictim(String victimName, String editInfo) {
		if(findVictim(victimName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addVictim(String victimName) {
		if(!findVictim(victimName)) {
			victim.addVictim(victimName, victimName, victimName, false, null, victimName);
			return false;
		}
		return true;
	}
	
	public boolean findWitness(String witnessName) {
		return witness.haveWitness(witnessName);
	}

	public boolean checkWitness(String witnessName) {
		if(!findWitness(witnessName)) 
			return false;
		return true;
	}
	
	public boolean editWitness(String witnessName, String editInfo) {
		if(findWitness(witnessName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addWitness(String witnessName) {
		if(!findWitness(witnessName)) {
			witness.addWitness(witnessName, witnessName, null, witnessName, witnessName, witnessName);
			return false;
		}
		return true;
	}
	
	public boolean findHospitalReport(String hospitalReportName) {
		return hospitalreport.haveHReport(hospitalReportName);
	}

	public boolean checkHospitalReport(String hospitalReportName) {
		if(!findHospitalReport(hospitalReportName)) 
			return false;
		return true;
	}
	
	public boolean editHospitalReport(String hospitalReportName, String editInfo) {
		if(findHospitalReport(hospitalReportName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addHospitalReport(String hospitalReportName) {
		if(!findHospitalReport(hospitalReportName)) {
			hospitalreport.addHReport(null,null,null,null,null,null,0);
			return false;
		}
		return true;
	}

  */
	
}
