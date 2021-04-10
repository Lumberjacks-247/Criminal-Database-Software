package src;
//import java.util.ArrayList;
public class Facade {

	// private People people;
	private Crimes crime;
	private Users users;
	// private User currentUser;
	private Criminals criminals;
	// private Evidences evidence;
	// private Officers officer;
	// private POIs poi;
	private Suspects suspects;
	// private Victims victim;
	// private Witnesses witness;
	// private HospitalReports hospitalreport;

	/**
	 * creates instances of each, users, people, crimes, criminals, evidences, officers, pois, suspects, victims, witnesses, hospital reports.
	 */
	public Facade() {


		users = Users.getInstance();
		// people = People.getInstance(); 
		crime = Crimes.getInstance();
		criminals = Criminals.getInstance();
		// evidence = Evidences.getInstance();
		// officer = Officers.getInstance();
		// poi = POIs.getInstance();
		suspects = Suspects.getInstance();
		// victim = Victims.getInstance();
		// witness = Witnesses.getInstance();
		// hospitalreport = HospitalReports.getInstance();
	}
	/*
	public boolean findPerson(String personName) {
		return people.havePerson(personName);
	}

	/**
	 * Checks if the person is within the json files.
	 * @param personName person name
	 * @return returns if the person is within the json files.
	 */
	// public boolean checkPerson(String personName) {
	// 	if(!findPerson(personName)) 
	// 		return false;
	// 	return true;
	// }

	/**
	 * Edits the persons information
	 * @param personName person name
	 * @param editInfo information thats edited.
	 * @return returns if the information was submitted.
	 */
	/*
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

  */
	public Crime findCrime(String crimeName) {
		return crime.findCrime(crimeName);
	}
  /*
	public boolean checkCrime(String crimeName) {
		if(!findCrime(crimeName)) 
			return false;
		return true;
	}

	/**
	 * edits information in crime
	 * @param crimeName crime name
	 * @param editInfo edited information
	 * @return returns edited info
	 */
	// 
	// public boolean editCrime(String crimeName, String editInfo) {
	// 	if(findCrime(crimeName) && editInfo.matches(".*[a-z].*"	))
	// 		return true;
	// 	return false;
	// }
	// 
	/**
	 * adds new crime into json
	 * @param crimeName crime name
	 * @param newCrime new name for crime
	 * @return returns if new information was added.
	 */
	// public boolean addCrime(String crimeName, String newCrime) {
	// 	if(!findCrime(crimeName)) {
	// 		criminal.addCriminal(null, null, null, null, null, false);
	// 		return false;
	// 	}
	// 	return true;
	// }
	
	public boolean createAccount(String userName, String firstName, String lastName, int accessLevel, String userPassword)
	{
		return users.addUser(userName,  firstName,  lastName,  accessLevel,  userPassword);
	}
	/*
  */
	// public boolean findUser(String username, String password) {
	// 	return users.haveUser(username, password);
	// }
	// /*
	// public User getCurrentUser() {
	// 	return currentUser;
	// }
	
	public boolean login(String username, String password) {
		if(!users.haveUser(username, password))
			return false;
      
		//currentUser = users.getUser(userName);
		return true;
	}

	/**
	 * logs out user and saves user information.
	 */
	public void logout() {
		users.saveUsers();
	}
	/*
	public boolean findCriminal(String criminalName) {
		return criminal.haveCriminal(criminalName);
	}

	/**
	 * checks if criminal is in the json files.
	 * @param criminalName criminal name
	 * @return returns if criminal is found.
// 	 */
// 
// 	public boolean checkCriminal(String criminalName) {
// 		if(!findCriminal(criminalName)) 
// 			return false;
// 		return true;
// 	}

	/**
	 * edits the criminal.
	 * @param criminalName criminal name
	 * @param editInfo edited information
	 * @return returns the edited information.
	 */
	
