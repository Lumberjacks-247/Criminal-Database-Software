package src;

import java.io.File;
import java.io.FileWriter;


public class CriminalListScreen extends Screen {




  private Criminal[] list;
  private int numCriminals;
  private boolean allowChange = true;
  public  CriminalListScreen(Screen parent, Criminal[] list, int numCriminals) {
    this.parent = parent;
    this.list = list;
    this.numCriminals = numCriminals;
  }

  public CriminalListScreen(Screen parent, Criminal[] list, int numCriminals, boolean changeable) {
    this.parent = parent;
    this.list = list;
    this.numCriminals = numCriminals;
    this.allowChange = changeable;
  }


  public void display() {
    
    String title = UIConstants.center("Criminals") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numCriminals;count++)
      out += "\n(" + (count+1) + ") " + list[count].toString() + "\n\n";
    

    if (this.allowChange)
      out += "(" + (count+1) + ")" + " Add Criminal"   + "\n";
    else
      out += "\n(" + (count+1) + ")" + " Print Results" + "\n";

    out += "\n>> ";
    System.out.print(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (this.allowChange && i >= 0 && i <= this.numCriminals+1) {
        return i;
      } else if (i == 0 || i == this.numCriminals+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addCriminal(Criminal criminal,int index) {
    
    list[index] = criminal;
    if (index == numCriminals)
      numCriminals++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      if (this.allowChange)
        this.parent.updateCriminalList(this.list,numCriminals);
      return this.parent;
    }
    
    Criminal criminal;

    if (this.allowChange) {
      if (index-1 == numCriminals) {
        criminal = new Criminal();
      } else {
        criminal = list[index-1];
      }

      return new EditCriminalScreen(this,criminal,index-1);
    } else {
      if (index == numCriminals+1) {
        try (FileWriter writer = new FileWriter(new File("output.txt"))) {
          for (Criminal sus : this.list)
            writer.write("\n" + sus.toString() + "\n");
        } catch ( Exception e) {

        }
        return this.parent;
      }

      return null;
    }
  }
  
}
