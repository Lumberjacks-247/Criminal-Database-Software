package src;
//TODO - Add JavaDoc

public class FacUIConstants {
  private static Facade fac = new Facade();
  
  public static Screen searchReports(Screen s) {
    boolean override = true;

    String author = s.getDataValue(0); // Author
    String LofC = s.getDataValue(1); // LofC
    String jurisdiction = s.getDataValue(2); // Jurisdiction
    String TofC = s.getDataValue(3); // TofC
    String Location = s.getDataValue(4); // Location

    //TODO - Create success and failure branches
    if (/*fac.findCrime(crimeName)*/override) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.MAINMENU.call(s);
    }


  }
  public static Screen searchPeople(Screen s) {
    

    String p0 = s.getDataValue(0);  //First Name
    String p1 = s.getDataValue(1); //Last Name
    String p2 = s.getDataValue(2); //Gender
    String p3 = s.getDataValue(3); //Race
    String p4 = s.getDataValue(4); //Hair Color 
    String p5 = s.getDataValue(5); //Hair Style
    String p6 = s.getDataValue(6); //Eye Color
    String p7 = s.getDataValue(7); //Set Address
    String p8 = s.getDataValue(8); //Age

    //Search people
    /* Person[] people = fac.searchPeople(p0,p1,p2,p3,p4,p5,p6,p7,p8);*/

    return ScreenCalls.MAINMENU.call(s);
  }

  public static Screen logout(Screen s) {
    //fac.logout();
    return ScreenCalls.LOGOUT.call(s);
  }

  public static Screen login(Screen s) {
    String username = s.getDataValue(0);
    String password = s.getDataValue(1);

    //TODO - Create success and failure branches
    if (fac.login(username, password)/*override*/) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }

  }

  public static Screen createAccount(Screen s) {
    String p0 = s.getDataValue(0); //Username
    String p1 = s.getDataValue(1); //Password
    String p2 = s.getDataValue(2); //First Name
    int p3 = Integer.parseInt(s.getDataValue(3)); //Last Name
    String p4 = s.getDataValue(4); //Access Level


    //TODO - Create success and failure branches
    if (fac.createAccount(p0,p1,p2,p3,p4)/*override*/) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }
  }


}