	// public boolean editCriminal(String criminalName, String editInfo) {
	// 	if(findCriminal(criminalName) && editInfo.matches(".*[a-z].*"	))
	// 		return true;
	// 	return false;
	// }
	// 
	/**
	 * Adds a criminal into the json files.
	 * @param criminalName criminal name
	//  * @param newCriminal new criminal name
	//  * @return returns if the criminal is already in there, if not, adds it.
	//  */
	// public boolean addCriminal(String criminalName, String newCriminal) {
	// 	if(!findCriminal(criminalName)) {
	// 		criminal.addCriminal(null, null, null, null, null, false);
	// 		return false;
	// 	}
	// 	return true;
	// }
	// 
	/**
// 	 * finds evidence in json files.
// 	 * @param evidenceName evidence name
// 	 * @return returns if found.
// 	 */
// 	public boolean findEvidence(String evidenceName) {
// 		return evidence.haveEvidence(evidenceName);
// 	}
// 
// 	/**
// 	 * checks if evidence is in json files.
// 	 * @param evidenceName evidence name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkEvidence(String evidenceName) {
// 		if(!findEvidence(evidenceName)) 
// 			return false;
// 		return true;
//}
	
	/**
	 * edits evidence
	 * @param evidenceName evidence name
	 * @param editInfo edited evidence information
	 * @return returns if evidence is changed.
	 */
// 	public boolean editEvidence(String evidenceName, String editInfo) {
// 		if(findEvidence(evidenceName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds new evidence. 
// 	 * @param evidenceName evidence name
// 	 * @param newEvidence new evidence
// 	 * @return checks if evidence is already there, if not, it adds.
// 	 */
// 	public boolean addEvidence(String evidenceName, String newEvidence) {
// 		if(!findEvidence(evidenceName)) {
// 			evidence.addEvidences(null, 0, null, null);
// 			return false;
// 		}
// 		return true;
// 	}
// 	
// 	/**
// 	 * finds officer in json files.
// 	 * @param officerName officer name
// 	 * @return returns if found.
// 	 */
// 	public boolean findOfficer(String officerName) {
// 		return officer.haveOfficer(officerName);
// 	}
// 
// 
// 	/**
// 	 * checks if officer is in json files.
// 	 * @param officerName officer name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkOfficer(String officerName) {
// 		if(!findOfficer(officerName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits officer information
// 	 * @param officerName officer name
// 	 * @param editInfo edited officer information
// 	 * @return returns if officer information is changed.
// 	 */
// 	public boolean editOfficer(String officerName, String editInfo) {
// 		if(findOfficer(officerName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds new officer. 
// 	 * @param officerName officer name
// 	 * @param newOfficer new officer
// 	 * @return checks if officer is already there, if not, it adds.
// 	 */
// 	public boolean addOfficer(String officerName, String newOfficer) {
// 		if(!findOfficer(officerName)) {
// 			officer.addOfficer(null, null, newOfficer, newOfficer);
// 			return false;
// 		}
// 		return true;
// 	}
// 	
// 	/**
// 	 * finds POI in json files.
// 	 * @param poiName poi name
// 	 * @return returns if found.
// 	 */
// 	public boolean findPOI(String poiName) {
// 		return poi.havePOI(poiName);
// 	}
// 
// 
// 	/**
// 	 * checks if POI is in json files.
// 	 * @param POIName poi name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkPOI(String poiName) {
// 		if(!findPOI(poiName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits POI information
// 	 * @param poiName poi name
// 	 * @param editInfo edited poi information
// 	 * @return returns if poi information is changed.
// 	 */
// 	public boolean editPOI(String poiName, String editInfo) {
// 		if(findPOI(poiName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds new poi. 
// 	 * @param poiName poi name
// 	 * @return checks if poi is already there, if not, it adds.
// 	 */
// 	public boolean addPOI(String poiName) {
// 		if(!findPOI(poiName)) {
// 			poi.addPOI(null, null, poiName, poiName, poiName, poiName, null);
// 			return false;
// 		}
// 		return true;
// 	}
// 	

    public Suspect[] searchSuspects(Suspect partial) {
      return suspects.searchSuspects(partial);
    }

