package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TransScreenTest {
  
  public static TransScreen parent;
  public static TransScreen child;
  public static TransScreen grandchild;
  public static String[] input;

  @BeforeClass
  public static void oneTimeSetup(){
    parent = new TransScreen("Parent","Back;Child","S:PARENT;S:CHILD");

    child = new TransScreen("Child","Back;Granchild","S:PARENT;S:WELCOME");
    child.setParent(parent);

    grandchild = (TransScreen)ScreenCalls.WELCOME.call(child);

  }

  @Test
  public void test_IsValid_OutOfBounds_Negative() {

    int expected = -1;
    int actual = child.isValid("-1");
    assertEquals(expected,actual);
    
  }

  @Test
  public void test_IsValid_InBounds() {

    int[] expected = new int[]{0,1};
    for (int e : expected) {
      int actual = child.isValid(""+e);
      assertEquals(e,actual);
    }
  }


  @Test
  public void test_IsValid_OutOfBounds_Positive() {

    int expected = -1;
    int actual = child.isValid("2");
    assertEquals(expected,actual);
    
  }

  
  @Test
  public void test_IsValid_OutOfBounds_NonNumericalString() {

    int expected = -1;
    int actual = child.isValid("Hello World!");
    assertEquals(expected,actual);
    
  }

  @Test
  public void test_next_OutOfBounds_Negative() {

    String expected = child.title;
    String actual = child.next("-1").title;
    assertEquals(expected,actual);
  
  }

  @Test
  public void test_next_Parent() {

    String expected = parent.title;
    String actual = child.next("0").title;
    assertEquals(expected,actual);
  
  }

  
  @Test
  public void test_next_Grandchild() {

    String expected = grandchild.title;
    String actual = child.next("1").title;
    assertEquals(expected,actual);
  
  }

  @Test
  public void test_next_OutOfBounds_Positive() {

    String expected = child.title;
    String actual = child.next("2").title;
    assertEquals(expected,actual);
  
  }

  @Test
  public void test_next_OutOfBounds_NonNumericalString() {

    String expected = child.title;
    String actual = child.next("Hello World!").title;
    assertEquals(expected,actual);
  
  }
}
