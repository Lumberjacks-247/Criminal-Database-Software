import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public static void savePeople() {
        try (FileWriter file = new FileWriter("")) {

        } catch (IOException e) {

        }
    }

    public static JSONObject getPersonJSON(Person person) {
        return new JSONObject();
    }
}