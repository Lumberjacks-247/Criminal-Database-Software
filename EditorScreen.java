public class EditorScreen extends Screen {
  private String title;
  private String choices;
  private String[] dataPrompts;
  private String[] data;
  private ScreenType[] links;


  public EditorScreen(String title, String[] dataPrompts,String choices,ScreenType[] links) {
    this.title = title;
    this.dataPrompts = dataPrompts;
    this.choices = choices;
    this.links = links;
    this.data = new String[dataPrompts.length];
  }

  public void display() {
    System.out.println(this.title);

    for (int i = 0; i < data.length; ++i) {
      System.out.print(this.dataPrompts[i] + ": ");
      System.out.println(this.data[i]);
    }

    System.out.println(this.choices);
  }

  public String getData(int index) {
    return this.data[index];
  }

  public void setData(String index, String value) {
    int i = Integer.parseInt(index);
    this.data[i] = value;
  }

  public Screen next(String input) {
    
    int index;
    try {
      index = Integer.parseInt(input);
    } catch(Exception e) {
      return this;
    }

    if (index < 0 || index >= this.links.length) {
      return this;
    }

    if (this.links[index] == ScreenType.ENTERDATA) {
      /* Pass important data */
      EnterDataScreen dataScreen = new EnterDataScreen(this, this.dataPrompts[index-1],index-1 + "");
      dataScreen.childOf(this);
      return dataScreen;

    }

    if (this.links[index] == ScreenType.PARENT) {
      return this.parent;
    }

    if (this.links[index] == ScreenType.SUBMITDATA) {
      return CallFacade(this.type,this);
    }

    Screen scrn = CreateScreen(this.links[index]);
    scrn.childOf(this);
    return scrn;
  }
}
