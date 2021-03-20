import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
        return new ArrayList<Evidence>();
    }

    public static void main(String[] args) {
        ArrayList<Person> people = DataLoader.loadPeople();
        for (Person person : people) {
            System.out.println(person);
        } 
    }
}
