import java.util.function.BiFunction;

/**
 * Allows calls to methods using Strings.
 */
public class Telephone {
  private enum Operator {

    F   (FacCalls::getF),
    S   (ScreenCalls::getF);


    private BiFunction<Screen,String,Screen> f;
    private Operator(BiFunction<Screen,String,Screen> f_) {
      this.f = f_;
    }

    public Screen direct(Screen screen,String callName) {
      return this.f.apply(screen,callName);
    }


  }

  public static Screen call(Screen screen, String number) {
    String[] params = number.split(":");
    String areaCode = params[0];
    String lineNumber = params[1];

    Operator op = Operator.valueOf(areaCode);
    return op.direct(screen,lineNumber);
  }
}