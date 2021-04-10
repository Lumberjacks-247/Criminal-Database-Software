package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User(userName, firstName, lastName, accessLevel, userPassword));
        userList.add(new User(userName, firstName, lastName, accessLevel, userPassword));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }
}
