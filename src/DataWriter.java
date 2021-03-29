/**
 * DataWriter, a JSON Writer for CriminalDatabaseSoftware
 * @author Brooks Robinson
 */
package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    
	/**
	 * Saves the Users to user.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each User
	 * @param user user being written
	 * @return JSONObject equivalent to a User
	 */
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ACCESS_LEVEL, user.getAccessLevel());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_USERNAME, user.getUserName());
		userDetails.put(USER_PASSWORD, user.getPassword());
        return userDetails;
    }

	/**
	 * Saves the Victims to victim.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Victim
	 * @param victim victim being written
	 * @return JSONObject equivalent to a Victim
	 */
	public static JSONObject getVictimJSON(Victim victim) {
		JSONObject victimDetails = new JSONObject();
		victimDetails.put(PERSON_FIRST_NAME, victim.getFirstName());
		victimDetails.put(PERSON_LAST_NAME, victim.getLastName());
		victimDetails.put(PERSON_ID, victim.getID());
		victimDetails.put(VICTIM_STATEMENT, victim.getStatement());
		victimDetails.put(VICTIM_IS_ALIVE, victim.getIsAlive());
		victimDetails.put(VICTIM_H_REPORTS, victim.getHospitalReports());
		return victimDetails;
	}

	/**
	 * Saves the Crimes to crime.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Crime
	 * @param crime crime being written
	 * @return JSONObject equivalent to a Crime
	 */
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

	/**
	 * Saves the Witnesses to witness.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Witness
	 * @param witness witness being written
	 * @return JSONObject equivalent to a Witness
	 */
	public static JSONObject getWitnessJSON(Witness witness) {
		JSONObject witnessDetails = new JSONObject();
		witnessDetails.put(PERSON_FIRST_NAME, witness.getFirstName());
		witnessDetails.put(PERSON_LAST_NAME, witness.getLastName());
		witnessDetails.put(PERSON_ID, witness.getID());
		witnessDetails.put(WITNESS_PHONE_NUMBER, witness.getPhoneNumber());
		witnessDetails.put(WITNESS_EMAIL, witness.getEmail());
		witnessDetails.put(WITNESS_STATEMENT, witness.getStatement());
		witnessDetails.put(WITNESS_RELATION_BAD, witness.getRelationToBadGuy());
		return witnessDetails;
	}

	/**
	 * Saves the Criminals inside of criminal.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Criminal
	 * @param criminal criminal being written
	 * @return JSONObject equivalent to a Criminal
	 */
	public static JSONObject getCriminalJSON(Criminal criminal) {
		JSONObject criminalDetails = new JSONObject();
		criminalDetails.put(PERSON_FIRST_NAME, criminal.getFirstName());
		criminalDetails.put(PERSON_LAST_NAME, criminal.getLastName());
		criminalDetails.put(PERSON_ID, criminal.getID());
		criminalDetails.put(PERSON_GENDER, criminal.getGender());
		criminalDetails.put(PERSON_RACE, criminal.getRace());
		criminalDetails.put(PERSON_HAIR_COLOR, criminal.getHairColor());
		criminalDetails.put(PERSON_HAIR_STYLE, criminal.getHairStyle());
		criminalDetails.put(PERSON_EYE_COLOR, criminal.getEyeColor());
		criminalDetails.put(PERSON_ADDRESS, criminal.getAddress());
		criminalDetails.put(PERSON_AGE, criminal.getAge());
		criminalDetails.put(POI_TATTOOS, criminal.getTattoos());
		criminalDetails.put(POI_GANG, criminal.getGang());
		criminalDetails.put(POI_VICTIM_RELATION, criminal.getVictimRelationship());
		criminalDetails.put(POI_EVIDENCE_CONN, criminal.getEvidenceConnection());
		criminalDetails.put(POI_IS_REPEAT_OFFENDER, criminal.getIsRepeatOffender());
		criminalDetails.put(SUSPECT_ACCOMPLICES, criminal.getAccomplices());
		criminalDetails.put(SUSPECT_FAMILY_MEMBERS, criminal.getFamilyMembers());
		criminalDetails.put(SUSPECT_FOOT_SIZE, criminal.getFootSize());
		criminalDetails.put(SUSPECT_PREFERRED_CLOTHES, criminal.getPrefferedClothes());
		criminalDetails.put(SUSPECT_NICKNAMES, criminal.getNickNames());
		criminalDetails.put(SUSPECT_COMMON_WORDS, criminal.getCommonWords());
		criminalDetails.put(SUSPECT_HOBBIES, criminal.getHobbies());
		criminalDetails.put(SUSPECT_JOB, criminal.getJob());
		criminalDetails.put(SUSPECT_PHYSICAL_TRAITS, criminal.getDistintPhysicalTraits());
		criminalDetails.put(CRIMINAL_CRIMES, criminal.getCrimes());
		criminalDetails.put(CRIMINAL_SENTENCE, criminal.getSentence());
		criminalDetails.put(CRIMINAL_STATUS, criminal.getStatus());
		criminalDetails.put(CRIMINAL_IN_CUSTODY, criminal.getInCustody());
		return criminalDetails;
	}

	/**
	 * Saves the Evidences to evidence.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Evidence
	 * @param evidence Evidence being written
	 * @return JSONObject equivalent to a Evidence
	 */
	public static JSONObject getEvidenceJSON(Evidence evidence) {
		JSONObject evidenceDetails = new JSONObject();
		evidenceDetails.put(EVIDENCE_ID, evidence.getID());
		evidenceDetails.put(EVIDENCE_DESCRIPTION, evidence.getDescription());
		evidenceDetails.put(EVIDENCE_DISC_DATE, evidence.getDateOfDiscovery());
		return evidenceDetails;
	}

	/**
	 * Saves the Officers to officer.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Officer
	 * @param officer Officer being written
	 * @return JSONObject equivalent to a Officer
	 */
	public static JSONObject getOfficerJSON(Officer officer) {
		JSONObject officerDetails = new JSONObject();
		officerDetails.put(PERSON_FIRST_NAME, officer.getFirstName());
		officerDetails.put(PERSON_LAST_NAME, officer.getLastName());
		officerDetails.put(OFFICER_TYPE, officer.getTypeOfOfficer());
		officerDetails.put(OFFICER_STATEMENT, officer.getStatement());
		return officerDetails;
	}

	/**
	 * Saves the People to person.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each Person
	 * @param person Person being written
	 * @return JSONObject equivalent to a Person
	 */
	public static JSONObject getPersonJSON(Person person) {
		JSONObject personDetails = new JSONObject();
		personDetails.put(PERSON_FIRST_NAME, person.getFirstName());
		personDetails.put(PERSON_LAST_NAME, person.getLastName());
		personDetails.put(PERSON_ID, person.getID());
		personDetails.put(PERSON_GENDER, person.getGender());
		personDetails.put(PERSON_RACE, person.getRace());
		personDetails.put(PERSON_HAIR_COLOR, person.getHairColor());
		personDetails.put(PERSON_HAIR_STYLE, person.getHairStyle());
		personDetails.put(PERSON_EYE_COLOR, person.getEyeColor());
		personDetails.put(PERSON_ADDRESS, person.getAddress());
		personDetails.put(PERSON_AGE, person.getAge());
		return personDetails;
	}

	/**
	 * Saves the POIs to poi.json
	 */
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

	/**
	 * Creates parameters inside a JSONObject for each POI
	 * @param poi POI being written
	 * @return JSONObject equivalent to a POI
	 */
	public static JSONObject getPOIJSON(POI poi) {
		JSONObject poiDetails = new JSONObject();
		poiDetails.put(PERSON_FIRST_NAME, poi.getFirstName());
		poiDetails.put(PERSON_LAST_NAME, poi.getLastName());
		poiDetails.put(PERSON_ID, poi.getID());
		poiDetails.put(PERSON_GENDER, poi.getGender());
		poiDetails.put(PERSON_RACE, poi.getRace());
		poiDetails.put(PERSON_HAIR_COLOR, poi.getHairColor());
		poiDetails.put(PERSON_HAIR_STYLE, poi.getHairStyle());
		poiDetails.put(PERSON_EYE_COLOR, poi.getEyeColor());
		poiDetails.put(PERSON_ADDRESS, poi.getAddress());
		poiDetails.put(PERSON_AGE, poi.getAge());
		poiDetails.put(POI_TATTOOS, poi.getTattoos());
		poiDetails.put(POI_GANG, poi.getGang());
		poiDetails.put(POI_VICTIM_RELATION, poi.getVictimRelationship());
		poiDetails.put(POI_EVIDENCE_CONN, poi.getEvidenceConnection());
		poiDetails.put(POI_IS_REPEAT_OFFENDER, poi.getIsRepeatOffender());
		return poiDetails;
	}

	/**
	 * Saves the Suspects to suspect.json
	 */
	public static void saveSuspects() {
		Suspects suspects = Suspects.getInstance();
		ArrayList<Suspect> suspectList = suspects.getSuspects();
		JSONArray jsonSuspects = new JSONArray();

		for (int i = 0; i < suspectList.size(); ++i) {
			jsonSuspects.add(getSuspectJSON(suspectList.get(i)));
		}

		try (FileWriter file = new FileWriter(SUSPECT_FILE_NAME)) {
			file.write(jsonSuspects.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates parameters inside a JSONObject for each Suspect
	 * @param suspect Suspect being written
	 * @return JSONObject equivalent to a Suspect
	 */
	public static JSONObject getSuspectJSON(Suspect suspect) {
		JSONObject suspectDetails = new JSONObject();
		suspectDetails.put(PERSON_FIRST_NAME, suspect.getFirstName());
		suspectDetails.put(PERSON_LAST_NAME, suspect.getLastName());
		suspectDetails.put(PERSON_ID, suspect.getID());
		suspectDetails.put(PERSON_GENDER, suspect.getGender());
		suspectDetails.put(PERSON_RACE, suspect.getRace());
		suspectDetails.put(PERSON_HAIR_COLOR, suspect.getHairColor());
		suspectDetails.put(PERSON_HAIR_STYLE, suspect.getHairStyle());
		suspectDetails.put(PERSON_EYE_COLOR, suspect.getEyeColor());
		suspectDetails.put(PERSON_ADDRESS, suspect.getAddress());
		suspectDetails.put(PERSON_AGE, suspect.getAge());
		suspectDetails.put(POI_TATTOOS, suspect.getTattoos());
		suspectDetails.put(POI_GANG, suspect.getGang());
		suspectDetails.put(POI_VICTIM_RELATION, suspect.getVictimRelationship());
		suspectDetails.put(POI_EVIDENCE_CONN, suspect.getEvidenceConnection());
		suspectDetails.put(POI_IS_REPEAT_OFFENDER, suspect.getIsRepeatOffender());
		suspectDetails.put(SUSPECT_ACCOMPLICES, suspect.getAccomplices());
		suspectDetails.put(SUSPECT_FAMILY_MEMBERS, suspect.getFamilyMembers());
		suspectDetails.put(SUSPECT_FOOT_SIZE, suspect.getFootSize());
		suspectDetails.put(SUSPECT_PREFERRED_CLOTHES, suspect.getPrefferedClothes());
		suspectDetails.put(SUSPECT_NICKNAMES, suspect.getNickNames());
		suspectDetails.put(SUSPECT_COMMON_WORDS, suspect.getCommonWords());
		suspectDetails.put(SUSPECT_HOBBIES, suspect.getHobbies());
		suspectDetails.put(SUSPECT_JOB, suspect.getJob());
		suspectDetails.put(SUSPECT_PHYSICAL_TRAITS, suspect.getDistintPhysicalTraits());
		return suspectDetails;
	}

	/**
	 * Saves the HospitalReports to hospital.json
	 */
	public static void saveHospitalReports() {
		HospitalReports hreports = HospitalReports.getInstance();
		ArrayList<HospitalReport> hreportList = hreports.getHReports();
		JSONArray jsonHreports = new JSONArray();

		for (int i = 0; i < hreportList.size(); ++i) {
			jsonHreports.add(getHReportsJSON(hreportList.get(i)));
		}

		try (FileWriter file = new FileWriter(HOSPITAL_FILE_NAME)) {
			file.write(jsonHreports.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates parameters inside a JSONObject for each HospitalReport
	 * @param report HospitalReport being written
	 * @return JSONObject equivalent to a HospitalReport
	 */
	public static JSONObject getHReportsJSON(HospitalReport report) {
		JSONObject hreportDetails = new JSONObject();
		hreportDetails.put(HOSPITAL_ID, report.getID());
		hreportDetails.put(HOSPITAL_DIAGNOSIS, report.getDiagnosis());
		hreportDetails.put(HOSPITAL_CAUSE, report.getCause());
		hreportDetails.put(HOSPITAL_DOCTOR, report.getDoctor());
		hreportDetails.put(HOSPITAL_NURSE, report.getNurse());
		hreportDetails.put(HOSPITAL_DATE, report.getDateAdmitted());
		hreportDetails.put(HOSPITAL_NUM_DAYS, report.getNumDaysAdmitted());
		return hreportDetails;
	}
}