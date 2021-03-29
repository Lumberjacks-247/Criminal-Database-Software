/**
 * DataLoader, a JSON Loader for CriminalDatabaseSoftware
 * @author Brooks Robinson
 */
package src;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Iterator;

public class DataLoader extends DataConstants {

    private static final String DELIMITER = " ";

    /**
     * Loads all Person objects from person.json
     * @return ArrayList of Person
     */
    public static ArrayList<Person> loadPeople() {
        ArrayList<Person> people = new ArrayList<Person>();

        try {
            FileReader reader = new FileReader(PERSON_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < peopleJSON.size(); ++i) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String id = (String)personJSON.get(PERSON_ID);
                String firstName = (String)personJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)personJSON.get(PERSON_LAST_NAME);
                String gender = (String)personJSON.get(PERSON_GENDER);
                String address = (String)personJSON.get(PERSON_ADDRESS);
                String eyeColor = (String)personJSON.get(PERSON_EYE_COLOR);
                String race = (String)personJSON.get(PERSON_RACE);
                String hairColor = (String)personJSON.get(PERSON_HAIR_COLOR);
                String hairStyle = (String)personJSON.get(PERSON_HAIR_STYLE);
                String age = (String)personJSON.get(PERSON_AGE);
                people.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
            }

            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Crime objects from crime.json
     * @return ArrayList of Crime
     */
    public static ArrayList<Crime> loadCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();

