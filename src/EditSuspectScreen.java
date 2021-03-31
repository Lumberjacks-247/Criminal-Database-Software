package src;

public class EditSuspectScreen extends Screen {
  
  
  private Suspect suspect;
  private int parentIndex;
  SuspectsListScreen parent;
  
  public EditSuspectScreen(SuspectsListScreen parent, Suspect suspect, int index) {
    this.parent = parent;
    this.suspect = suspect;
    this.parentIndex = index;
  }

  public void display() {

    String title = UIConstants.center("Edit Suspect") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "First Name: " +           suspect.getFirstName() + "\n";
    out += "Last Name: " +            suspect.getLastName() + "\n";
    out += "Gender: " +               suspect.getGender() + "\n";
    out += "Race: " +                 suspect.getRace() + "\n";
    out += "Hair Color: " +           suspect.getHairColor() + "\n";
    out += "Hair Style: " +           suspect.getHairStyle() + "\n";
    out += "Eye Color: " +            suspect.getEyeColor() + "\n";
    out += "Address: " +              suspect.getAddress() + "\n";
    out += "Age: " +                  suspect.getAge() + "\n";
    out += "Tattos: : " +             suspect.getTattoos() + "\n";
    out += "Gang: " +                 suspect.getGang() + "\n";
    out += "Victim Relationship: " +  suspect.getVictimRelationship() + "\n";
    out += "Evidence Connection: " +  suspect.getEvidenceConnection() + "\n";
    out += "Repeat Offender: " +     (suspect.getIsRepeatOffender() ? "true" : "false") + "\n";
    out += "PrefClothes: " +          suspect.getPrefferedClothes() + "\n";
    out += UIConstants.DIV;

    String bot = "";
    bot += "(0) Cancel\n";
    bot += "(1) Set First Name\n";
    bot += "(2) Set Last Name\n";
    bot += "(3) Set Gender\n";
    bot += "(4) Set Race \n";
    bot += "(5) Set Hair Color\n";
    bot += "(6) Set Hair Style\n";
    bot += "(7) Set Eye Color\n";
    bot += "(8) Set Address\n";
    bot += "(9) Set Age\n";
    bot += "(10) Set Tattos\n";
    bot += "(11) Set Gang\n";
    bot += "(12) Set Victim Relationship\n";
    bot += "(13) Set Evidence Connection\n";
    bot += "(14) Change Repeat Offender\n";
    bot += "(15) Set Preffered Clothes\n";
    bot += "(16) Done";

    String disp = title + out + bot;
    disp += "\n>> ";
    System.out.print(disp);
  }


  public void setDataValue(int index,String value) {
    switch (""+index) {
      case "0":
        this.suspect.setFirstName(value);
        break;
      case "1":
        this.suspect.setLastName(value);
        break;
      case "2":
        this.suspect.setGender(value);
        break;
      case "3":
        this.suspect.setRace(value);
        break;
      case "4":
        this.suspect.setHairColor(value);
        break;
      case "5":
        this.suspect.setHairStyle(value);
        break;
      case "6":
        this.suspect.setEyeColor(value);
        break;
      case "7":
        this.suspect.setAddress(value);
        break;
      case "8":
        this.suspect.setAge(value);
        break;
      case "9":
        this.suspect.setTattoos(value);
        break;
      case "10":
        this.suspect.setGang(value);
        break;
      case "11":
        this.suspect.setVictimRelationship(value);
        break;
      case "12":
        this.suspect.setEvidenceConnection(value);
        break;
      case "13":
        this.suspect.changeRepeatOffender();
        break;
      case "14":
        this.suspect.setPrefferedClothes(value);
      default:

        
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"First Name: ",this.suspect.getFirstName(),0);
      case "2":
        return new EnterDataScreen(this,"Last Name: ",this.suspect.getLastName(),1);
      case "3":
        return new EnterDataScreen(this,"Gender: ",this.suspect.getGender(),2);
      case "4":
        return new EnterDataScreen(this,"Race: ",this.suspect.getRace(),3);
      case "5":
        return new EnterDataScreen(this,"Hair Color: ",this.suspect.getHairColor(),4);
      case "6":
        return new EnterDataScreen(this,"Hair Style: ",this.suspect.getHairStyle(),5);
      case "7":
        return new EnterDataScreen(this,"Eye Color: ",this.suspect.getEyeColor(),6);
      case "8":
        return new EnterDataScreen(this,"Address: ",this.suspect.getAddress(),7);
      case "9":
        return new EnterDataScreen(this,"Age: ",this.suspect.getAge(),8);
      case "10":
        return new EnterDataScreen(this,"Tattoos: ",this.suspect.getTattoos(),9);
      case "11":
        return new EnterDataScreen(this,"Gang: ",this.suspect.getGang(),10);
      case "12":
        return new EnterDataScreen(this,"Victim Relationship: ",this.suspect.getVictimRelationship(),11);
      case "13":
        return new EnterDataScreen(this,"Evidence Connection: ",this.suspect.getEvidenceConnection(),12);
      case "14":
        this.suspect.changeRepeatOffender();
        return this;
      case "15":
        return new EnterDataScreen(this,"Perferred Clothes: ",this.suspect.getPrefferedClothes(),14);
      case "16":
        this.parent.addSuspect(this.suspect, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
