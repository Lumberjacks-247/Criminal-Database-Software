import java.util.function.Function;

public enum FacCalls {

    LOGIN         (FacUIConstants::login),
    LOGOUT        (FacUIConstants::logout),
    CREATEACCOUNT (FacUIConstants::createAccount),
    SEARCHPEOPLE  (FacUIConstants::searchPeople)
    ;

    public static Screen getF(Screen screen, String callName) {
      return FacCalls.valueOf(callName).call(screen);
    }

    private Function<Screen,Screen> f;

    private FacCalls(Function<Screen,Screen> f_) {
      this.f = f_;
    }

    public Screen call(Screen scrn) {
      return f.apply(scrn);
    }
}
