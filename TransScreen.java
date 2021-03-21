/**
 * Displays text and allows transition to next Screen.
 * @author Blake Seekings
 * @version 3.0 - Implementing ScreenConsts enum
 * @since 3/18/2021
 */
public class TransScreen extends Screen {

  private String title;
  private String[] choices;
  private String[] links;

  /**
   * Creates a new Transition Screen.
   * @param title_    String title of Screen
   * @param choices_  String of ; delimited user choice prompts
   * @param links_    String of ; delimited links to next Screen
   */
  public TransScreen(String title_,String choices_, String links_) {
    this.title = title_;
    this.choices = choices_.split(";");
    this.links = links_.split(";");
  }

  public void display() {

    String top = "\t\t\t\t" + this.title + "\n";
    top += UIConstants.DIV + "\n";


    String bot = "";
    for (int i=0;i<choices.length;) {bot += "\t\t\t\t(" + i + ") " + this.choices[i++] + "\n";}

    String display = top + bot;
    display += "\n" + UIConstants.PROMPT;
    System.out.print(display);

  }

    /**
   * Parses the given String input and checks if it is valid, returns the parsed input if so.
   * @param input the String input from user
   * @return integer representaion of user input
   */
  private int isValid(String input) {

    try {
      int index = Integer.parseInt(input);

      return (index >= 0 && index < this.links.length) ? index : -1;  // If choice is in range, return choice; else return -1

    } catch(Exception e) { return -1; }
  }

  public Screen next(String input) {

    /* Check for Invalid Input */
    int choice;
    if ((choice = isValid(input)) < 0)
      return this;

    /* Move to next screen */
    ScreenConsts scrntype = ScreenConsts.valueOf(this.links[choice]);
    Screen screen = scrntype.getScreen(this);
    return screen;
  }










}