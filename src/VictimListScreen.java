package src;

public class VictimListScreen extends Screen {




  private Victim[] list;
  private int numVictim;
  public VictimListScreen(Screen parent, Victim[] list, int numVictim) {
    this.parent = parent;
    this.list = list;
    this.numVictim = numVictim;
  }


  public void display() {
    
    String title = UIConstants.center("Victims") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numVictim;count++)
      out += "(" + (count+1) + ") " + list[count].toString() + "\n";
    

    out += "(" + (count+1) + ")" + " Add Victim"   + "\n";
    System.out.println(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (i >= 0 && i <= this.numVictim+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addVictim(Victim victim,int index) {
    
    list[index] = victim;
    if (index == numVictim)
      numVictim++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      this.parent.updateVictimList(this.list,numVictim);
      return this.parent;
    }
    
    Victim victim;

    if (index-1 == numVictim) {
      victim = new Victim();
    } else {
      victim = list[index-1];
    }


    return new EditVictimScreen(this,victim,index-1);

    

  }
  
}
