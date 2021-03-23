import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    
    public static void saveUsers() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); ++i) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ACCESS_LEVEL, user.getAccessLevel());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USERNAME, user.getUserName());
		userDetails.put(USER_PASSWORD, user.getPassword());
        return userDetails;
    }

	public static void saveVictims() {
		Victims victims = Victims.getInstance();
		ArrayList<Victim> victimList = victims.getVictims();
		JSONArray jsonVictims = new JSONArray();

		for (int i = 0; i < victimList.size(); ++i) {
			jsonVictims.add(getVictimJSON(victimList.get(i)));
		}

		try (FileWriter file = new FileWriter(VICTIM_FILE_NAME)) {
			file.write(jsonVictims.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getVictimJSON(Victim victim) {
		JSONObject victimDetails = new JSONObject();
		victimDetails.put(VICTIM_STATEMENT, victim.getStatement());
		victimDetails.put(VICTIM_IS_ALIVE, victim.getIsAlive());
		victimDetails.put(VICTIM_H_REPORTS, victim.getHospitalReports());
		return victimDetails;
	}

	public static void saveCrimes() {
		Crimes crimes = Crimes.getInstance();
		ArrayList<Crime> crimeList = crimes.getCrimes();
		JSONArray jsonCrimes = new JSONArray();

		for (int i = 0; i < crimeList.size(); ++i) {
			jsonCrimes.add(getCrimeJSON(crimeList.get(i)));
		}

		try (FileWriter file = new FileWriter(CRIMES_FILE_NAME)) {
			file.write(jsonCrimes.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getCrimeJSON(Crime crime) {
		JSONObject crimeDetails = new JSONObject();
		crimeDetails.put(CRIMES_ID, crime.getID());
		crimeDetails.put(CRIMES_TYPE_OF_CRIME, crime.getCrimeName());
		crimeDetails.put(CRIMES_CHARGE_LEVEL, crime.getLevelOfCharge());
		crimeDetails.put(CRIMES_JURISDICTION, crime.getJurisdiction());
		crimeDetails.put(CRIMES_IS_OPEN, crime.getIsOpen());
		crimeDetails.put(CRIMES_AUTHOR, crime.getAuthor());
		crimeDetails.put(CRIMES_LOCATION, crime.getLocation());
		crimeDetails.put(CRIMES_POI, crime.getPois());
		crimeDetails.put(CRIMES_SUSPECTS, crime.getSuspects());
		crimeDetails.put(CRIMES_CRIMINALS, crime.getCriminals());
		crimeDetails.put(CRIMES_VICTIMS, crime.getVictims());
		crimeDetails.put(CRIMES_WITNESSES, crime.getWitnesses());
		crimeDetails.put(CRIMES_OFFICERS, crime.getOfficers());
		crimeDetails.put(CRIMES_EVIDENCE, crime.getEvidence());
		return crimeDetails;
	}

	public static void saveWitnesses() {
		Witnesses witnesses = Witnesses.getInstance();
		ArrayList<Witness> witnessList = witnesses.getWitnesses();
		JSONArray jsonWitnesses = new JSONArray();

		for (int i = 0; i < witnessList.size(); ++i) {
			jsonWitnesses.add(getWitnessJSON(witnessList.get(i)));
		}

		try (FileWriter file = new FileWriter(WITNESS_FILE_NAME)) {
			file.write(jsonWitnesses.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getWitnessJSON(Witness witness) {
		JSONObject witnessDetails = new JSONObject();
		witnessDetails.put(WITNESS_PHONE_NUMBER, witness.getPhoneNumber());
		witnessDetails.put(WITNESS_EMAIL, witness.getEmail());
		witnessDetails.put(WITNESS_STATEMENT, witness.getStatement());
		witnessDetails.put(WITNESS_RELATION_BAD, witness.getRelationToBadGuy());
		return witnessDetails;
	}

	public static void saveCriminals() {
		Criminals criminals = Criminals.getInstance();
		ArrayList<Criminal> criminalList = criminals.getCriminals();
		JSONArray jsonCriminals = new JSONArray();

		for (int i = 0; i < criminalList.size(); ++i) {
			jsonCriminals.add(getCriminalJSON(criminalList.get(i)));
		}

		try (FileWriter file = new FileWriter(CRIMINAL_FILE_NAME)) {
			file.write(jsonCriminals.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getCriminalJSON(Criminal criminal) {
		JSONObject criminalDetails = new JSONObject();
		criminalDetails.put(CRIMINAL_CRIMES, criminal.getCrimes());
		criminalDetails.put(CRIMINAL_SENTENCE, criminal.getSentence());
		criminalDetails.put(CRIMINAL_STATUS, criminal.getStatus());
		criminalDetails.put(CRIMINAL_IN_CUSTODY, criminal.getInCustody());
		return criminalDetails;
	}

	public static void saveEvidences() {
		Evidences evidences = Evidences.getInstance();
		ArrayList<Evidence> evidenceList = evidences.getEvidences();
		JSONArray jsonEvidences = new JSONArray();

		for (int i = 0; i < evidenceList.size(); ++i) {
			jsonEvidences.add(getEvidenceJSON(evidenceList.get(i)));
		}

		try (FileWriter file = new FileWriter(EVIDENCE_FILE_NAME)) {
			file.write(jsonEvidences.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getEvidenceJSON(Evidence evidence) {
		JSONObject evidenceDetails = new JSONObject();
		evidenceDetails.put(EVIDENCE_ID, evidence.getID());
		evidenceDetails.put(EVIDENCE_DESCRIPTION, evidence.getDescription());
		evidenceDetails.put(EVIDENCE_DISC_DATE, evidence.getDateOfDiscovery());
		return evidenceDetails;
	}

	public static void saveOfficers() {
		Officers officers = Officers.getInstance();
		ArrayList<Officer> officerList = officers.getOfficers();
		JSONArray jsonOfficers = new JSONArray();

		for (int i = 0; i < officerList.size(); ++i) {
			jsonOfficers.add(getOfficerJSON(officerList.get(i)));
		}

		try (FileWriter file = new FileWriter(OFFICER_FILE_NAME)) {
			file.write(jsonOfficers.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getOfficerJSON(Officer officer) {
		JSONObject officerDetails = new JSONObject();
		officerDetails.put(OFFICER_TYPE, officer.getTypeOfOfficer());
		officerDetails.put(OFFICER_STATEMENT, officer.getStatement());
		return officerDetails;
	}

	public static void savePeople() {
		People people = People.getInstance();
		ArrayList<Person> personList = people.getPeople();
		JSONArray jsonPeople = new JSONArray();

		for (int i = 0; i < personList.size(); ++i) {
			jsonPeople.add(getPersonJSON(personList.get(i)));
		}

		try (FileWriter file = new FileWriter(PERSON_FILE_NAME)) {
			file.write(jsonPeople.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getPersonJSON(Person person) {
		JSONObject personDetails = new JSONObject();
		personDetails.put(PERSON_FIRST_NAME, person.getFirstName());
		personDetails.put(PERSON_LAST_NAME, person.getLastName());
		personDetails.put(PERSON_ID, person.getID());
		personDetails.put(PERSON_GENDER, person.getGender());
		personDetails.put(PERSON_RACE, person.getRace());
		//personDetails.put(PERSON_HEIGHT_IN, person.get
		//personDetails.put(PERSON_WEIGHT, person.get
		personDetails.put(PERSON_HAIR_COLOR, person.getHairColor());
		personDetails.put(PERSON_HAIR_STYLE, person.getHairStyle());
		personDetails.put(PERSON_EYE_COLOR, person.getEyeColor());
		personDetails.put(PERSON_ADDRESS, person.getAddress());
		personDetails.put(PERSON_AGE, person.getAge());
		return personDetails;
	}

	public static void savePOIs() {
		POIs pois = POIs.getInstance();
		ArrayList<POI> poiList = pois.getPOIs();
		JSONArray jsonPois = new JSONArray();

		for (int i = 0; i < poiList.size(); ++i) {
			jsonPois.add(getPOIJSON(poiList.get(i)));
		}

		try (FileWriter file = new FileWriter(POI_FILE_NAME)) {
			file.write(jsonPois.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getPOIJSON(POI poi) {
		JSONObject poiDetails = new JSONObject();
		poiDetails.put(POI_TATTOOS, poi.getTattoos());
		poiDetails.put(POI_GANG, poi.getGang());
		poiDetails.put(POI_VICTIM_RELATION, poi.getVictimRelationship());
		poiDetails.put(POI_EVIDENCE_CONN, poi.getEvidenceConnection());
		poiDetails.put(POI_IS_REPEAT_OFFENDER, poi.getIsRepeatOffender());
		return poiDetails;
	}

	public static void saveSuspects() {
		Suspects suspects = Suspects.getInstance();
		ArrayList<Suspect> suspectList = suspects.getSuspects();
		JSONArray jsonSuspects = new JSONArray();

		for (int i = 0; i < suspectList.size(); ++i) {
			jsonSuspects.add(getSuspectJSON(suspectList.get(i)));
		}

		try (FileWriter file = new FileWriter(SUSPECTS_FILE_NAME)) {
			file.write(jsonSuspects.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getSuspectJSON(Suspect suspect) {
		JSONObject suspectDetails = new JSONObject();
		suspectDetails.put(SUSPECTS_ACCOMPLICES, suspect.getAccomplice());
		suspectDetails.put(SUSPECTS_FAMILY_MEMBERS, suspect.getFamilyMember());
		suspectDetails.put(SUSPECTS_FOOT_SIZE, suspect.getFootSize());
		suspectDetails.put(SUSPECTS_PREFERRED_CLOTHES, suspect.getPrefferedClothes());
		suspectDetails.put(SUSPECTS_NICKNAMES, suspect.getNickNames());
		suspectDetails.put(SUSPECTS_COMMON_WORDS, suspect.getCommonWords());
		suspectDetails.put(SUSPECTS_HOBBIES, suspect.getHobbies());
		suspectDetails.put(SUSPECTS_JOB, suspect.getJob());
		suspectDetails.put(SUSPECTS_PHYSICAL_TRAITS, suspect.getDistintPhysicalTraits());
		return suspectDetails;
	}
}