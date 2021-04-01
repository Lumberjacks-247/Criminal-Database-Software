package src;

public class EditPOIScreen extends Screen {
  
  
  private POI poi;
  private int parentIndex;
  POIListScreen parent;
  
  public EditPOIScreen(POIListScreen parent, POI poi, int index) {
    this.parent = parent;
    this.poi = poi;
    this.parentIndex = index;
  }

  public void display() {

    String title = UIConstants.center("Edit POI") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "First Name: \t\t" +           poi.getFirstName() + "\n";
    out += "Last Name: \t\t" +            poi.getLastName() + "\n";
    out += "Gender: \t\t" +               poi.getGender() + "\n";
    out += "Race: \t\t\t" +                 poi.getRace() + "\n";
    out += "Hair Color: \t\t" +           poi.getHairColor() + "\n";
    out += "Hair Style: \t\t" +           poi.getHairStyle() + "\n";
    out += "Eye Color: \t\t" +            poi.getEyeColor() + "\n";
    out += "Address: \t\t" +              poi.getAddress() + "\n";
    out += "Age: \t\t\t" +                  poi.getAge() + "\n";
    out += "Tattos: \t\t" +             poi.getTattoos() + "\n";
    out += "Gang: \t\t\t" +                 poi.getGang() + "\n";
    out += "Victim Relationship: \t" +  poi.getVictimRelationship() + "\n";
    out += "Evidence Connection: \t" +  poi.getEvidenceConnection() + "\n";
    out += "Repeat Offender: \t" +     (poi.getIsRepeatOffender() ? "true" : "false") + "\n";
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
    bot += "(15) Done";

    String disp = title + out + bot;
    disp += "\n>> ";
    System.out.print(disp);
  }


  public void setDataValue(int index,String value) {
    switch (""+index) {
      case "0":
        this.poi.setFirstName(value);
        break;
      case "1":
        this.poi.setLastName(value);
        break;
      case "2":
        this.poi.setGender(value);
        break;
      case "3":
        this.poi.setRace(value);
        break;
      case "4":
        this.poi.setHairColor(value);
        break;
      case "5":
        this.poi.setHairStyle(value);
        break;
      case "6":
        this.poi.setEyeColor(value);
        break;
      case "7":
        this.poi.setAddress(value);
        break;
      case "8":
        this.poi.setAge(value);
        break;
      case "9":
        this.poi.setTattoos(value);
        break;
      case "10":
        this.poi.setGang(value);
        break;
      case "11":
        this.poi.setVictimRelationship(value);
        break;
      case "12":
        this.poi.setEvidenceConnection(value);
        break;
      case "13":
        this.poi.changeRepeatOffender();
        break;
      default:

        
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"First Name: ",this.poi.getFirstName(),0);
      case "2":
        return new EnterDataScreen(this,"Last Name: ",this.poi.getLastName(),1);
      case "3":
        return new EnterDataScreen(this,"Gender: ",this.poi.getGender(),2);
      case "4":
        return new EnterDataScreen(this,"Race: ",this.poi.getRace(),3);
      case "5":
        return new EnterDataScreen(this,"Hair Color: ",this.poi.getHairColor(),4);
      case "6":
        return new EnterDataScreen(this,"Hair Style: ",this.poi.getHairStyle(),5);
      case "7":
        return new EnterDataScreen(this,"Eye Color: ",this.poi.getEyeColor(),6);
      case "8":
        return new EnterDataScreen(this,"Address: ",this.poi.getAddress(),7);
      case "9":
        return new EnterDataScreen(this,"Age: ",this.poi.getAge(),8);
      case "10":
        return new EnterDataScreen(this,"Tattoos: ",this.poi.getTattoos(),9);
      case "11":
        return new EnterDataScreen(this,"Gang: ",this.poi.getGang(),10);
      case "12":
        return new EnterDataScreen(this,"Victim Relationship: ",this.poi.getVictimRelationship(),11);
      case "13":
        return new EnterDataScreen(this,"Evidence Connection: ",this.poi.getEvidenceConnection(),12);
      case "14":
        this.poi.changeRepeatOffender();
        return this;
      case "15":
        this.parent.addPOI(poi, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