        try {
            FileReader reader = new FileReader(CRIMES_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimesJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < crimesJSON.size(); ++i) {
                JSONObject crimeJSON = (JSONObject)crimesJSON.get(i);
                String id = (String)crimeJSON.get(CRIMES_ID);
                String typeOfCrime = (String)crimeJSON.get(CRIMES_TYPE_OF_CRIME);
                int chargeLevel = ((Long)crimeJSON.get(CRIMES_CHARGE_LEVEL)).intValue();
                int jurisdiction = ((Long)crimeJSON.get(CRIMES_JURISDICTION)).intValue();
                boolean isOpen = ((Boolean)crimeJSON.get(CRIMES_IS_OPEN)).booleanValue();
                String authorString = (String)crimeJSON.get(CRIMES_AUTHOR);
                String[] authorName = authorString.split(DELIMITER);
                User author = new User(authorName[0], authorName[1]);
                String location = (String)crimeJSON.get(CRIMES_LOCATION);
                ArrayList<POI> pois = new ArrayList<POI>();
                JSONArray poisJSON = (JSONArray)crimeJSON.get(CRIMES_POI);
                Iterator<String> poisIterator = poisJSON.iterator();
                for (int j = 0; j < poisJSON.size(); ++j) {
                    if (poisIterator.hasNext()) {
                        //pois.add(POIs.getInstance().getPOI(poisIterator.next()));
                    }
                }
                ArrayList<Suspect> suspects = new ArrayList<Suspect>();
                JSONArray suspectsJSON = (JSONArray)crimeJSON.get(CRIMES_SUSPECTS);
                Iterator<String> suspectsIterator = suspectsJSON.iterator();
                for (int j = 0; j < suspectsJSON.size(); ++j) {
                    if (suspectsIterator.hasNext()) {
                        //suspects.add(Suspects.getInstance().getSuspect(poisIterator.next()));
                    }
                }
                ArrayList<Criminal> criminals = new ArrayList<Criminal>();
                JSONArray criminalsJSON = (JSONArray)crimeJSON.get(CRIMES_CRIMINALS);
                Iterator<String> criminalsIterator = criminalsJSON.iterator();
                for (int j = 0; j < criminalsJSON.size(); ++j) {
                    if (criminalsIterator.hasNext()) {
                        //criminals.add(Criminals.getInstance().getCriminal(criminalsIterator.next()));
                    }
                }
                ArrayList<Victim> victims = new ArrayList<Victim>();
                JSONArray victimsJSON = (JSONArray)crimeJSON.get(CRIMES_VICTIMS);
                Iterator<String> victimsIterator = victimsJSON.iterator();
                for (int j = 0; j < victimsJSON.size(); ++j) {
                    if (victimsIterator.hasNext()) {
                        //victims.add(Victims.getInstance().getVictim(victimsIterator.next()));
                    }
                }
                ArrayList<Witness> witnesses = new ArrayList<Witness>();
                JSONArray witnessesJSON = (JSONArray)crimeJSON.get(CRIMES_WITNESSES);
                Iterator<String> witnessesIterator = witnessesJSON.iterator();
                for (int j = 0; j < witnessesJSON.size(); ++j) {
                    if (witnessesIterator.hasNext()) {
                        //witnesses.add(Witnesses.getInstance().getWitness(witnessesIterator.next()));
                    }
                }
                ArrayList<Officer> officers = new ArrayList<Officer>();
                JSONArray officersJSON = (JSONArray)crimeJSON.get(CRIMES_OFFICERS);
                Iterator<String> officersIterator = officersJSON.iterator();
                for (int j = 0; j < officersJSON.size(); ++j) {
                    if (officersIterator.hasNext()) {
                        //officers.add(Officers.getInstance().getOfficer(officersIterator.next()));
                    }
                }
                ArrayList<Evidence> evidences = new ArrayList<Evidence>();
                JSONArray evidencesJSON = (JSONArray)crimeJSON.get(CRIMES_EVIDENCE);
                Iterator<String> evidencesIterator = evidencesJSON.iterator();
                for (int j = 0; j < evidencesJSON.size(); ++j) {
                    if (evidencesIterator.hasNext()) {
                        //evidences.add(Evidences.getInstance().getEvidence(evidencesIterator.next()));
                    }
                }
                crimes.add(new Crime(id, typeOfCrime, chargeLevel, jurisdiction, isOpen, author, location,
                                     pois,suspects, criminals, victims, witnesses, officers, evidences));
            }

            return crimes;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Criminal objects from criminal.json
     * @return ArrayList of Criminal
     */
    public static ArrayList<Criminal> loadCriminals() {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();

        try {
            FileReader reader = new FileReader(CRIMINAL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray criminalsJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < criminalsJSON.size(); ++i) {
                JSONObject criminalJSON = (JSONObject)criminalsJSON.get(i);
                String id = (String)criminalJSON.get(PERSON_ID);
                String firstName = (String)criminalJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)criminalJSON.get(PERSON_LAST_NAME);
                String gender = (String)criminalJSON.get(PERSON_GENDER);
                String address = (String)criminalJSON.get(PERSON_ADDRESS);
                String eyeColor = (String)criminalJSON.get(PERSON_EYE_COLOR);
                String race = (String)criminalJSON.get(PERSON_RACE);
                String hairColor = (String)criminalJSON.get(PERSON_HAIR_COLOR);
                String hairStyle = (String)criminalJSON.get(PERSON_HAIR_STYLE);
                String age = (String)criminalJSON.get(PERSON_AGE);
                String tattoos = (String)criminalJSON.get(POI_TATTOOS);
                String gang = (String)criminalJSON.get(POI_GANG);
                String victimRelation = (String)criminalJSON.get(POI_VICTIM_RELATION);
                String evidenceConn = (String)criminalJSON.get(POI_EVIDENCE_CONN);
                boolean isRepeatOffender = ((Boolean)criminalJSON.get(POI_IS_REPEAT_OFFENDER)).booleanValue();
                ArrayList<Person> accomplices = new ArrayList<Person>();
                JSONArray accomplicesJSON = (JSONArray)criminalJSON.get(SUSPECT_ACCOMPLICES);
                Iterator<String> accomplicesIterator = accomplicesJSON.iterator();
                for (int j = 0; j < accomplicesJSON.size(); ++j) {
                    if (accomplicesIterator.hasNext()) {
                        //accomplices.add(People.getInstance().getPerson(accomplicesIterator.next()));
                    }
                }
                ArrayList<Person> family = new ArrayList<Person>();
                JSONArray familyJSON = (JSONArray)criminalJSON.get(SUSPECT_FAMILY_MEMBERS);
                Iterator<String> familyIterator = familyJSON.iterator();
                for (int j = 0; j < familyJSON.size(); ++j) {
                    if (familyIterator.hasNext()) {
                        //family.add(People.getInstance().getPerson(familyIterator.next()));
                    }
                }
                double footSize = ((Long)criminalJSON.get(SUSPECT_FOOT_SIZE)).floatValue();
                String prefClothes = (String)criminalJSON.get(SUSPECT_PREFERRED_CLOTHES);
                String nicknames = (String)criminalJSON.get(SUSPECT_NICKNAMES);
                String commonWords = (String)criminalJSON.get(SUSPECT_COMMON_WORDS);
                String hobbies = (String)criminalJSON.get(SUSPECT_HOBBIES);
                String job = (String)criminalJSON.get(SUSPECT_JOB);
                String physicalTraits = (String)criminalJSON.get(SUSPECT_PHYSICAL_TRAITS);
                ArrayList<Crime> crimes = new ArrayList<Crime>();
                JSONArray crimesJSON = (JSONArray)criminalJSON.get(CRIMINAL_CRIMES);
                Iterator<String> crimesIterator = crimesJSON.iterator();
                for (int j = 0; j < crimesJSON.size(); ++j) {
                    if (crimesIterator.hasNext()) {
                        //crimes.add(Crimes.getInstance().getCrime(crimesIterator.next()));
                    }
                }
                double sentence = ((Long)criminalJSON.get(CRIMINAL_SENTENCE)).floatValue();
                String status = (String)criminalJSON.get(CRIMINAL_STATUS);
                boolean inCustody = ((Boolean)criminalJSON.get(CRIMINAL_IN_CUSTODY)).booleanValue();
                Criminal ret = new Criminal(crimes, sentence, status, inCustody);
                ret.setSuspectInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelation, evidenceConn, isRepeatOffender, accomplices, family, footSize, prefClothes, nicknames, commonWords, hobbies, job, physicalTraits);
                criminals.add(ret);
            }

            return criminals;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Evidence objects from evidence.json
     * @return ArrayList of Evidence
     */
    public static ArrayList<Evidence> loadEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();

        try {
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray evidencesJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < evidencesJSON.size(); ++i) {
                JSONObject evidenceJSON = (JSONObject)evidencesJSON.get(i);
                String id = (String)evidenceJSON.get(EVIDENCE_ID);
                String description = (String)evidenceJSON.get(EVIDENCE_DESCRIPTION);
                String dateCollected = (String)evidenceJSON.get(EVIDENCE_DISC_DATE);
                evidence.add(new Evidence(id, description, dateCollected));
            }

            return evidence;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Officer objects from officer.json
     * @return ArrayList of Officer
     */
    public static ArrayList<Officer> loadOfficer() {
        ArrayList<Officer> officer = new ArrayList<Officer>();

        try {
            FileReader reader = new FileReader(OFFICER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray officersJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < officersJSON.size(); ++i) {
                JSONObject officerJSON = (JSONObject)officersJSON.get(i);
                String type = (String)officerJSON.get(OFFICER_TYPE);
                String statement = (String)officerJSON.get(OFFICER_STATEMENT);
                officer.add(new Officer(type, statement));
            }

            return officer;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all POI objects from poi.json
     * @return ArrayList of POI
     */
    public static ArrayList<POI> loadPOI() {
        ArrayList<POI> poi = new ArrayList<POI>();

        try {
            FileReader reader = new FileReader(POI_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray poisJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < poisJSON.size(); ++i) {
                JSONObject poiJSON = (JSONObject)poisJSON.get(i);
                String id = (String)poiJSON.get(PERSON_ID);
                String firstName = (String)poiJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)poiJSON.get(PERSON_LAST_NAME);
                String gender = (String)poiJSON.get(PERSON_GENDER);
                String address = (String)poiJSON.get(PERSON_ADDRESS);
                String eyeColor = (String)poiJSON.get(PERSON_EYE_COLOR);
                String race = (String)poiJSON.get(PERSON_RACE);
                String hairColor = (String)poiJSON.get(PERSON_HAIR_COLOR);
                String hairStyle = (String)poiJSON.get(PERSON_HAIR_STYLE);
                String age = (String)poiJSON.get(PERSON_AGE);
                String tattoos = (String)poiJSON.get(POI_TATTOOS);
                String gang = (String)poiJSON.get(POI_GANG);
                String victimRelation = (String)poiJSON.get(POI_VICTIM_RELATION);
                String evidenceConn = (String)poiJSON.get(POI_EVIDENCE_CONN);
                boolean isRepeatOffender = ((Boolean)poiJSON.get(POI_IS_REPEAT_OFFENDER)).booleanValue();
                POI ret = new POI(tattoos, gang, victimRelation, evidenceConn, isRepeatOffender);
                ret.setPersonInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age);
                poi.add(ret);
            }

            return poi;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Suspect objects from suspect.json
     * @return ArrayList of Suspect
     */
    public static ArrayList<Suspect> loadSuspects() {
        ArrayList<Suspect> suspect = new ArrayList<Suspect>();

        try {
            FileReader reader = new FileReader(SUSPECT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray suspectsJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < suspectsJSON.size(); ++i) {
                JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
                String id = (String)suspectJSON.get(PERSON_ID);
                String firstName = (String)suspectJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)suspectJSON.get(PERSON_LAST_NAME);
                String gender = (String)suspectJSON.get(PERSON_GENDER);
                String address = (String)suspectJSON.get(PERSON_ADDRESS);
                String eyeColor = (String)suspectJSON.get(PERSON_EYE_COLOR);
                String race = (String)suspectJSON.get(PERSON_RACE);
                String hairColor = (String)suspectJSON.get(PERSON_HAIR_COLOR);
                String hairStyle = (String)suspectJSON.get(PERSON_HAIR_STYLE);
                String age = (String)suspectJSON.get(PERSON_AGE);
                String tattoos = (String)suspectJSON.get(POI_TATTOOS);
                String gang = (String)suspectJSON.get(POI_GANG);
                String victimRelation = (String)suspectJSON.get(POI_VICTIM_RELATION);
                String evidenceConn = (String)suspectJSON.get(POI_EVIDENCE_CONN);
                boolean isRepeatOffender = ((Boolean)suspectJSON.get(POI_IS_REPEAT_OFFENDER)).booleanValue();
                ArrayList<Person> accomplices = new ArrayList<Person>();
                JSONArray accomplicesJSON = (JSONArray)suspectJSON.get(SUSPECT_ACCOMPLICES);
                Iterator<String> accomplicesIterator = accomplicesJSON.iterator();
                for (int j = 0; j < accomplicesJSON.size(); ++j) {
                    if (accomplicesIterator.hasNext()) {
                        //accomplices.add(People.getInstance().getPerson(accomplicesIterator.next()));
                    }
                }
                ArrayList<Person> family = new ArrayList<Person>();
                JSONArray familyJSON = (JSONArray)suspectJSON.get(SUSPECT_FAMILY_MEMBERS);
                Iterator<String> familyIterator = familyJSON.iterator();
                for (int j = 0; j < familyJSON.size(); ++j) {
                    if (familyIterator.hasNext()) {
                        //family.add(People.getInstance().getPerson(familyIterator.next()));
                    }
                }
                double footSize = ((Long)suspectJSON.get(SUSPECT_FOOT_SIZE)).floatValue();
                String prefClothes = (String)suspectJSON.get(SUSPECT_PREFERRED_CLOTHES);
                String nicknames = (String)suspectJSON.get(SUSPECT_NICKNAMES);
                String commonWords = (String)suspectJSON.get(SUSPECT_COMMON_WORDS);
                String hobbies = (String)suspectJSON.get(SUSPECT_HOBBIES);
                String job = (String)suspectJSON.get(SUSPECT_JOB);
                String physicalTraits = (String)suspectJSON.get(SUSPECT_PHYSICAL_TRAITS);
                Suspect ret = new Suspect(accomplices, family, footSize, prefClothes, nicknames, commonWords, hobbies, job, physicalTraits);
                ret.setPOIInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelation, evidenceConn, isRepeatOffender);
                suspect.add(ret);
            }

            return suspect;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all User objects from user.json
     * @return ArrayList of User
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> user = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < usersJSON.size(); ++i) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                int accessLevel = ((Long)userJSON.get(USER_ACCESS_LEVEL)).intValue();
                String firstname = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String username = (String)userJSON.get(USER_USERNAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                user.add(new User(username, firstname, lastName, accessLevel, password));
            }

            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Victim objects from victim.json
     * @return ArrayList of Victim
     */
    public static ArrayList<Victim> loadVictims() {
        ArrayList<Victim> victim = new ArrayList<Victim>();

        try {
            FileReader reader = new FileReader(VICTIM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray victimsJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < victimsJSON.size(); ++i) {
                JSONObject victimJSON = (JSONObject)victimsJSON.get(i);
                String firstName = (String)victimJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)victimJSON.get(PERSON_LAST_NAME);
                String id = (String)victimJSON.get(PERSON_ID);
                String statement = (String)victimJSON.get(VICTIM_STATEMENT);
                boolean isAlive = ((Boolean)victimJSON.get(VICTIM_IS_ALIVE)).booleanValue();
                ArrayList<HospitalReport> hReports = new ArrayList<HospitalReport>();
                JSONArray hReportsJSON = (JSONArray)victimJSON.get(VICTIM_H_REPORTS);
                Iterator<String> hReportsIterator = hReportsJSON.iterator();
                for (int j = 0; j < hReportsJSON.size(); ++j) {
                    if (hReportsIterator.hasNext()) {
                        //hReports.add(HospitalReports.getInstance().getHReport(hReportsIterator.next()));
                    }
                }
                Victim ret = new Victim(statement, isAlive, hReports);
                ret.setPersonInfo(firstName, lastName, id);
                victim.add(ret);
            }

            return victim;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all Witness objects from witness.json
     * @return ArrayList of Witness
     */
    public static ArrayList<Witness> loadWitness() {
        ArrayList<Witness> witness = new ArrayList<Witness>();

        try {
            FileReader reader = new FileReader(WITNESS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray witnessesJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < witnessesJSON.size(); ++i) {
                JSONObject witnessJSON = (JSONObject)witnessesJSON.get(i);
                String firstName = (String)witnessJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)witnessJSON.get(PERSON_LAST_NAME);
                String id = (String)witnessJSON.get(PERSON_ID);
                String phone = (String)witnessJSON.get(WITNESS_PHONE_NUMBER);
                String email = (String)witnessJSON.get(WITNESS_EMAIL);
                String statement = (String)witnessJSON.get(WITNESS_STATEMENT);
                String relationBad = (String)witnessJSON.get(WITNESS_RELATION_BAD);
                Witness ret = new Witness(phone, email, statement, relationBad);
                ret.setPersonInfo(firstName, lastName, id);
                witness.add(ret);
            }

            return witness;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads all HospitalReport objects from hospital.json
     * @return ArrayList of HospitalReport
     */
    public static ArrayList<HospitalReport> loadHReports() {
        ArrayList<HospitalReport> hreport = new ArrayList<HospitalReport>();

        try {
            FileReader reader = new FileReader(HOSPITAL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray hreportsJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < hreportsJSON.size(); ++i) {
                JSONObject hreportJSON = (JSONObject)hreportsJSON.get(i);
                String id = (String)hreportJSON.get(HOSPITAL_ID);
                String diagnosis = (String)hreportJSON.get(HOSPITAL_DIAGNOSIS);
                String cause = (String)hreportJSON.get(HOSPITAL_CAUSE);
                String doctorString = (String)hreportJSON.get(HOSPITAL_DOCTOR);
                String[] docName = doctorString.split(DELIMITER);
                Person doctor = new Person(docName[0], docName[1]);
                String nurseString = (String)hreportJSON.get(HOSPITAL_NURSE);
                String[] nurseName = nurseString.split(DELIMITER);
                Person nurse = new Person(nurseName[0], nurseName[1]);
                String dateAdmitted = (String)hreportJSON.get(HOSPITAL_DATE);
                int numDays = ((Long)hreportJSON.get(HOSPITAL_NUM_DAYS)).intValue();
                hreport.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDays));
            }

            return hreport;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}