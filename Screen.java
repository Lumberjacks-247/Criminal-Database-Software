public abstract class Screen {

  protected String data[];
  protected Screen parent;

  public Screen(Screen parent) {
    this.parent = parent;
  }
  
  protected void setData(String index, String value) {
    int i = Integer.parseInt(index);
    this.data[i] = value;
  }
  
  protected String getData(String index) {
    int i = Integer.parseInt(index);
    return this.data[i];
  }

  abstract public Screen next(String input);
  abstract public void display();

}
