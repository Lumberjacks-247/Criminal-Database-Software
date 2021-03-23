import java.util.ArrayList;

public class Person {

    private String firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address;
    private int age; 
    private static int idCount = 000000;
    private static Person person;
    private ArrayList<Person> personList;

    /**
     * Creates Person object with passed in first and last name
     * @param firstName first name of person
     * @param lastName lsat name of person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    public Person(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.race = race;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;
        this.eyeColor = eyeColor;
        this.address = address;
        this.age = age;
    }

    //need to check all Person object to see if id already is being used
    private void setID() {
        this.id = "P" + idCount;
    }
    /**
     * Returns first name of person
     * @return first name of person as a String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns last name of person
     * @return last name of person as a String
     */
    public String getLastName() {
        return this.lastName;
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
     * @return age as an int
     */
    public int getAge() {
        return this.age;
    }

    /**
     * sets age of person to passed in age
     * @param age age of person as an int
     */
    public void setAge(int age) {
        if(age>0) this.age = age;
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

	public static Person getInstance() {
		if(person == null) {
			person = new Person("asdf", "asdf");
		}
		return person;
	}

	public boolean havePerson(String personName) {
		for(Person person : personList) {
			if(person.getFirstName().equals(firstName)){
				return true;
			}
		}
		return false;
	}
    public static void main(String[] args) {
<<<<<<< HEAD:src/Person.java
        Person dylan = new Suspect("Dylan", "Neff", null, null, null, null, null, null, null, null, null, false);
=======
        Person dylan = new Suspect("Dylan", "Neff");
>>>>>>> origin/branch-blakeseekings:src/People/Person.java
        System.out.println(dylan.getFirstName());
        System.out.println(dylan.getAge());
        System.out.println(dylan.getAddress());
        System.out.println(dylan.getID());
    }

	public Object getPersonName() {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD:src/Person.java

    public boolean addPerson(Object object, Object object2, Object object3, Object object4, Object object5, Object object6,
            Object object7, Object object8, Object object9, int i) {
                if(havePerson(firstName))
                return false;
            personList.add(new Person(firstName, lastName));
            return true;
    }
=======
>>>>>>> origin/branch-blakeseekings:src/People/Person.java
    
}