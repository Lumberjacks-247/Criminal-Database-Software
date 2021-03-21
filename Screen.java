/**
 * Allows text to be written to output and cycles through contiguous Screen objects.
 * @author Blake Seekings
 * @version 3.0 - Implementing ScreenConsts enum
 * @since 3/18/2021
 * @see TransScreen
 * @see EditorScreen
 */
public abstract class Screen {

  /* Base implementation */

  protected Screen parent;
  protected ScreenConsts ScreenType;

  public Screen getParent() {
    return this.parent;
  }

  /**
   * Sets the given Screen as the parent of this Screen.
   */
  protected void setParent(Screen parent) {
    this.parent = parent;
  }

  /**
   * Returns a ScreenConsts denoting the type of this Screen.
   * @return ScreenConsts of this Screen
   */
  protected ScreenConsts getType() {
    return this.ScreenType;
  }

  /* Abstract Implementation */
  
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
