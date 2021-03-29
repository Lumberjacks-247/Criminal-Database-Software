package src;
import java.util.function.Function;

/**
 * Enumerations of this type calls upon <code>Facade</code> to perfrom operations.
 * Each enumeration stores a reference to a method in <code>FacUIConstants</code>.
 * @author Blake Seekings
 * @version 1.3
 * @see FacUIConstants
 * @see Telephone
 */
public enum FacCalls {

    LOGIN         (FacUIConstants::login),
    LOGOUT        (FacUIConstants::logout),
    CREATEACCOUNT (FacUIConstants::createAccount),
    CREATECRIME   (FacUIConstants::createCrime)
    //SEARCHPEOPLE  (FacUIConstants::searchPeople),
    //SEARCHREPORTS (FacUIConstants::searchReports)
    ;


    /**
     * Grabs the method reference from an enumeration.
     * @param command the string value of the enumeration to grab from
     * @return the method reference of the enumeration
     */ 
    public static Function<Screen,Screen> getFunct(String command) {
      return valueOf(command).f;
    }

    private Function<Screen,Screen> f;

    /**
     * @param f_ A method reference which takes in a Screen object and returns a Screen object
     */
    private FacCalls(Function<Screen,Screen> f_) {
      this.f = f_;
    }

    /** 
     * Makes a call to the method reference of this enumeration.
     * @param screen the screen passed as a parameter to the method reference
     * @return the screen object constructed by the method reference
     */
    public Screen call(Screen screen) {
      return f.apply(screen);
    }
}
