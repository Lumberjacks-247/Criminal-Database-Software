import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Iterator;

public class DataLoader extends DataConstants {
    public static ArrayList<Person> loadPeople() {
        ArrayList<Person> people = new ArrayList<Person>();

        try {
            FileReader reader = new FileReader(PERSON_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); ++i) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String id = (String)personJSON.get(PERSON_ID);
                String firstName = (String)personJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)personJSON.get(PERSON_LAST_NAME);
                String sex = (String)personJSON.get(PERSON_SEX);
                String birthday = (String)personJSON.get(PERSON_BIRTHDAY);
                int heightFt = ((Long)personJSON.get(PERSON_HEIGHT_FT)).intValue();
                int heightIn = ((Long)personJSON.get(PERSON_HEIGHT_IN)).intValue();
                int weight = ((Long)personJSON.get(PERSON_WEIGHT)).intValue();
                boolean isJuvenile = (Boolean)personJSON.get(PERSON_IS_JUVENILE);
                String address = (String)personJSON.get(PERSON_ADDRESS);
                String city = (String)personJSON.get(PERSON_CITY);
                String state = (String)personJSON.get(PERSON_STATE);
                String zip  = (String)personJSON.get(PERSON_ZIP);
                String eyeColor = (String)personJSON.get(PERSON_EYE_COLOR);
                String race = (String)personJSON.get(PERSON_RACE);
                people.add(new Person(firstName, lastName, id, sex, race, /* VAR FOR HAIR COLOR*/, 
                                      /* VAR FOR HAIR STYLE */, /* VAR FOR EYE COLOR */, address, /* VAR FOR AGE */));
            }

            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Crime> loadCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();

        try {
            FileReader reader = new FileReader(CRIMES_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < crimesJSON.size(); ++i) {
                JSONObject crimeJSON = (JSONObject)crimeJSON.get(i);
                String id = (String)crimeJSON.get(CRIMES_ID);
                String crime = (String)crimeJSON.get(CRIMES_CRIME);
                int numCriminals = ((Long)crimeJSON.get(CRIMES_NUM_CRIMINALS)).intValue(); // long int value, not integer
                // ADD INTAKE FOR ARRAY OF CRIMINALS
                String[] criminals = new String[numCriminals];
                JSONArray criminalsJSON = (JSONArray)crimeJSON.get(CRIMES_CRIMINALS);
                Iterator<String> cjsIterator = criminalsJSON.iterator();
                for (int j = 0; j < numCriminals; ++j) {
                    if (cjsIterator.hasNext()) {
                        criminals[j] = cjsIterator.next();
                    }
                }
                int numVictims = ((Long)crimeJSON.get(CRIMES_NUM_VICTIMS)).intValue();
                // ADD INTAKE FOR ARRAY OF VICTIMS
                int numPOI = ((Long)crimeJSON.get(CRIMES_NUM_POI)).intValue();
                // ADD INTAKE FOR ARRAY OF POI
                int numWitnesses = ((Long)crimeJSON.get(CRIMES_NUM_WITNESSES)).intValue();
                // ADD INTAKE FOR ARRAY OF WITNESSES
                int numSuspects = ((Long)crimeJSON.get(CRIMES_NUM_SUSPECTS)).intValue();
                // ADD INTAKE FOR ARRAY OF SUSPECTS
                int numEvidence = ((Long)crimeJSON.get(CRIMES_NUM_EVIDENCE)).intValue();
                // ADD INTAKE FOR EVIDENCE
                int numReports = ((Long)crimeJSON.get(CRIMES_NUM_REPORTS)).intValue();
                // ADD INTAKE FOR REPORTS
                crimes.add(new Crime(id, crime, /* REST OF INFO */));
            }

            return crimes;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Criminal> loadCriminals() {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();

        try {
            FileReader reader = new FileReader(CRIMINAL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray criminalsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < criminalsJSON.size(); ++i) {
                JSONObject criminalJSON = (JSONObject)criminalsJSON.get(i);
                int numCrimes = ((Long)criminalJSON.get(CRIMINAL_NUM_CRIMES)).intValue();
                // ADD INTAKE FOR ARRAY OF CRIMES
                boolean isViolent = (Boolean)criminalJSON.get(CRIMINAL_IS_VIOLENT);
                String gang = (String)criminalJSON.get(CRIMINAL_GANG);
                int shoeSize = ((Long)criminalJSON.get(CRIMINAL_SHOE_SIZE)).intValue();
                int numTattoos = ((Long)criminalJSON.get(CRIMINAL_NUM_TATTOOS)).intValue();
                // ADD INTAKE FOR ARRAY OF TATTOOS
                criminals.add(new Criminal(/* ADD INFO */));
            }

            return criminals;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Evidence> loadEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();

        try {
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray evidencesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < evidencesJSON.size(); ++i) {
                JSONObject evidenceJSON = (JSONObject)evidencesJSON.get(i);
                String id = (String)evidenceJSON.get(EVIDENCE_ID);
                String name = (String)evidenceJSON.get(EVIDENCE_NAME);
                String location = (String)evidenceJSON.get(EVIDENCE_LOCATION);
                boolean hasDNA = (Boolean)evidenceJSON.get(EVIDENCE_HAS_DNA);
                String associatedCrime = (String)evidenceJSON.get(EVIDENCE_ASSOC_CRIME);
                String dateCollected = (String)evidenceJSON.get(EVIDENCE_DATE_COLLECTED);
                evidence.add(new Evidence(id, name, dateCollected));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Officer> loadOfficer() {
        ArrayList<Officer> officer = new ArrayList<Officer>();

        try {
            FileReader reader = new FileReader(OFFICER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray officersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < officersJSON.size(); ++i) {
                JSONObject officerJSON = (JSONObject)officersJSON.get(i);
                String id = (String)officerJSON.get(OFFICER_ID);
                String badgeNo = (String)officerJSON.get(OFFICER_BADGE_NO);
                int numCrimes = ((Long)officerJSON.get(OFFICER_NUM_CRIMES)).intValue();
                // INTAKE ARRAY OF ASSOC CRIMES
                officer.add(new Officer(firstName, lastName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<POI> loadPOI() {
        ArrayList<POI> poi = new ArrayList<POI>();

        try {
            FileReader reader = new FileReader(POI_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray poisJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < poisJSON.size(); ++i) {
                JSONObject poiJSON = (JSONObject)poisJSON.get(i);
                String id = (String)poiJSON.get(POI_ID);
                int numCrimes = ((Long)poiJSON.get(POI_NUM_CRIMES)).intValue();
                // INTAKE ARRAY OF ASSOC CRIMES
                int phone = ((Long)poiJSON.get(POI_PHONE)).intValue();
                poi.add(new POI(firstName, lastName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        firstNamereturn null;
    }

    public static ArrayList<HospitalReport> loadReport() {
        ArrayList<HospitalReport> report = new ArrayList<HospitalReport>();

        try {
            FileReader reader = new FileReader(REPORT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray reportsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < reportsJSON.size(); ++i) {
                JSONObject reportJSON = (JSONObject)reportsJSON.get(i);
                String id = (String)reportJSON.get(REPORT_ID);
                int numStatements = ((Long)reportJSON.get(REPORT_NUM_STATEMENTS)).intValue();
                // INTAKE ARRAY OF STATEMENTS
                int numVictims = ((Long)reportJSON.get(REPORT_NUM_VICTIMS)).intValue();
                // INTAKE ARRAY OF VICTIMS
                report.add(new HospitalReport(id, ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Suspect> loadSuspects() {
        ArrayList<Suspect> suspect = new ArrayList<Suspect>();

        try {
            FileReader reader = new FileReader(SUSPECTS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray suspectsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < suspectsJSON.size(); ++i) {
                JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
                String id = (String)suspectJSON.get(SUSPECTS_ID);
                int numCrimes = ((Long)suspectJSON.get(SUSPECTS_NUM_CRIMES)).intValue();
                // INTAKE ARRAY OF ASSOC CRIMES
                boolean isPastCriminal = (Boolean)suspectJSON.get(SUSPECTS_IS_PAST_CRIMINAL);
                int phone = ((Long)suspectJSON.get(SUSPECTS_PHONE)).intValue();
                int numTattoos = ((Long)suspectJSON.get(SUSPECTS_NUM_TATTOOS)).intValue();
                // INTAKE ARRAY OF TATTOOS
                int shoeSize = ((Long)suspectJSON.get(SUSPECTS_SHOE_SIZE)).intValue();
                String gang = (String)suspectJSON.get(SUSPECTS_GANG);
                suspect.add(new Suspect(firstName, lastName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> user = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); ++i) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                int accessLevel = ((Long)userJSON.get(USER_ACCESS_LEVEL)).intValue();
                String firstname = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                user.add(new User(userName, firstName, lastName, accessLevel, userPassword));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Victim> loadVictims() {
        ArrayList<Victim> victim = new ArrayList<Victim>();

        try {
            FileReader reader = new FileReader(VICTIM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray victimsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < victimsJSON.size(); ++i) {
                JSONObject victimJSON = (JSONObject)victimsJSON.get(i);
                String id = (String)victimJSON.get(VICTIM_ID);
                int numReports = ((Long)victimJSON.get(VICTIM_NUM_H_REPORTS)).intValue();
                // INTAKE ARRAY OF REPORTS
                int numCrimes = ((Long)victimJSON.get(VICTIM_NUM_CRIMES)).intValue();
                // INTAKE ARRAY OF CRIMES
                victim.add(new Victim(firstName, lastName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Witness> loadWitness() {
        ArrayList<Witness> witness = new ArrayList<Witness>();

        try {
            FileReader reader = new FileReader(WITNESS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray witnessesJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < witnessesJSON.size(); ++i) {
                JSONObject witnessJSON = (JSONObject)witnessesJSON.get(i);
                String id = (String)witnessJSON.get(WITNESS_ID);
                int numCrimes = ((Long)witnessJSON.get(WITNESS_NUM_CRIMES)).intValue();
                // INTAKE ARRAY OF ASSOC CRIMES
                int phone = ((Long)witnessJSON.get(WITNESS_PHONE)).intValue();
                witness.add(new Witness(firstName, lastName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<Person> people = DataLoader.loadPeople();
        for (Person person : people) {
            System.out.println(person);
        } 
    }

	public static ArrayList<POI> loadPOIs() {
		// TODO Auto-generated method stub
		return null;
	}
}