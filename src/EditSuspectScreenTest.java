package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class EditSuspectScreenTest {
  
  public static Suspect sus;
  public static EditSuspectScreen ESS;
  public static SuspectsListScreen parent;

  @Before
  public void setup() {
    sus = new Suspect("John","Doe");
    parent = new SuspectsListScreen(null, new Suspect[]{sus}, 1);
    ESS = new EditSuspectScreen(parent, sus, 0);
  }


  @Test
  public void test_next_parent() {
    String expected = "SuspectListScreen";

    String actual = ESS.next("0").title;
    assertEquals(expected,actual);
  }
 
  @Test
  public void test_next_OutOfBounds_Negative() {
    String expected = "EditSuspectScreen";

    String actual = ESS.next("-1").title;
    assertEquals(expected,actual);
  }

  @Test
  public void test_next_OutOfBounds_Positive() {
    String expected = "EditSuspectScreen";

    String actual = ESS.next("100").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_Address_Prompt() {
    String expected = "Address: ";

    String actual = ((EnterDataScreen)ESS.next("8")).getDatum()[0];
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_FirstName_Value() {
    String expected = "John";
    String actual = ((EnterDataScreen)ESS.next("1")).getDatum()[1];
    assertEquals(expected,actual);
    
  }


  @Test
  public void test_next_InBounds_LastName_Value() {
    String expected = "Doe";
    String actual = ((EnterDataScreen)ESS.next("2")).getDatum()[1];
    assertEquals(expected,actual);
    
  }


  @Test
  public void test_next_InBounds_Done() {
    String expected = "SuspectListScreen";

    String actual = ESS.next("17").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_ChangeValueOf_FirstName() {
    String expected = "Alex";

    ESS.setDataValue(0,"Alex");

    String actual = ((EnterDataScreen)ESS.next("1")).getDatum()[1];
    
    assertEquals(expected,actual);
  }

  @Test
  public void test_ChangeValueOf_LastName() {
    String expected = "Jones";

    ESS.setDataValue(1,"Jones");

    String actual = ((EnterDataScreen)ESS.next("2")).getDatum()[1];
    
    assertEquals(expected,actual);
  }

  @Test
  public void test_SetValueOf_Gender() {
    String expected = "M";

    ESS.setDataValue(2,"M");

    String actual = ((EnterDataScreen)ESS.next("3")).getDatum()[1];
    
    assertEquals(expected,actual);
  }


  @Test
  public void test_SetValueOf_Age() {
    String expected = "25";

    ESS.setDataValue(8,"25");

    String actual = ((EnterDataScreen)ESS.next("9")).getDatum()[1];
    
    assertEquals(expected,actual);
  }


  @Test
  public void test_SetValueOf_HairColor() {
    String expected = "Blond";

    ESS.setDataValue(5,"Blond");

    String actual = ((EnterDataScreen)ESS.next("6")).getDatum()[1];
    
    assertEquals(expected,actual);
  }



  @Test
  public void test_SetValueOf_PerfferedClothes() {
    String expected = "Gray sweatpants";

    ESS.setDataValue(15,"Gray sweatpants");

    String actual = ((EnterDataScreen)ESS.next("16")).getDatum()[1];
    
    assertEquals(expected,actual);
  }
}