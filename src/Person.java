package src;
import java.text.DecimalFormat;

public class Person {

    protected String firstName ,lastName ,id ,gender ,race ,hairColor ,hairStyle ,eyeColor ,address ,age;
    protected static int idCount = 0;
    protected static String BLANK = "";
    DecimalFormat df = new DecimalFormat("000000");


    public Person() {};
    /**
     * Creates Person object with passed in first and last name
     * @param firstName first name of person
     * @param lastName lsat name of person
     */
    public Person(String firstName, String lastName) {
        this.init(firstName,lastName,null,null,null,null,null,null,null,null);
        idCount++;
        this.setID();
    }

    /**
     * creates Person object with passed in parameters from json file
     * @param firstName first name of person
     * @param lastName last name of person
     * @param id id of person
     * @param gender gender of person
     * @param race race of person
     * @param hairColor hair color of person
     * @param hairStyle hair style of person
     * @param eyeColor eye color of person
     * @param address address of persons home
     * @param age age of person
     */
    public Person(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, String age) {
        this.init( firstName,  lastName,  id,  gender,  race,  hairColor,  hairStyle,  eyeColor,  address,  age);
    }

    protected void init(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, String age) {
      this.firstName = firstName == null ? "" : firstName;
      this.lastName = lastName == null ? "" : lastName;
      this.id = id == null ? getNewID() : id;
      this.gender = gender == null ? "" : gender;
      this.race = race == null ? "" : race;
      this.hairColor = hairColor == null ? "" : hairColor;
      this.hairStyle = hairStyle == null ? "" : hairStyle;
      this.eyeColor = eyeColor == null ? "" : eyeColor;
      this.address = address == null ? "" : address;
      this.age = age == null ? "" : age;
    }

    //need to check all Person object to see if id already is being used
    protected void setID() {
        this.id = "P" + df.format(idCount);
    }

    protected String getNewID() {
      idCount++;
      return "P" + df.format(idCount);
    }
    /**
     * Returns first name of person
     * @return first name of person as a String
     */
    public String getFirstName() {
        return this.firstName;
    }

    protected void setFirstName(String val) {
      this.firstName = val;
   }

    /**
     * Returns last name of person
     * @return last name of person as a String
     */
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String val) {
      this.lastName = val;
  }


    /**
     * Changes name of person to passed in first and last name
     * @param firstName new first name
     * @param lastName new last name
     */
    public void changeName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns id of person
     * @return id as a String
     */
    public String getID() {
        return this.id;
    }

    /**
     * returns age of person
     * @return age as a String
     */
    public String getAge() {
        return this.age;
    }

    /**
     * sets age of person to passed in age
     * @param age age of person as a String
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * returns gender of person
     * @return gender of person as a String
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * sets gender of person to gender passed in
     * @param gender gender of person as a String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * returns race of person
     * @return race of person as a String
     */
    public String getRace() {
        return this.race;
    }

    /**
     * sets race of person to race passed in
     * @param race race of person as a String
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * returns hair color of person
     * @return hair color of person as a String
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * sets hair color of person to hair color passed in
     * @param hairColor hair color of person as a String
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * returns hair style of person
     * @return hair style of person as a String
     */
    public String getHairStyle() {
        return this.hairStyle;
    }

    /**
     * sets hair style of person to hair style passed in
     * @param hairStyle hair style of person as a String
     */
    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }

    /**
     * returns eye color of person
     * @return eye color of person as a String
     */
    public String getEyeColor() {
        return this.eyeColor;
    }

    /**
     * sets eye color of person to passed in eye color
     * @param eyeColor eye color of person as a String
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * returns address of person
     * @return address of person as a String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * sets address of person to passed in address
     * @param address address of person as a String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
      String[] details = new String[]{firstName,lastName,age,gender,race,hairColor,hairStyle,eyeColor,address};
      String[] prompts = new String[]{"First Name: ","Last Name: ","Age: ","Gender: ","Race: ","Hair Color: ","Hair Style: ","Eye Color: ","Address: "};
      
      String output = "";
      String buffer = "";
      for (int i = 0; i < details.length;i++) {
        String detail = details[i];
        String prompt = prompts[i];

        if (!detail.equals("")) {
          output += buffer + prompt + detail;
          buffer = " | "; 
        } 

        
      }

      return output;
    }

    /**
     * CALLING OBJECT MUST BE PERSON WITH SEARCH INFO WHILE PARAMETER IS ALREADY CREATED PERSON
     * @param person person object to see if their info matches search info
     * @return true if partial match is found, false if not
     */
    public boolean partialCompare(Person person) {
  

      if(!this.getFirstName().equals(""))
        if(!this.getFirstName().equalsIgnoreCase(person.getFirstName()))
              return false;

      if(!this.getLastName().equals(""))
        if(!this.getLastName().equalsIgnoreCase(person.getLastName()))
          return false;
        
      //if(!compareID(person)) return false;

      if(!this.getGender().equals(""))
        if(!this.getGender().equalsIgnoreCase(person.getGender()))
          return false;

      if(!this.getRace().equals(""))
        if(!this.getRace().equalsIgnoreCase(person.getRace()))
          return false;

      if(!this.getHairColor().equals(""))
        if(!this.getHairColor().equalsIgnoreCase(person.getHairColor()))
          return false;
      
      if(!this.getHairStyle().equals(""))
        if(!this.getHairStyle().equalsIgnoreCase(person.getHairStyle()))
            return false;

      if(!this.getEyeColor().equals(""))
        if(!this.getEyeColor().equalsIgnoreCase(person.getEyeColor()))
          return false;

      if(!this.getAddress().equals(""))    
        if(!this.getAddress().equalsIgnoreCase(person.getAddress()))
          return false;

      if(!this.getAge().equals(""))
        if(!this.getAge().equalsIgnoreCase(person.getAge()))
          return false;
      
      return true;
    }

    public boolean compareID(Person person) {
        return(this.getID().equals(person.getID()));
    }

}

