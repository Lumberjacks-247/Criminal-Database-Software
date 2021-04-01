package src;
//TODO - Add JavaDoc

import java.io.File;
import java.io.FileWriter;

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
      try (FileWriter writer = new FileWriter(new File("output.txt"));) {
        writer.write(crime.toString());
      } catch( Exception e) {
        
      }
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
  public static Screen searchCriminals(Screen s) {
    

    String p0 = s.getDataValue(0); //First Name
    String p1 = s.getDataValue(1); //Last Name
    String p2 = s.getDataValue(2); //Gender
    String p3 = s.getDataValue(3); //Race
    String p4 = s.getDataValue(4); //Hair Color 
    String p5 = s.getDataValue(5); //Hair Style
    String p6 = s.getDataValue(6); //Eye Color
    String p7 = s.getDataValue(7); //Set Address
    String p8 = s.getDataValue(8); //Age
    String p9 = s.getDataValue(9); // Height
    String p10 = s.getDataValue(10);  //Tattoos
    String p11 = s.getDataValue(11); //Gang
    String p12 = s.getDataValue(12); //Victim Relation
    String p13 = s.getDataValue(13); //Evidence
    boolean  p14 = s.getDataValue(14) == null ? false : s.getDataValue(14).equalsIgnoreCase("true"); //isRepeatOffender 
    String p15 = s.getDataValue(15); //Clothes
    String p16 = s.getDataValue(16); //Nicknames
    String p17 = s.getDataValue(17); //Common Words
    String p18 = s.getDataValue(18); //Hobbies
    String p19 = s.getDataValue(19); //Job
    String p20 = s.getDataValue(20); //Physical Traits
    String p21 = s.getDataValue(21) == null ? "" : s.getDataValue(21); //Sentence
    String p22 = s.getDataValue(22); //Status
    boolean p23 = s.getDataValue(23) == null ? false : s.getDataValue(23).equalsIgnoreCase("true"); //In Custody

    Criminal partial = new Criminal(p0,p1,null,p2,p3,p4,p5,p6,p7,p8,p10,p11,p12,p13,p14,null,null,-1,p15,p16,p17,p18,p19,null,p9,p20,p21,p22,p23);

    Criminal[] crimmies = fac.searchCriminals(partial);

    int numCrimmies = 0;
    for (Criminal crim : crimmies) {
      if (crim == null)
        break;
      numCrimmies++;
    }

    return new CriminalListScreen(s,crimmies,numCrimmies,false);
  }

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
    EnterNewCrime c = (EnterNewCrime)s;
    String p0 = c.getDataValue(0); // Type of Crime
    String p1 = c.getDataValue(1); // Location
    String p2 = c.getDataValue(2); // Author
    POI[] p3 = c.pois;
    Suspect[] p4 = c.suspects;
    Criminal[] p5 = c.criminals;
    Victim[] p6 = c.victims;
    Officer[] p7 = c.officers;
    Evidence[] p8 = c.evidence;

    fac.addCrime(p0,p1,p2,p3,p4,p5,p6,p7,p8);

    return s.parent;
  }

}
