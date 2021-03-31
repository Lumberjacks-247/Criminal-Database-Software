package src;

public class EditVictimScreen extends Screen {
  
  
  private Victim victim;
  private int parentIndex;
  VictimListScreen parent;
  
  public EditVictimScreen(VictimListScreen parent, Victim victim, int index) {
    this.parent = parent;
    this.victim = victim;
    this.parentIndex = index;
  }

  public void display() {

    String title = UIConstants.center("Edit Victim") + "\n";
    title += UIConstants.DIV;

    String out = "";
    out += "First Name: " +           victim.getFirstName() + "\n";
    out += "Last Name: " +            victim.getLastName() + "\n";
    out += "Gender: " +               victim.getGender() + "\n";
    out += "Race: " +                 victim.getRace() + "\n";
    out += "Hair Color: " +           victim.getHairColor() + "\n";
    out += "Hair Style: " +           victim.getHairStyle() + "\n";
    out += "Eye Color: " +            victim.getEyeColor() + "\n";
    out += "Address: " +              victim.getAddress() + "\n";
    out += "Age: " +                  victim.getAge() + "\n";
    out += "Statement: " +            victim.getStatement() + "\n";
    out += "Alive: " +                (victim.getIsAlive() ? "true" : "false") + "\n";
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
    bot += "(10) Set Statement\n";
    bot += "(11) Kill/Resurrect\n";
    bot += "(12) Done";

    String disp = title + out + bot;
    disp += "\n>> ";
    System.out.print(disp);
  }


  public void setDataValue(int index,String value) {
    switch (""+index) {
      case "0":
        this.victim.setFirstName(value);
        break;
      case "1":
        this.victim.setLastName(value);
        break;
      case "2":
        this.victim.setGender(value);
        break;
      case "3":
        this.victim.setRace(value);
        break;
      case "4":
        this.victim.setHairColor(value);
        break;
      case "5":
        this.victim.setHairStyle(value);
        break;
      case "6":
        this.victim.setEyeColor(value);
        break;
      case "7":
        this.victim.setAddress(value);
        break;
      case "8":
        this.victim.setAge(value);
        break;
      case "9":
        this.victim.setStatement(value);
        break;
      case "10":
        this.victim.changeIsAlive();
      default:

        
    }
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"First Name: ",this.victim.getFirstName(),0);
      case "2":
        return new EnterDataScreen(this,"Last Name: ",this.victim.getLastName(),1);
      case "3":
        return new EnterDataScreen(this,"Gender: ",this.victim.getGender(),2);
      case "4":
        return new EnterDataScreen(this,"Race: ",this.victim.getRace(),3);
      case "5":
        return new EnterDataScreen(this,"Hair Color: ",this.victim.getHairColor(),4);
      case "6":
        return new EnterDataScreen(this,"Hair Style: ",this.victim.getHairStyle(),5);
      case "7":
        return new EnterDataScreen(this,"Eye Color: ",this.victim.getEyeColor(),6);
      case "8":
        return new EnterDataScreen(this,"Address: ",this.victim.getAddress(),7);
      case "9":
        return new EnterDataScreen(this,"Age: ",this.victim.getAge(),8);
      case "10":
        return new EnterDataScreen(this, "Statement: ", this.victim.getStatement(), 9);
      case "11":
        this.victim.changeIsAlive();
        return this;
      case "12":
        this.parent.addVictim(this.victim, parentIndex);
        return this.parent;
      default:
        return this;

    }
  }
}
