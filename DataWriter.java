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
		// TODO Auto-generated method stub
		
	}

	public static void saveCrimes() {
		// TODO Auto-generated method stub
		
	}

	public static void saveWitnesses() {
		// TODO Auto-generated method stub
		
	}

	public static void saveCriminals() {
		// TODO Auto-generated method stub
		
	}

	public static void saveEvidences() {
		// TODO Auto-generated method stub
		
	}

	public static void saveOfficers() {
		// TODO Auto-generated method stub
		
	}

	public static void savePeople() {
		// TODO Auto-generated method stub
		
	}

	public static void savePOIs() {
		// TODO Auto-generated method stub
		
	}

	public static void saveSuspects() {
		// TODO Auto-generated method stub
		
	}
}