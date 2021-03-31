package src;

/**
 * Defines how calls are made to the Facade.
 * @author Blake Seekings
 * @version 2.0
 * @see FacCalls
 * @see ScreenCalls
 * @see Facade
 */
public class FacUIConstants {
  private static Facade fac = new Facade();
  
  /**
   * Calls the Facade and passes Report information to search for. When given back
   * an array of Reports that partially match the given search information, displays
   * the reports to the screen.
   * @param s The Screen which contains the information of the Report Search
   * @return The Screen object representing a success or failure to find Reports
   */
  public static Screen searchReports(Screen s) {
    String id = s.getDataValue(0); //ID

    Crime crime = fac.findCrime(id);
    if (crime == null) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      System.out.println(crime);
      return ScreenCalls.MAINMENU.call(s);
    }


  }

  /**
   * Calls the Facade and passes the People information to search for. When
   * given back an array of Persons that partially match the search information,
   * displays the Persons to the screen.
   * @param s The Screen object containing the information for the Person Search
   * @return The Screen object representing a success or failure to find Persons
   */
//   public static Screen searchPeople(Screen s) {
//     
// 
//     String p0 = s.getDataValue(0);  //First Name
//     String p1 = s.getDataValue(1); //Last Name
//     String p2 = s.getDataValue(2); //Gender
//     String p3 = s.getDataValue(3); //Race
//     String p4 = s.getDataValue(4); //Hair Color 
//     String p5 = s.getDataValue(5); //Hair Style
//     String p6 = s.getDataValue(6); //Eye Color
//     String p7 = s.getDataValue(7); //Set Address
//     String p8 = s.getDataValue(8); //Age
// 
//     //Search people
//     /* Person[] people = fac.searchPeople(p0,p1,p2,p3,p4,p5,p6,p7,p8);*/
// 
//     return ScreenCalls.MAINMENU.call(s);
//   }

  /**
   * Calls the Facade to log the current user out. Returns the user to the
   * logout Screen, which is defined in <code> ScreenCalls </code>.
   * @param s The Screen which called for this method.
   * @return The defined Logout Screen
   */
  public static Screen logout(Screen s) {
    fac.logout();
    return ScreenCalls.LOGOUT.call(s);
  }

  /**
   * Calls the Facade and attempts to log a user in using information from the login Screen.
   * @param s The Screen containing the information for this login attempt
   * @return the Screen object representing a failure or success to login
   */
  public static Screen login(Screen s) {
    String username = s.getDataValue(0);
    String password = s.getDataValue(1);

    if (fac.login(username, password)) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }

  }

  /** 
   * Calls the Facade and attempts to create an acccount in the system.
   * @param s The Screen containing the Account information
   * @return The Screen representing the success or failure to create an account
   */
  public static Screen createAccount(Screen s) {
    String p0 = s.getDataValue(0); //Username
    String p1 = s.getDataValue(1); //Password
    String p2 = s.getDataValue(2); //First Name
    String p3 = s.getDataValue(3); //Last Name
    int p4 = Integer.parseInt(s.getDataValue(4)); //Access Level

    if (fac.createAccount(p0,p2,p3,p4,p1)) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }
    
  }

  public static Screen createCrime(Screen s) {
    return s.parent;
  }

}
