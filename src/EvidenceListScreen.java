package src;

public class EvidenceListScreen extends Screen {




  private Evidence[] list;
  private int numEvidence;
  public EvidenceListScreen(Screen parent, Evidence[] list, int numEvidence) {
    this.parent = parent;
    this.list = list;
    this.numEvidence = numEvidence;
  }


  public void display() {
    
    String title = UIConstants.center("Evidences") + "\n";
    title += UIConstants.DIV;

    
    int count = 0;
    String out = "(0) Back\n";
    for (;count < numEvidence;count++)
      out += "(" + (count+1) + ") " + list[count].toString() + "\n";
    

    out += "(" + (count+1) + ")" + " Add Evidence"   + "\n";
    System.out.println(title+out);
  }



  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);
      if (i >= 0 && i <= this.numEvidence+1) {
        return i;
      }
      return -1;
    } catch (Exception e) {
      return -1;
    }
  }


  public void addEvidence(Evidence evidence,int index) {
    
    list[index] = evidence;
    if (index == numEvidence)
      numEvidence++;
  }

  public Screen next(String input) {

    int index;
    if ((index = isValid(input)) < 0) 
      return this;

    if (index == 0) {
      this.parent.updateEvidenceList(this.list,numEvidence);
      return this.parent;
    }
    
    Evidence evidence;

    if (index-1 == numEvidence) {
      evidence = new Evidence();
    } else {
      evidence = list[index-1];
    }


    return new EditEvidenceScreen(this,evidence,index-1);

    

  }
  
}
