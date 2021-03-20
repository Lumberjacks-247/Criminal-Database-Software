public class TransScreen extends Screen {

  private String prompt;
  private ScreenType[] links;
  public TransScreen(String prompt, ScreenType[] links) {
    this.prompt = prompt;
    this.links = links;
  }

  public void display() {
    System.out.println(this.prompt);
    System.out.println("\n\n>>");
  }

  public Screen next(String input) {
    int index = Integer.parseInt(input);
    if (index < 0 || index >= links.length) {
      return this;
    }
    ScreenType scrn = this.links[index];
    Screen screen = CreateScreen(scrn);
    screen.type = scrn;
    screen.childOf(this);

    if (screen.type() == ScreenType.PARENT)
      return this.parent;

    return screen;
  }










}