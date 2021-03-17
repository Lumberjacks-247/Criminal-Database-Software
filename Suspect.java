package CriminalDatabaseSoftware;

import java.util.ArrayList;

public class Suspect extends POI{

    private ArrayList<Person> accomplices;
    private ArrayList<Person> familyMembers;
    private double footSize;
    private String prefferedClothes, nickNames, commonWords, hobbies, job, distintPhysicalTraits;

    public Suspect(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * Checks if person is in ArrayList and if so, returns the person
     * @param firstName first name of person to return
     * @param lastName last name of person to return
     * @return person object if in accomplices ArrayList, null otherwise
     */
    public Person getAccomplice(String firstName, String lastName) {
        for(Person person : accomplices) {
            if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) return person;
        }
        return null;
    }

    /**
     * Adds a new accomplice to the accomplices ArrayList
     * @param accomplice person being added to accomplices ArrayList
     */
    public void addAccomplice(Person accomplice) {
        if(accomplices.contains(accomplice)) return;
        this.accomplices.add(accomplice);
    }

    /**
     * checks accomplices ArrayList for person and if they exist, remove them
     * @param firstName first name of person to remove
     * @param lastName last name of person to remove
     */
    public void removeAccomplice(String firstName, String lastName) {
        for(Person person : accomplices) {
            if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) accomplices.remove(person);
        }
    }

    /**
     * Checks if person is in ArrayList and if so, returns the person
     * @param firstName first name of person to return
     * @param lastName last name of person to return
     * @return person object if in familyMembers ArrayList, null otherwise
     */
    public Person getFamilyMember(String firstName, String lastName) {
        for(Person person : familyMembers) {
            if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) return person;
        }
        return null;
    }

    /**
     * Adds a new familyMember to the familyMembers ArrayList
     * @param familyMember person being added to familyMembers ArrayList
     */
    public void addFamilyMember(Person familyMember) {
        if(familyMembers.contains(familyMember)) return;
        this.familyMembers.add(familyMember);
    }

    /**
     * checks familyMembers ArrayList for person and if they exist, remove them
     * @param firstName first name of person to remove
     * @param lastName last name of person to remove
     */
    public void removefamilyMember(String firstName, String lastName) {
        for(Person person : familyMembers) {
            if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) familyMembers.remove(person);
        }
    }

    /**
     * returns foot size of suspect
     * @return foot size of suspect as a double
     */
    public double getFootSize() {
        return this.footSize;
    }

    /**
     * sets suspects footsize to knew size if it is valid
     * @param footSize new foot size of suspect
     */
    public void setFootSize(double footSize) { 
        if(footSize>0) this.footSize = footSize;
    }

    /**
     * returns suspect's preferred clothes
     * @return String containing suspect's preffered clothes
     */
    public String getPrefferedClothes() {
        return this.prefferedClothes;
    }

    /**
     * sets suspect's preferred clothes to passed in String
     * @param clothes String containing suspect's preffered clothes
     */
    public void setPrefferedClothes(String clothes) {
        this.prefferedClothes = clothes;
    }

    /**
     * returns suspect's nick names
     * @return String containing suspect's nick names
     */
    public String getNickNames() {
        return this.nickNames;
    }

    /**
     * sets suspect's nick names to passed in String
     * @param nickNames String containing suspect's nick names
     */
    public void setNickNames(String nickNames) {
        this.nickNames = nickNames;
    }

    /**
     * returns suspect's common words
     * @return String containing suspect's common words
     */
    public String getCommonWords() {
        return this.commonWords;
    }

    /**
     * sets suspect's common words to passed in String
     * @param commonWords String containing suspect's common words
     */
    public void setCommonWords(String commonWords) {
        this.commonWords = commonWords;
    }

    /**
     * returns suspect's hobbies
     * @return String containing suspect's hobbies
     */
    public String getHobbies() {
        return this.hobbies;
    }

    /**
     * sets suspect's hobies to passed in String
     * @param hobbies String containing suspect's hobies
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * returns suspect's job
     * @return String containing suspect's job
     */
    public String getJob() {
        return this.job;
    }

    /**
     * sets suspect's job to passed in String
     * @param job String containing suspect's job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * returns suspect's distinct physical traits
     * @return String containing suspect's distinct physical traits
     */
    public String getDistintPhysicalTraits() {
        return this.distintPhysicalTraits;
    }

    /**
     * sets suspect's distinct physical traits to passed in String
     * @param distinctPhysicalTraits String containing suspect's distinct physical traits
     */
    public void setDistintPhysicalTraits(String distinctPhysicalTraits) {
        this.distintPhysicalTraits = distinctPhysicalTraits;
    }
    
}
