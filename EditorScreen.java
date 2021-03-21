/**
 * Displays text, allows transition to next Screen, allows user to change data displayed.
 * @author Blake Seekings
 * @version 3.0 Implementing ScreenConsts enum
 * @since 3/18/2021
 */
public class EditorScreen extends Screen {

  private class Datum {
    public String prompt,value = "";
    public Datum(String prompt_) {prompt = prompt_;}
    public String toString() { return prompt + ": " + value;}
  }

  private String title;
  private Datum[] data;
  private String[] choices;
  private String[] links;

  /**
   * Creates a new Editor Screen.
   * @param title_ String title of Screen
   * @param prompts_ Prompts for data points
   * @param choices_ Prompts for use choices
   * @param links_ Links to next Screen 
   */ 
  public EditorScreen(String title_, String prompts_,String choices_,String links_) {

    /* Title */
    this.title = title_;

    /* Data */
    String[] prompts = prompts_.split(";"); // Get prompts
    this.data = new Datum[prompts.length]; //Init
    for (int size=0; size<data.length;) { data[size] = new Datum(prompts[size++]); }  //Create new datum

    /* Choice Prompts */
    this.choices = choices_.split(";");

    /* Choice links */
    this.links = links_.split(";");

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

    } catch(Exception e) { return -1; } // If error, then invalid and return -1
  }

  public void display() {
    
    String top = "";
    top += "\t\t\t\t" + this.title + "\n";
    top += UIConstants.DIV + "\n";

    String mid = "";
    for(int i=0; i<data.length;) { mid += "\t\t\t\t" + this.data[i++] + "\n"; }
    
    String bot = UIConstants.DIV + "\n";
    for (int i=0;i<choices.length;) { bot += "\t\t\t\t(" + i + ") " + this.choices[i++] + "\n"; } 

    String display = top+mid+bot;
    display += "\n" + UIConstants.PROMPT;
    System.out.print(display);
    
  }

  /**
   * Grabs data from a specified index.
   * @param index Specified index from which to get data
   * @return String data
   */ 
  public String getData(int index) {
    return this.data[index].value;
  }

  /**
   * Sets the data at a specified index to the specified value.
   * @param index index at which to set specified dat
   * @param value The String data to set at the specified index
   */  
  public void setData(int index, String value) {
    this.data[index].value = value;
  }

  public Screen next(String input) {

    /* Check for Invalid Input */
    int choice;
    if ((choice = isValid(input)) < 0)
      return this;

    ScreenConsts scrntype = ScreenConsts.valueOf(links[choice]);
    Screen screen = scrntype.getScreen(this);
    return screen;
  }
}
