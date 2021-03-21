import java.util.function.Function;

/**
 * Contains the different types of Screens and defines how they cycle
 * @author Blake Seekings
 * @version 2.0 Implement constructors and methods
 * @since 3/18/2021
 * @see Screen
 * @see UI
 */
public enum ScreenConsts {

    PARENT        (UIConstants::Parent),
    WELCOME       (UIConstants::Welcome),
    LOGIN         (UIConstants::Login),
    CREATEACCOUNT (UIConstants::CreateAccount),
    MAINMENU      (UIConstants::MainMenu);

    /* Method reference */
    private Function<Screen,Screen> f;
    
    /**
     * Constructs enum objects.
     * @param f_ Method reference to be stored in this enum
     */
    private ScreenConsts(Function<Screen,Screen> f_) {
      this.f = f_;
    }


    /** 
     * Calls the method reference of this enum to return a new Screen.
     * @param parent The object of Screen which called for a new Screen
     * @return A subclass of Screen with instance data and type provided by this enums 
     * method reference.
     */
    public Screen getScreen(Screen parent) {
      return this.f.apply(parent);
    }


}