    public Criminal[] searchCriminals(Criminal partial) {
      return criminals.searchCriminals(partial);
    }
// 	/**
// 	 * finds suspect in json files.
// 	 * @param suspectName suspect name
// 	 * @return returns if found.
// 	 */
// 	public boolean findSuspect(String suspectName) {
// 		return suspect.haveSuspect(suspectName);
// 	}
// 
// 
// 	/**
// 	 * checks if suspect is in json files.
// 	 * @param SuspectName suspect name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkSuspect(String suspectName) {
// 		if(!findSuspect(suspectName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits suspect information
// 	 * @param suspectName suspect name
// 	 * @param editInfo edited suspect information
// 	 * @return returns if suspect information is changed.
// 	 */
// 	public boolean editSuspect(String suspectName, String editInfo) {
// 		if(findSuspect(suspectName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds new suspect. 
// 	 * @param suspectName suspect name
// 	 * @return checks if suspect is already there, if not, it adds.
// 	 */
// 	public boolean addSuspect(String suspectName) {
// 		if(!findSuspect(suspectName)) {
// 			suspect.addSuspect(suspectName, suspectName, suspectName, suspectName, null, suspectName, suspectName, suspectName, suspectName, suspectName, suspectName);
// 			return false;
// 		}
// 		return true;
// 	}
// 	
// 	/**
// 	 * finds victim in json files.
// 	 * @param victimName victim name
// 	 * @return returns if found.
// 	 */
// 	public boolean findVictim(String victimName) {
// 		return victim.haveVictim(victimName);
// 	}
// 
// 
// 	/**
// 	 * checks if victim is in json files.
// 	 * @param victimName victim name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkVictim(String victimName) {
// 		if(!findVictim(victimName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits victim information
// 	 * @param victimName victim name
// 	 * @param editInfo edited victim information
// 	 * @return returns if victim information is changed.
// 	 */
// 	public boolean editVictim(String victimName, String editInfo) {
// 		if(findVictim(victimName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds a new victim to json files.
// 	 * @param firstName first name
// 	 * @param lastName last name
// 	 * @param statement statement from victim
// 	 * @param isAlive if victim is alive
// 	 * @param hReports hospital report
// 	 * @return returns if the victim is in json files already, if not, adds new victim.
// 	 */
// 	public boolean addVictim(String firstName,  String lastName, String statement, boolean isAlive, ArrayList <HospitalReport> hReports) {
// 		if(!findWitness(firstName)) {
// 			victim.addVictim(firstName, lastName, statement, isAlive, hReports);
// 			return false;
// 		}
// 		return true;
// 	}
// 	
// 	/**
// 	 * finds witness in json files.
// 	 * @param witnessName witness name
// 	 * @return returns if found.
// 	 */
// 	public boolean findWitness(String witnessName) {
// 		return witness.haveWitness(witnessName);
// 	}
// 
// 	/**
// 	 * checks if witness is in json files.
// 	 * @param witnessName witness name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkWitness(String witnessName) {
// 		if(!findWitness(witnessName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits witness information
// 	 * @param WitnessName witness name
// 	 * @param editInfo edited witness information
// 	 * @return returns if witness information is changed.
// 	 */
// 	public boolean editWitness(String witnessName, String editInfo) {
// 		if(findWitness(witnessName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds new witness to json files
// 	 * @param witnessName witness name
// 	 * @return returns if witness is in json file already, if not, add new witness.
// 	 */
// 	public boolean addWitness(String witnessName) {
// 		if(!findWitness(witnessName)) {
// 			witness.addWitness(witnessName, witnessName, null, witnessName, witnessName, witnessName);
// 			return false;
// 		}
// 		return true;
// 	}
// 	
// 	/**
// 	 * finds hospital report in json files.
// 	 * @param hospitalReportName hospital report name
// 	 * @return returns if found.
// 	 */
// 	public boolean findHospitalReport(String hospitalReportName) {
// 		return hospitalreport.haveHReport(hospitalReportName);
// 	}
// 
// 	/**
// 	 * checks if hospital report is in json files.
// 	 * @param hospitalReportName hospital report name
// 	 * @return returns if its in the json files.
// 	 */
// 	public boolean checkHospitalReport(String hospitalReportName) {
// 		if(!findHospitalReport(hospitalReportName)) 
// 			return false;
// 		return true;
// 	}
// 	
// 	/**
// 	 * edits hospital report information
// 	 * @param hositalReportName hospital report name
// 	 * @param editInfo edited hospital report information
// 	 * @return returns if hospital report information is changed.
// 	 */
// 	public boolean editHospitalReport(String hospitalReportName, String editInfo) {
// 		if(findHospitalReport(hospitalReportName) && editInfo.matches(".*[a-z].*"	))
// 			return true;
// 		return false;
// 	}
// 	
// 	/**
// 	 * adds a new hospital report.
// 	 * @param hospitalReportName hospital report name
// 	 * @return checks if hospital report is already in the system, if its not, adds a new report.
// 	 */
// 	public boolean addHospitalReport(String hospitalReportName) {
// 		if(!findHospitalReport(hospitalReportName)) {
// 			hospitalreport.addHReport(null,null,null,null,null,null,0);
// 			return false;
// 		}
// 		return true;
// 	}

  
	
}
