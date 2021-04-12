package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class EditorScreenTest {
  
  public static EditorScreen parent;
  public static EditorScreen child;
  public static EditorScreen grandchild;
  public static String[] input;

  @BeforeClass
  public static void oneTimeSetup(){

    parent = new EditorScreen("Parent","Data 1;Data 2","Back;Set Data1;Set Data 2;Child","S:PARENT;S:CHILD");

    child = new EditorScreen("Child","Data 1;Data 2","Back;Set Data1;Set Data 2;Granchild","S:PARENT;ENTERDATA;ENTERDATA;S:LOGIN");
    child.setParent(parent);

    grandchild = (EditorScreen)ScreenCalls.LOGIN.call(child);

   
  }


  @Test
  public void test_next_OutOfBounds_Negative() {

    String expected = child.title;
    String actual = child.next("-100").title;
    assertEquals(expected,actual);
  }

  
  @Test
  public void test_next_OutOfBounds_Positive() {

    String expected = child.title;
    String actual = child.next("100").title;
    assertEquals(expected,actual);
  }

  
  @Test
  public void test_next_Parent() {

    String expected = parent.title;
    String actual = child.next("0").title;
    assertEquals(expected,actual);
  }

  
  @Test
  public void test_next_GrandChild() {

    String expected = grandchild.title;
    String actual = child.next("3").title;
    assertEquals(expected,actual);
  }

  
  @Test
  public void test_next_EnterData() {

    String[] input = new String[]{"1","2"};
    for (String i : input) {
      assertNull(child.next(i).title);
    }
  }


  @Test
  public void test_next_OutOfBounds_NonNumericalString() {

    String expected = child.title;
    String actual = child.next("Hello World!").title;
    assertEquals(expected,actual);
  }


}
