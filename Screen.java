public abstract class Screen extends Screens {

  /* Base implementation */

  protected Screen parent;
  protected ScreenType type;
  public Screen back() {
    return this.parent;
  }

  protected void childOf(Screen parent) {
    this.parent = parent;
  }

  protected ScreenType type() {
    return this.type;
  }

  /* Abstract Implementation */
  
  abstract public void display();
  abstract public Screen next(String input);



  


}