/**
 * This screen allows change via user input to a specified field of data from an EditorScreen.
 * Both of which are passed as arguements.
 * 
 * @author Blake Seekings
 * @see EditorScreen
 */
public class EnterDataScreen extends Screen {
  
  private Screen parent;
  private Datum data;
  private int index;
  
  /**
   * Constructs a new EnterDataScreen.
   * This Screen is linked to a single Screen and data point, passed as arguements.
   * @param parent The Screen where a change in data has been requested 
   * @param dataIndex The index of the data point in parent
   */
  public EnterDataScreen(Screen parent, int dataIndex) {

    this.parent = parent;
    this.index = dataIndex;
    this.data = this.parent.getDatum(index);

  }

  public void display() {
    System.out.println(data);
    System.out.print(data.prompt + ": ");
  }

  /**
   * @param input String input grabbed from user
   */
  public Screen next(String input) {
    this.parent.setDataValue(this.index,input);
    return this.parent;
  }
}
