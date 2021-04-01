package src;

public class EditCriminalScreen extends Screen {
  
  
  private Criminal criminal;
  private int parentIndex;
  CriminalListScreen parent;
  
  public EditCriminalScreen(CriminalListScreen parent, Criminal criminal, int index) {
    this.parent = parent;
    this.criminal = criminal;
    this.parentIndex = index;
  }

  public void display() {

    String title = UIConstants.center("Edit Criminal") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "First Name: \t" +           criminal.getFirstName() + "\n";
    out += "Last Name: \t" +            criminal.getLastName() + "\n";
    out += "Gender: \t\t" +               criminal.getGender() + "\n";
    out += "Race: \t\t" +                 criminal.getRace() + "\n";
    out += "Hair Color: \t" +           criminal.getHairColor() + "\n";
    out += "Hair Style: \t" +           criminal.getHairStyle() + "\n";
    out += "Eye Color: \t" +            criminal.getEyeColor() + "\n";
    out += "Address: \t" +              criminal.getAddress() + "\n";
    out += "Age: \t\t" +                  criminal.getAge() + "\n";
    out += "Tattos: \t" +             criminal.getTattoos() + "\n";
    out += "Gang: \t\t" +                 criminal.getGang() + "\n";
    out += "Victim Relationship: \t" +  criminal.getVictimRelationship() + "\n";
    out += "Evidence Connection: \t" +  criminal.getEvidenceConnection() + "\n";
    out += "Repeat Offender: \t" +     (criminal.getIsRepeatOffender() ? "true" : "false") + "\n";
    out += "PrefClothes: \t" +          criminal.getPrefferedClothes() + "\n";
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
        this.criminal.setFirstName(value);
        break;
      case "1":
        this.criminal.setLastName(value);
        break;
      case "2":
        this.criminal.setGender(value);
        break;
      case "3":
        this.criminal.setRace(value);
        break;
      case "4":
        this.criminal.setHairColor(value);
        break;
      case "5":
        this.criminal.setHairStyle(value);
        break;
      case "6":
        this.criminal.setEyeColor(value);
        break;
      case "7":
        this.criminal.setAddress(value);
        break;
      case "8":
        this.criminal.setAge(value);
        break;
      case "9":
        this.criminal.setTattoos(value);
        break;
      case "10":
        this.criminal.setGang(value);
        break;
      case "11":
        this.criminal.setVictimRelationship(value);
        break;
      case "12":
        this.criminal.setEvidenceConnection(value);
        break;
      case "13":
        this.criminal.changeRepeatOffender();
        break;
      case "14":
        this.criminal.setPrefferedClothes(value);
      default:

        
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"First Name: ",this.criminal.getFirstName(),0);
      case "2":
        return new EnterDataScreen(this,"Last Name: ",this.criminal.getLastName(),1);
      case "3":
        return new EnterDataScreen(this,"Gender: ",this.criminal.getGender(),2);
      case "4":
        return new EnterDataScreen(this,"Race: ",this.criminal.getRace(),3);
      case "5":
        return new EnterDataScreen(this,"Hair Color: ",this.criminal.getHairColor(),4);
      case "6":
        return new EnterDataScreen(this,"Hair Style: ",this.criminal.getHairStyle(),5);
      case "7":
        return new EnterDataScreen(this,"Eye Color: ",this.criminal.getEyeColor(),6);
      case "8":
        return new EnterDataScreen(this,"Address: ",this.criminal.getAddress(),7);
      case "9":
        return new EnterDataScreen(this,"Age: ",this.criminal.getAge(),8);
      case "10":
        return new EnterDataScreen(this,"Tattoos: ",this.criminal.getTattoos(),9);
      case "11":
        return new EnterDataScreen(this,"Gang: ",this.criminal.getGang(),10);
      case "12":
        return new EnterDataScreen(this,"Victim Relationship: ",this.criminal.getVictimRelationship(),11);
      case "13":
        return new EnterDataScreen(this,"Evidence Connection: ",this.criminal.getEvidenceConnection(),12);
      case "14":
        this.criminal.changeRepeatOffender();
        return this;
      case "15":
        return new EnterDataScreen(this,"Perferred Clothes: ",this.criminal.getPrefferedClothes(),14);
      case "16":
        this.parent.addCriminal(this.criminal, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
