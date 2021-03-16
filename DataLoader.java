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
                String name = (String)personJSON.get(PERSON_NAME);
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
            }

            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
