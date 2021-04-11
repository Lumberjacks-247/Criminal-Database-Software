package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
    public void setup() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test 
    void testWriteZeroUsers() {
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testWriteOneUser() {
        userList.add(new User("gs1", "Greg", "Stich", 1, "lol123"));
        DataWriter.saveUsers();
        assertEquals("lol123", DataLoader.loadUsers().get(0).getPassword());
    }

    @Test 
    void testWriteFiveUser() {
        userList.add(new User("010", "Binary", "Numbers", 0, "progRock"));
        userList.add(new User("webrakefornobody", "Space", "Ball", 2, "Barf"));
        userList.add(new User("0xFFB", "Memory", "Hex", 2, "helpMe"));
        userList.add(new User("period", "Full", "Stop", 1, "WowAPassword"));
        userList.add(new User("dajokerbaby", "Jay", "Leno", 1, "MickeyMouse"));
        DataWriter.saveUsers();
        assertEquals("dajokerbaby", DataLoader.loadUsers().get(4).getUserName());
    }

    @Test 
    void testWriteEmptyUser() {
        userList.add(new User("", "", "", 0, ""));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.loadUsers().get(0).getFirstName());
    }

    @Test 
    void testWriteNullUser() {
        userList.add(new User(null, "", "", 2, ""));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.loadUsers().get(0).getUserName());
    }
}
