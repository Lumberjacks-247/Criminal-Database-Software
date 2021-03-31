package src;
/**
 * Allows text to be written to output and cycles through contiguous Screen objects.
 * @author Blake Seekings
 * @version 3.0 - Implementing ScreenConsts enum
 * @since 3/18/2021
 * @see TransScreen
 * @see EditorScreen
 */
public abstract class Screen {


/*
##############################################################

                        Public Data         

##############################################################
*/
  public String name;
  
  public Screen getParent() {
    return this.parent;
  }

  /**
   * Grabs the prompt of a data point from a specified index.
   * @param index Index of data point to access prompt from
   * @return String prompt of data point
   */
  public String getPrompt(int index) {
    return this.data[index].prompt;
  }

  /**
   * Grabs data from a specified index.
   * @param index Specified index from which to get data
   * @return String data
   */ 
  public String getDataValue(int index) {
    return this.data[index].value;
  }

  /**
   * Sets the data at a specified index to the specified value.
   * @param index The index at which to set specified data
   * @param value The String value to set at the specified index
   */  
  public void setDataValue(int index, String value) {
    this.data[index].value = value;
  }



/*
##############################################################

                      Protected Data         

##############################################################
*/

  protected class Datum {
    public String prompt,value = null;
    public Datum(String prompt_) {prompt = prompt_;}
    public Datum(String prompt_,String value_) {prompt = prompt_;value = value_;}
    public String toString() { return prompt + ": " + value;}
  }



  protected Screen parent;
  protected Datum[] data;
  protected String[] links;

  /**
   * Parses the given String input and checks if it is valid, returns the parsed input if so.
   * @param input the String input from user
   * @return integer representaion of user input
   */
  protected int isValid(String input) {

    try {
      int index = Integer.parseInt(input);

      return (index >= 0 && index < this.links.length) ? index : -1;  // If choice is in range, return choice; else return -1

    } catch(Exception e) { return -1; }
  }

  /**
   * Sets the given Screen as the parent of this Screen.
   */
  protected void setParent(Screen parent) {
    this.parent = parent;
  }

  /**
   * Grabs the Datum at the specified index.
   * @param index The index of the desired Datum
   * @return The requested Datum object
   */
  protected Datum getDatum(int index) {
    return this.data[index];
  }

  protected void updatePOIList(POI[] arr,int num){}
  protected void updateSuspectList(Suspect[] arr,int num){}
  protected void updateCriminalList(POI[] arr,int num){}
  protected void updateOfficerList(POI[] arr,int num){}
  protected void updateVictimList(Victim[] arr,int num){}
  protected void updateEvidenceList(Evidence[] arr,int num){}


  

/*
##############################################################

                      Abstract Data         

##############################################################
*/
  
  /**
   * Displays this screen to output.
   */
  abstract public void display();
  
  /**
   * Grabs the next Screen.
   * @param input The String input captured from user
   * @return The next Screen in the sequence
   */
  abstract public Screen next(String input);

}
