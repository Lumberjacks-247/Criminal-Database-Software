public class EnterDataScreen extends Screen {
  

  private EditorScreen parent;
  private String dataPrompt;
  private int dataIndex;
  
  public EnterDataScreen(EditorScreen parent, String dataPrompt,String dataIndex) {

    this.parent = parent;
    this.dataPrompt = dataPrompt;
    this.dataIndex = Integer.parseInt(dataIndex);

  }

  public void childOf(EditorScreen parent) {
    this.parent = parent;
  }

  public void display() {
    System.out.println("Old " + this.dataPrompt + ": " + this.parent.getData(this.dataIndex));
    System.out.print("New " + this.dataPrompt + ": ");
  }

  public Screen next(String input) {
    this.parent.setData(this.dataIndex+"", input);
    return this.parent;
  }
}
