public class FacUIConstants {
  //private static Facade fac = new Facade();
  
  public static Screen logout(Screen s) {
    //fac.logout();
    return ScreenCalls.LOGOUT.call(s);
  }

  public static Screen login(Screen s) {
    String username = s.getDataValue(0);
    String password = s.getDataValue(1);

    if (/*fac.login(username, password)*/ true) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }

  }

  public static Screen createAccount(Screen s) {
    String p0 = s.getDataValue(0);
    String p1 = s.getDataValue(1);
    String p2 = s.getDataValue(2);
    int p3 = Integer.parseInt(s.getDataValue(3));
    String p4 = s.getDataValue(4);

    if (/*fac.createAccount(p0,p1,p2,p3,p4)*/true) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }
  }


}
