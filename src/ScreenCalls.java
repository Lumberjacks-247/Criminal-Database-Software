package src;
import java.util.function.Function;

/**
 * An enumeration of this type constructs <code>Screen</code> objects when called.
 * Each enumeration stores a reference to a method in <code>UIConstants</code>.
 * @author Blake Seekings
 * @version 1.4
 */
public enum ScreenCalls {

    NULL          (UIConstants::Null),
    START         (UIConstants::WelcomeScreen),
    PARENT        (UIConstants::ParentScreen),
    WELCOME       (UIConstants::WelcomeScreen),
    LOGIN         (UIConstants::LoginScreen),
    LOGOUT        (UIConstants::WelcomeScreen),
    CREATEACCOUNT (UIConstants::CreateAccountScreen),
    SEARCH        (UIConstants::SearchScreen),
    SEARCHPEOPLE  (UIConstants::SearchPeopleScreen),
    SEARCHREPORTS  (UIConstants::SearchReportsScreen),
    MAINMENU      (UIConstants::MainMenuScreen);

    /* Method reference */
    private Function<Screen,Screen> f;
    /**
     * Constructs enum objects.
     * @param f_ Method reference to be stored in this enum
     */
    private ScreenCalls(Function<Screen,Screen> f_) {
      this.f = f_;
    }

    /**
     * Grabs the method reference from an enumeration.
     * @param command the string value of the enumeration to grab from
     * @return the method reference of the enumeration
     */ 
    public static Function<Screen,Screen> getFunct(String command) {
      return valueOf(command).f;
    }

    /** 
     * Makes a call to the method reference of this enumeration.
     * @param screen the screen passed as a parameter to the method reference
     * @return the screen object constructed by the method reference
     */
    public Screen call(Screen screen) {
      return this.f.apply(screen);
    }

  
  


}
