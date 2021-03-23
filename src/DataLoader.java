package src;
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
                String gender = (String)personJSON.get(PERSON_GENDER);
                String address = (String)personJSON.get(PERSON_ADDRESS);
                String eyeColor = (String)personJSON.get(PERSON_EYE_COLOR);
                String race = (String)personJSON.get(PERSON_RACE);
                String hairColor = (String)personJSON.get(PERSON_HAIR_COLOR);
                String hairStyle = (String)personJSON.get(PERSON_HAIR_STYLE);
                int age = ((Long)personJSON.get(PERSON_AGE)).intValue();
                people.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
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
                String typeOfCrime = (String)crimeJSON.get(CRIMES_TYPE_OF_CRIME);
                int chargeLevel = ((Long)crimeJSON.get(CRIMES_CHARGE_LEVEL)).intValue(); // long int value, not integer
                String jurisdiction = (String)crimeJSON.get(CRIMES_JURISDICTION);
                boolean isOpen = (Boolean)crimeJSON.get(CRIMES_IS_OPEN);
                String author = (String)crimeJSON.get(CRIMES_AUTHOR);
                String location = (String)crimeJSON.get(CRIMES_LOCATION);
                int numPOI = ((Long)crimeJSON.get(CRIMES_NUM_POI)).intValue();
                // ADD INTAKE FOR ARRAY OF CRIMINALS
                String[] poi = new String[numPOI];
                JSONArray poisJSON = (JSONArray)crimeJSON.get(CRIMES_POI);
                Iterator<String> poisIterator = poisJSON.iterator();
                for (int j = 0; j < numPOI; ++j) {
                    if (poisIterator.hasNext()) {
                        poi[j] = poisIterator.next();
                    }
                }
                int numSuspects = ((Long)crimeJSON.get(CRIMES_NUM_SUSPECTS)).intValue();
                String[] suspects = new String[numSuspects];
                JSONArray suspectsJSON = (JSONArray)crimeJSON.get(CRIMES_SUSPECTS);
                Iterator<String> suspectsIterator = suspectsJSON.iterator();
                for (int j = 0; j < numSuspects; ++j) {
                    if (suspectsIterator.hasNext()) {
                        suspects[j] = suspectsIterator.next();
                    }
                }
                int numCriminals = ((Long)crimeJSON.get(CRIMES_NUM_CRIMINALS)).intValue();
                String[] criminals = new String[numCriminals];
                JSONArray criminalsJSON = (JSONArray)crimeJSON.get(CRIMES_CRIMINALS);
                Iterator<String> criminalsIterator = criminalsJSON.iterator();
                for (int j = 0; j < numCriminals; ++j) {
                    if (criminalsIterator.hasNext()) {
                        criminals[j] = criminalsIterator.next();
                    }
                }
                int numVictims = ((Long)crimeJSON.get(CRIMES_NUM_VICTIMS)).intValue();
                String[] victims = new String[numVictims];
                JSONArray victimsJSON = (JSONArray)crimeJSON.get(CRIMES_VICTIMS);
                Iterator<String> victimsIterator = victimsJSON.iterator();
                for (int j = 0; j < numVictims; ++j) {
                    if (victimsIterator.hasNext()) {
                        victims[j] = victimsIterator.next();
                    }
                }
                int numWitnesses = ((Long)crimeJSON.get(CRIMES_NUM_WITNESSES)).intValue();
                String[] witnesses = new String[numWitnesses];
                JSONArray witnessesJSON = (JSONArray)crimeJSON.get(CRIMES_WITNESSES);
                Iterator<String> witnessesIterator = witnessesJSON.iterator();
                for (int j = 0; j < numWitnesses; ++j) {
                    if (witnessesIterator.hasNext()) {
                        witnesses[j] = witnessesIterator.next();
                    }
                }
                int numOfficers = ((Long)crimeJSON.get(CRIMES_NUM_OFFICERS)).intValue();
                String[] officers = new String[numOfficers];
                JSONArray officersJSON = (JSONArray)crimeJSON.get(CRIMES_OFFICERS);
                Iterator<String> officersIterator = officersJSON.iterator();
                for (int j = 0; j < numOfficers; ++j) {
                    if (officersIterator.hasNext()) {
                        officers[j] = officersIterator.next();
                    }
                }
                int numEvidence = ((Long)crimeJSON.get(CRIMES_NUM_EVIDENCE)).intValue();
                String[] evidences = new String[numEvidence];
                JSONArray evidencesJSON = (JSONArray)crimeJSON.get(CRIMES_EVIDENCE);
                Iterator<String> evidencesIterator = evidencesJSON.iterator();
                for (int j = 0; j < numEvidence; ++j) {
                    if (evidencesIterator.hasNext()) {
                        evidences[j] = evidencesIterator.next();
                    }
                }
                crimes.add(new Crime(id, typeOfCrime, chargeLevel, jurisdiction, isOpen, author, location, poi, suspects, criminals, victims, witnesses, officers, evidences));
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
                String[] crimes = new String[numCrimes];
                JSONArray crimesJSON = (JSONArray)criminalJSON.get(CRIMINAL_CRIMES);
                Iterator<String> crimesIterator = crimesJSON.iterator();
                for (int j = 0; j < numCrimes; ++j) {
                    if (crimesIterator.hasNext()) {
                        crimes[j] = crimesIterator.next();
                    }
                }
                String sentence = (String)criminalJSON.get(CRIMINAL_SENTENCE);
                String status = (String)criminalJSON.get(CRIMINAL_STATUS);
                boolean inCustody = (Boolean)criminalJSON.get(CRIMINAL_IN_CUSTODY);
                // ADD INTAKE FOR ARRAY OF TATTOOS
                criminals.add(new Criminal(crimes, sentence, status, inCustody));
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
                String description = (String)evidenceJSON.get(EVIDENCE_DESCRIPTION);
                String dateCollected = (String)evidenceJSON.get(EVIDENCE_DISC_DATE);
                evidence.add(new Evidence(id, description, dateCollected));
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
                String type = (String)officerJSON.get(OFFICER_TYPE);
                String statement = (String)officerJSON.get(OFFICER_STATEMENT);
                officer.add(new Officer(type, statement));
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
                String tattoos = (String)poiJSON.get(POI_TATTOOS);
                String gang = (String)poiJSON.get(POI_GANG);
                String victimRelation = (String)poiJSON.get(POI_VICTIM_RELATION);
                String evidenceConn = (String)poiJSON.get(POI_EVIDENCE_CONN);
                boolean isRepeatOffender = (Boolean)poiJSON.get(POI_IS_REPEAT_OFFENDER);
                poi.add(new POI(tattoos, gang, victimRelation, evidenceConn, isRepeatOffender));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
                String accomplices = (String)suspectJSON.get(SUSPECTS_ACCOMPLICES);
                String familyMembers = (String)suspectJSON.get(SUSPECTS_FAMILY_MEMBERS);
                int footSize = ((Long)suspectJSON.get(SUSPECTS_FOOT_SIZE)).intValue();
                String prefClothes = (String)suspectJSON.get(SUSPECTS_PREFERRED_CLOTHES);
                String nicknames = (String)suspectJSON.get(SUSPECTS_NICKNAMES);
                String commonWords = (String)suspectJSON.get(SUSPECTS_COMMON_WORDS);
                String hobbies = (String)suspectJSON.get(SUSPECTS_HOBBIES);
                String job = (String)suspectJSON.get(SUSPECTS_JOB);
                String physicalTraits = (String)suspectJSON.get(SUSPECTS_PHYSICAL_TRAITS);
                suspect.add(new Suspect(accomplices, familyMembers, footSize, prefClothes, nicknames, commonWords
                                        hobbies, job, physicalTraits);
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
                String username = (String)userJSON.get(USER_USERNAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                user.add(new User(accessLevel, firstname, lastName, username, password));
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
                String statement = (String)victimJSON.get(VICTIM_STATEMENT);
                boolean isAlive = (Boolean)victimJSON.get(VICTIM_IS_ALIVE);
                int numReports = ((Long)victimJSON.get(VICTIM_NUM_H_REPORTS)).intValue();
                // INTAKE ARRAY OF REPORTS
                String[] hReports = new String[numReports];
                JSONArray hReportsJSON = (JSONArray)victimJSON.get(VICTIM_H_REPORTS);
                Iterator<String> hReportsIterator = hReportsJSON.iterator();
                for (int j = 0; j < numReports; ++j) {
                    if (hReportsIterator.hasNext()) {
                        hReports[j] = hReportsIterator.next();
                    }
                }
                victim.add(new Victim(statement, isAlive, numReports, hReports));
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
                int phone = ((Long)witnessJSON.get(WITNESS_PHONE_NUMBER)).intValue();
                String email = (String)witnessJSON.get(WITNESS_EMAIL);
                String statement = (String)witnessJSON.get(WITNESS_STATEMENT);
                String relationBad = (String)witnessJSON.get(WITNESS_RELATION_BAD);
                witness.add(new Witness(phone, email, statement, relationBad));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}