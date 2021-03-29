package src;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * An enumeration of this type constructs <code>Screen</code> objects when called.
 * Each enumeration stores a reference to a method in <code>UIConstants</code>.
 * @author Blake Seekings
 * @version 1.4
 */
public enum ScreenCalls {

    NULL          (UIConstants::Null),
    START         (UIConstants::WelcomeScreen),
    RESULTS       (UIConstants::ResultScreen),
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
    private BiFunction<Screen,Object[],Screen> b;
    /**
     * Constructs enum objects.
     * @param f_ Method reference to be stored in this enum
     */
    private ScreenCalls(Function<Screen,Screen> f_) {
      this.f = f_;
    }

    private ScreenCalls(BiFunction<Screen,Object[],Screen> b_) {
      this.b = b_;
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

    public Screen call(Screen screen, Object[] objs) {
      return this.b.apply(screen, objs);
    }

  
  


}
