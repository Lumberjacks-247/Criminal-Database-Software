package src;

public class EditEvidenceScreen extends Screen {
  
  
  private Evidence evidence;
  private int parentIndex;
  EvidenceListScreen parent;
  
  public EditEvidenceScreen(EvidenceListScreen parent, Evidence evidence, int index) {
    this.parent = parent;
    this.evidence = evidence;
    this.parentIndex = index;
  }

  public void display() {

    String title = UIConstants.center("Edit Evidence") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "Description: " +           evidence.getDescription() + "\n";
    out += "Date of Discovery: " +     evidence.getDateOfDiscovery() + "\n";
    
    out += UIConstants.DIV;

    String bot = "";
    bot += "(0) Cancel\n";
    bot += "(1) Set Description\n";
    bot += "(2) Set Date of Discovery\n";
    bot += "(3) Done";

    String disp = title + out + bot;
    disp += "\n>> ";
    System.out.print(disp);
  }


  public void setDataValue(int index,String value) {
    switch (""+index) {
      case "0":
        this.evidence.setDescription(value);
        break;
      case "1":
        this.evidence.setDateOfDiscovery(value);
      default:
        break;

        
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this, "Description: ", this.evidence.getDescription(), 0);
      case "2":
        return new EnterDataScreen(this, "Date of Discovery: ", this.evidence.getDateOfDiscovery(), 1);
      case "3":
        this.parent.addEvidence(this.evidence, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
