package src;
import java.util.ArrayList;

public class Suspect extends POI{

    protected ArrayList<Person> accomplices;
    protected ArrayList<Person> familyMembers;
    protected double footSize;
    protected String prefferedClothes, nickNames, commonWords, hobbies, job, distintPhysicalTraits, height;

    //HOW TO PHYSICALLY CREATE A NEW SUSPECT FROM UI
    public Suspect(String firstName,  String lastName) {
        super(firstName, lastName);
    }

    //HOW TO CREATE SUSPECT FROM JSON FILE
    public Suspect(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits, String height) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender);
        this.accomplices = accomplices == null ? new ArrayList<Person>() : accomplices;
        this.familyMembers = familyMembers == null ? new ArrayList<Person>() : familyMembers;
        this.footSize = footSize;
        this.prefferedClothes = prefferedClothes == null ? "" : prefferedClothes;
        this.nickNames = nickNames == null ? "" : nickNames;
        this.commonWords = commonWords == null ? "" : commonWords;
        this.hobbies = hobbies == null ? "" : hobbies;
        this.job = job == null ? "" : job;
        this.distintPhysicalTraits = distinctPhysicalTraits == null ? "" : distinctPhysicalTraits;
        this.height = height == null ? "" : height;
    }

    //USED FOR LOADING INTO JSON FILE
    public Suspect(ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
        String commonWords, String hobbies, String job, String distinctPhysicalTraits, String height) {
            this.accomplices = accomplices;
            this.familyMembers = familyMembers;
            this.footSize = footSize;
            this.prefferedClothes = prefferedClothes;
            this.nickNames = nickNames;
            this.commonWords = commonWords;
            this.hobbies = hobbies;
            this.job = job;
            this.distintPhysicalTraits = distinctPhysicalTraits;
            this.height = height;
        }

    public Suspect() {
      super(null,null,null,null,null,null,null,null,null, null,null,null,null,null,false);
      this.accomplices = new ArrayList<Person>();
      this.familyMembers = new ArrayList<Person>();
      this.footSize = 0;
      this.prefferedClothes = "";
      this.nickNames = "";
      this.commonWords = "";
      this.hobbies = "";
      this.job = "";
      this.distintPhysicalTraits = "";
      this.height = "";
    };

    public void setPOIInfo(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender) {
        super.setPersonInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age);
        this.tattoos = tattoos;
        this.gang = gang;
        this.victimRelationship = victimRelationShip;
        this.evidenceConnection = evidenceConnection;
        this.isRepeatOffender = isRepeatOffender;
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

    public String getHeight() {
        return this.height;
    }

    public String setHeight(String lhs) {
        return this.height = lhs;
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

    public ArrayList<Person> getAccomplices() {
        return this.accomplices;
    }

    public int getAccomplicesLength() {
        return this.accomplices.size();
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

    public ArrayList<Person> getFamilyMembers() {
        return this.familyMembers;
    }

    public int getFamilyMembersLength() {
        return this.familyMembers.size();
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
        if(footSize>=0) this.footSize = footSize;
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

    public String list(ArrayList<Person> al) {
        String ret = "";
        for(Person person : al) {
            ret = ret + person.getFirstName() + " " + person.getLastName() + ", ";
        }
        return ret;
    }

    @Override
    public String toString() {
      String[] details = new String[]{footSize+"",prefferedClothes,nickNames,commonWords,hobbies,job,distintPhysicalTraits};
      String[] prompts = new String[]{"Foot Size:","Clothes:","Nicknames:","Common Words/Phrases:","Hobbies:","Job:","Physical Traits:"};

      String out = super.toString();
      if (!out.equals("")) out += " | ";
      String buffer = "";
      for (int i = 0; i < details.length;++i) {
        String detail = details[i];
        String prompt = prompts[i];

        if (!detail.equals(""))  {
          out += buffer + prompt + " " + detail;
          buffer = " | ";
        }
      }

      if (accomplices.size() > 0) {
        out += "\nAccomplices:\t";

        buffer = "";
        for (Person p : accomplices) {
          out += buffer + p.toString() + "\n";
          buffer = "\t\t";
        }
      }

      if (familyMembers.size() > 0) {
        out += "\nFamily Members:\t";

        buffer = "";
        for (Person p : familyMembers) {
          out += buffer + p.toString() + "\n";
          buffer = "\t\t";
        }
      }
      return out;
    }

    public boolean partialCompare(Suspect suspect) {
        if(!super.partialCompare((POI)suspect)) return false;

        if (this.accomplices.size() != 0)
          if (!this.arrayListCompare(accomplices, suspect))
            return false;

        if(this.familyMembers.size() != 0)
          if(!this.arrayListCompare(familyMembers, suspect)) 
            return false;
        
        if(this.footSize >= 0.0)
          if(this.footSize!=suspect.footSize)
            return false;
        

        if (!this.getPrefferedClothes().equals(""))
          if(!this.getPrefferedClothes().equalsIgnoreCase(suspect.getPrefferedClothes()))
            return false;
            
            
        if(!this.getNickNames().equals(""))
          if(!this.getNickNames().equalsIgnoreCase(suspect.getNickNames()))
              return false;
        

        if(!this.getCommonWords().equals(""))
          if(!this.getCommonWords().equalsIgnoreCase(suspect.getCommonWords()))
            return false;

        if(!this.getHobbies().equals(""))
          if(!this.getHobbies().equalsIgnoreCase(suspect.getHobbies()))
            return false;

        if(!this.getJob().equals(""))
          if(!this.getJob().equalsIgnoreCase(suspect.getJob()))
              return false;

        if(!this.getDistintPhysicalTraits().equals(""))
          if(!this.getDistintPhysicalTraits().equalsIgnoreCase(suspect.getDistintPhysicalTraits()))
            return false;

        if(!this.getHeight().equals(""))
            if(!this.getHeight().equalsIgnoreCase((suspect.getHeight())))
                return false;
        
        return true;
    }

    public boolean arrayListCompare(ArrayList<Person> people, Person person) {
        for(Person p : people) {
            if(p.getFirstName().equalsIgnoreCase(person.getFirstName()) && p.getLastName().equalsIgnoreCase(person.getLastName())) return true;
        }
        return false;
    }

    /**
     * sets suspect's distinct physical traits to passed in String
     * @param distinctPhysicalTraits String containing suspect's distinct physical traits
     */
    public void setDistintPhysicalTraits(String distinctPhysicalTraits) {
        this.distintPhysicalTraits = distinctPhysicalTraits;
    }

	public Object getSuspectName() {
		// TODO Auto-generated method stub
		return null;
	}
    
}