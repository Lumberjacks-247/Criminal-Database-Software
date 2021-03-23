package src;
import java.util.function.Function;

/**
 * This is class allows dynamic calls to methods via use of Strings.
 * A String used to call a method is referred to as a <i>Phone Number</i>.<p>
 * 
 * A <b>Phone Number</b> contains an <i>areaCode</i> and a <i>localNumber</i> seperated by a colon
 * -> "areaCode:localNumber" <p>
 * 
 * The <b> areaCode </b> corresponds to a grouping of commands. <p>
 * The <b> localNumber </b> corresponds to a certain command in that grouping. <p>
 * 
 * These are used together to call upon any method reference that is stored in a grouping
 * accessible by this class. 
 * 
 * <p>Current groupings:<p>
 *        F -> <code>FacCalls</code><p>
 *        S -> <code>ScreenCalls</code>
 * @author Blake Seekings
 * @version 1.0 - Base Implementaion
 * @since 3/21/2021
 * @see FacCalls
 * @see ScreenCalls
 */
public class Telephone {
  private enum Switchboard {

    F   (FacCalls::getFunct), // FacCalls
    S   (ScreenCalls::getFunct) //ScreenCalls
    ; 


    private Function<String,Function<Screen,Screen>> f;
    private Switchboard(Function<String,Function<Screen,Screen>> f_) {
      this.f = f_;
    }

    /**
     * Grabs the specific method reference denoted by the localNumber.
     * @param localNumber the string denoting a specific command in this enumeration's grouping
     * @return a Function object referencing a method in this enumeration's grouping 
     */
    private Function<Screen,Screen> plug(String localNumber) {
      return this.f.apply(localNumber);
    }

    /**
     * Connects to a specific method in a grouping.
     * @param phonenum the String specifying the grouping anc command to access
     * @return The Function which references the specified method
     */
    public static Function<Screen,Screen> connect(String phonenum) {
      
      String[] params = phonenum.split(":");
      String areaCode = params[0]; // Refers to the particular grouping of commands to be called
      String localNumber = params[1]; // Refers to the particular command to call

      return valueOf(areaCode).plug(localNumber);
    }


  }

  /**
   * Connects to a method using the <i>Phone Number</i> and calls it,
   * @param screen The Screen object to be passed as a parameter to the called method
   * @param phonenum The String Phone Number contaning the grouping and command to be accessed
   * @return The Screen object given back by the called method
   */
  public static Screen call(Screen screen, String phonenum) {
    return Switchboard.connect(phonenum).apply(screen);
  }
}