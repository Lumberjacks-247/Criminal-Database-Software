package src;
/**
 * Displays text, allows transition to next Screen, allows user to change data displayed.
 * @author Blake Seekings
 * @version 3.0 Implementing ScreenConsts enum
 * @since 3/18/2021
 */
public class EditorScreen extends Screen {


  private String title;
  private String[] choices;


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
   * @param input String input grabbed from user
   */
  public Screen next(String input) {

    /* Check for Invalid Input */
    int choice;
    if ((choice = isValid(input)) < 0)
      return this;

    
    String phoneNumber = this.links[choice];
    if (phoneNumber.equals("ENTERDATA"))
      return UIConstants.EnterData(this, choice-1);
    
    
    return Telephone.call(this,phoneNumber);
    
  }
}
