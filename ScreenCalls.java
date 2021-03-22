import java.util.function.Function;

/**
 * Contains the different types of Screens and defines how they cycle.
 * @author Blake Seekings
 * @version 2.0 Implement constructors and methods
 * @since 3/18/2021
 * @see Screen
 * @see UI
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
    SEARCHREPORT  (UIConstants::SearchReportScreen),
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

    public static Screen getF(Screen screen, String callName) {
      return ScreenCalls.valueOf(callName).call(screen);
    }

    /** 
     * Calls the method reference of this enum to return a new Screen.
     * @param parent The object of Screen which called for a new Screen
     * @return A subclass of Screen with instance data and type provided by this enums 
     * method reference.
     */
    public Screen call(Screen parent) {
      return this.f.apply(parent);
    }

  
  


}
