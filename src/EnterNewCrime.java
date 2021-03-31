package src;

public class EnterNewCrime extends Screen {
  private final int MAX_POI_LENGTH = 20;
  private final int MAX_SUSPECT_LENGTH = 20;
  private final int MAX_CRIMINAL_LENGTH = 20;
  private final int MAX_VICTIM_LENGTH = 20;
  private final int MAX_OFFICER_LENGTH = 20;
  private final int MAX_EVIDENCE_LENGTH = 20;
  private final int NUM_CHOICES = 10;

 
  private POI[] pois = new POI[MAX_POI_LENGTH];
  private Suspect[] suspects = new Suspect[MAX_SUSPECT_LENGTH];
  private Criminal[] criminals = new Criminal[MAX_CRIMINAL_LENGTH];
  private Victim[] victims = new Victim[MAX_VICTIM_LENGTH];
  private Officer[] officers = new Officer[MAX_OFFICER_LENGTH];
  private Evidence[] evidence = new Evidence[MAX_EVIDENCE_LENGTH];


  private int numPOI = 0;
  private int numSuspects = 0;
  private int numCriminals = 0;
  private int numVictims = 0;
  private int numOfficers = 0;
  private int numEvidence = 0;

  public EnterNewCrime() {
    data = new Datum[]{new Datum("Type of Crime"),new Datum("Location"),new Datum("Author")};
  }

  public void display () {
    String title = UIConstants.center("Enter New Crime") + "\n";
    title += UIConstants.DIV;
    
    String body = "";
    body += data[0].prompt + ":\t" + data[0].value + "\n";
    body += data[1].prompt + ":\t" + data[1].value + "\n";
    body += data[2].prompt + ":\t\t" + data[2].value + "\n";
    body += "Pois: " + "\t\t" + numPOI + "\n";
    body += "Suspects: " + "\t" + numSuspects + "\n";
    body += "Criminals:" + "\t" + numCriminals + "\n";
    body += "Victims:" + "\t" + numVictims + "\n";
    body += "Officers:" + "\t" + numOfficers + "\n";
    body += "Evidence:" + "\t" + numEvidence + "\n";
    body += UIConstants.DIV;
 
    String choices = "";
    choices += "(0)\tCancel New Crime\n";
    choices += "(1)\tSet Type of Crime\n";
    choices += "(2)\tSet Location\n";
    choices += "(3)\tSet Author\n";
    choices += "(4)\tAccess POIs\n";
    choices += "(5)\tAccess Suspects\n";
    choices += "(6)\tAccess Criminals\n";
    choices += "(7)\tAccess Victims\n";
    choices += "(8)\tAccess Officers\n";
    choices += "(9)\tAccess Evidence\n";
    choices += "(10)\tCreate New Crime";


    String disp = title + body + choices;

    disp += "\n\n>> ";
    System.out.print(disp);

    
  }


  public int isValid(String input) {
    try {
      int i = Integer.parseInt(input);

      if (i >= 0 && i <= NUM_CHOICES)
        return i;

      return -1;
    } catch(Exception e) {
      return -1;
    }
  }
  public void updatePOIList(POI[] arr,int num) {
    this.pois = arr;
    this.numPOI = num;
  }
  public void updateSuspectList(Suspect[] arr,int num) {
    this.suspects = arr;
    this.numSuspects = num;
  }
  public void updateVictimList(Victim[] arr,int num) {
    this.victims = arr;
    this.numVictims = num;
  }
  public void updateEvidenceList(Evidence[] arr,int num) {
    this.evidence = arr;
    this.numEvidence = num;
  }
  public Screen next(String input) {
    int index;
    if ((index = isValid(input)) < 0)
      return this;

    String[] choices = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;L:POILIST;L:SUSPECTLIST;L:CRIMINALLIST;L:VICTIMLIST;L:OFFICERLIST;L:EVIDENCELIST;F:NEWCRIME".split(";");
    
    String choice = choices[index];

    if (choice.equals("ENTERDATA"))
      return new EnterDataScreen(this, index-1);

    switch (choice) {
      case "ENTERDATA":
        return new EnterDataScreen(this, index-1);
      case "L:POILIST":
        return new POIListScreen(this,this.pois,this.numPOI);
      case "L:SUSPECTLIST":
        return new SuspectsListScreen(this,this.suspects,this.numSuspects);
      // case "L:CRIMINALLIST":
      //   return new ListScreen();
      case "L:VICTIMLIST":
        return new VictimListScreen(this,this.victims,this.numVictims);
      // case "L:OFFICERLIST":
      //   return new ListScreen();
      case "L:EVIDENCELIST":
         return new EvidenceListScreen(this,this.evidence,this.numEvidence);
    }

    return Telephone.call(this,choice);
  }
  
}
