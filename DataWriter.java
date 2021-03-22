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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
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
		// TODO complete
	}
}