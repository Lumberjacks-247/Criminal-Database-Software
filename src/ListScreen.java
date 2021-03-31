package src;

public class ListScreen<T> extends Screen {




  private T[] list;
  private int numT;
  private String type;
  public ListScreen(Screen parent, T[] list, int numT,String type) {
    this.list = list;
    this.numT = numT;
    this.type = type;
  }


  public void display() {
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numT;count++)
      out += "(" + count+1 + ") " + list[count].toString() + "\n";
    

    out += "(" + count+1 + ")" + " Add Instance"   + "\n";
    System.out.println(out);
  }


  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (i >= 0 && i <= this.numT+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }



  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == this.numT+1) {
      switch (type) {
        case "POI":
          return new EditPoiScreen(this);
        default:
          return null;
      }
    }
    

  }
  
}
