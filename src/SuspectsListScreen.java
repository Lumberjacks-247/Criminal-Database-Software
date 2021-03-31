package src;

public class SuspectsListScreen extends Screen {




  private Suspect[] list;
  private int numSuspects;
  public SuspectsListScreen(Screen parent, Suspect[] list, int numSuspects) {
    this.parent = parent;
    this.list = list;
    this.numSuspects = numSuspects;
  }


  public void display() {
    
    String title = UIConstants.center("Suspects") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numSuspects;count++)
      out += "(" + (count+1) + ") " + list[count].toString() + "\n";
    

    out += "(" + (count+1) + ")" + " Add Suspect"   + "\n";
    System.out.println(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (i >= 0 && i <= this.numSuspects+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addSuspect(Suspect suspect,int index) {
    
    list[index] = suspect;
    if (index == numSuspects)
      numSuspects++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      this.parent.updateSuspectList(this.list,numSuspects);
      return this.parent;
    }
    
    Suspect suspect;

    if (index-1 == numSuspects) {
      suspect = new Suspect();
    } else {
      suspect = list[index-1];
    }


    return new EditSuspectScreen(this,suspect,index-1);

    

  }
  
}
