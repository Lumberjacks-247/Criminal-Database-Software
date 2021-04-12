package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class EnterNewCrimeTest {
  
  public static TransScreen parent;
  public static EnterNewCrime ENC;

  @Before
  public void setup() {

    parent = new TransScreen("parent", "N/A", "N/A");
    ENC = new EnterNewCrime();
    ENC.setParent(parent);
  }


  @Test
  public void test_updatePOIList_AddPOI() {
    
    POI poi = new POI("John","Doe");
    ENC.updatePOIList(new POI[]{poi}, 1);

    int expected = 1;
    int actual = ENC.numPOI;

    assertEquals(expected,actual);

  }


  @Test
  public void test_next_OutOfBounds_Negative() {
    String expected = "EnterNewCrime";

    String actual = ENC.next("-1").title;

    assertEquals(expected,actual);
  }

  @Test
  public void test_next_OutOfBounds_Positive() {
    String expected = "EnterNewCrime";

    String actual = ENC.next("100").title;

    assertEquals(expected,actual);
  }

  @Test
  public void test_next_OutOfBounds_NonNumericalString() {
    String expected = "EnterNewCrime";

    String actual = ENC.next("Hello World!").title;

    assertEquals(expected,actual);
  }

  @Test
  public void test_next_InBounds_TypeOfCrime_Prompt() {
    String expected = "Type of Crime";

    String actual = ((EnterDataScreen)ENC.next("1")).getDatum()[0];

    assertEquals(expected,actual);

  }

  @Test
  public void test_next_InBounds_Parent() {
    String expected = "parent";

    String actual = ENC.next("0").title;

    assertEquals(expected,actual);
  }

  @Test
  public void test_next_InBounds_POIListScreen() {
    String expected = "POIListScreen";

    String actual = ENC.next("4").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_SuspectListScreen() {
    String expected = "SuspectListScreen";

    String actual = ENC.next("5").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_CriminalListScreen() {
    String expected = "CriminalListScreen";
    String actual = ENC.next("6").title;
    assertEquals(expected,actual);
  }

  @Test
  public void test_next_InBounds_VictimListScreen() {
    String expected = "VictimListScreen";

    String actual = ENC.next("7").title;
    assertEquals(expected,actual);
  }



  @Test
  public void test_next_InBounds_EvidenceListScreen() {
    String expected = "EvidenceListScreen";

    String actual = ENC.next("9").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_OfficerListScreen() {
    String expected = "OfficerListScreen";

    String actual = ENC.next("8").title;
    assertEquals(expected,actual);
  }

  @Test
  public void test_next_InBounds_Done() {
    String expected = "parent";

    String actual = ENC.next("10").title;
    assertEquals(expected,actual);
  }

  @Test
  public void test_SetValueOf_Location() {
    String expected = "1250 Johnson Blvd";

    ENC.setDataValue(1, "1250 Johnson Blvd");

    String actual = ((EnterDataScreen)ENC.next("2")).getDatum()[1];

    assertEquals(expected,actual);
  }
}