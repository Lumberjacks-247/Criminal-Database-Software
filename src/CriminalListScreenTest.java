package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CriminalListScreenTest {
  

  public static TransScreen parent;
  public static CriminalListScreen CLS_Editor;
  public static CriminalListScreen CLS_Display;
  public static Criminal[] crims;
  public static Criminal testCrim;

  @BeforeClass
  public static void oneTimeSetup(){
    
    parent = new TransScreen("Parent","N/A","N/A");

    crims = new Criminal[]{new Criminal(),new Criminal("John","Mayer"),null,null,null,null};

    CLS_Display = new CriminalListScreen(parent, crims, 2,false);
    CLS_Editor = new CriminalListScreen(parent,crims,2,true);

  }

  @Test
  public void test_IsValid_OutOfBounds_Negative() {

    int expected = -1;

    int actual = CLS_Display.isValid("-1");
    assertEquals(expected,actual,"Display is Wrong");
    
    actual = CLS_Editor.isValid("-1");
    assertEquals(expected,actual,"Editor is Wrong");
    
  }


  @Test
  public void test_IsValid_InBounds() {

    int[] expected_E = new int[]{0,1,2,3};
    int[] expected_D = new int[]{0,-1,-1,3};

    String[] input = new String[]{"0","1","2","3"};

    int count = 0;
    for (String in : input) {
      assertEquals(expected_E[count],CLS_Editor.isValid(in),"Editor is Wrong");

      assertEquals(expected_D[count],CLS_Display.isValid(in), "Display is Wrong");

      count++;
    } 
  }

  @Test
  public void test_IsValid_OutOfBounds_Positive() {

    int expected = -1;

    int actual = CLS_Display.isValid("4");
    assertEquals(expected,actual,"Display is Wrong");
    
    actual = CLS_Editor.isValid("4");
    assertEquals(expected,actual,"Editor is Wrong");
    
  }

  @Test
  public void test_IsValid_OutOfBounds_NonNumericalString() {

    int expected = -1;

    int actual = CLS_Display.isValid("Hello World!");
    assertEquals(expected,actual,"Display is Wrong");
    
    actual = CLS_Editor.isValid("Hello World!");
    assertEquals(expected,actual,"Editor is Wrong");
    
  }


  
  @Test
  public void test_next_OutOfBounds_Negative() {

    String expected = "CriminalListScreen";

    String actual = CLS_Display.next("-1").title;
    assertEquals(expected,actual,"Display is Wrong");
    
    actual = CLS_Editor.next("-1").title;
    assertEquals(expected,actual,"Editor is Wrong");
  }


  
  @Test
  public void test_next_OutOfBounds_Positive() {

    String expected = "CriminalListScreen";

    String actual = CLS_Display.next("100").title;
    assertEquals(expected,actual,"Display is Wrong");
    
    actual = CLS_Editor.next("100").title;
    assertEquals(expected,actual,"Editor is Wrong");
  }

  @Test
  public void test_next_OutOfBounds_NonNumericalString() {

    String expected = "CriminalListScreen";

    String actual = CLS_Display.next("Hello World!").title;
    assertEquals(expected,actual, "Display is Wrong");
    
    actual = CLS_Editor.next("Hello World!").title;
    assertEquals(expected,actual, "Editor is Wrong");
  }

  @Test
  public void test_next_InBounds_Display() {
    String expected = "CriminalListScreen";

    String actual = CLS_Display.next("1").title;
    assertEquals(expected,actual);
  }


  @Test
  public void test_next_InBounds_Editor() {
    String expected = "CriminalEditorScreen";

    String actual = CLS_Editor.next("1").title;
    assertEquals(expected,actual);
  }





}