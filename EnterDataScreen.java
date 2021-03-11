public class EnterDataScreen extends Screen {

  public EnterDataScreen(Screen parent, String prompt, String dataIndex) {
    super(parent);
    this.data = new String[2];
    this.data[0] = prompt;
    this.data[1] = dataIndex;
  }

  public void display() {
    System.out.println("Current " + this.data[0] + ": " + this.parent.getData(this.data[1]));
    System.out.print("New " + this.data[0]  + ": ");
  }

  public Screen next(String input) {
    this.parent.setData(this.data[1],input);
    return this.parent;
  }
}