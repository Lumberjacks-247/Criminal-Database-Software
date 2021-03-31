package src;
import java.util.ArrayList;

public class Criminal extends Suspect{

    //protected ArrayList<Crime> crimes;
    protected double sentence;
    protected String status, crimes;
    protected boolean inCustody;
    protected int height;

    /**
     * FOR CREATING CRIMINAL THROUGH UI
     * Creates a Crimianl object with passed in first and last name
     * @param firstName first name of criminal
     * @param lastName last name of criminal
     */
    public Criminal(String firstName, String lastName) {
        super(firstName, lastName);
    }

    //FOR CREATING CRIMINAL FROM JSON
    public Criminal(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits, String crimes, double sentences, String status, boolean inCustody, int height) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender, 
        accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits);
        this.crimes = crimes;
        this. sentence = sentences;
        this.status = status == null ? "" : status;
        this.inCustody = inCustody;
        this.height = height;
    }

    //USED FOR LOADING INTO JSON
    public Criminal(String crimes, double sentence, String status, boolean inCustody, int height) {
        this.crimes = crimes;
        this.sentence = sentence;
        this.status = status;
        this.inCustody = inCustody;
        this.height = height;
    }

    public void setSuspectInfo(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits) {
        super.setPOIInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender);
        this.accomplices = accomplices;
        this.familyMembers = familyMembers;
        this.footSize = footSize;
        this.prefferedClothes = prefferedClothes;
        this.nickNames = nickNames;
        this.commonWords = commonWords;
        this.hobbies = hobbies;
        this.job = job;
        this.distintPhysicalTraits = distinctPhysicalTraits;
    }

    public String getCrimes() {
        return crimes;
    }

    public void addCrime(String crime) {
        crimes += ", " + crime;
    }

    public int getHeight() {
        return height;
    }

    /*
    public int getCrimesLength() {
        return this.crimes.size();
    }
    */

    //should this be in crime class?
    public double getSentence() {
        return this.sentence;
    }

    public void setSentence(double sentence) {
        if(sentence>0) this.sentence = sentence;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getInCustody() {
        return this.inCustody;
    }

    public void changeInCustody() {
        this.inCustody = !this.inCustody;
    }

	public Object getCriminalName() {
		// TODO Auto-generated method stub
		return null;
	}

    public String listCrimes() {
        return crimes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCrimes: " + this.crimes + "\nSentence: " + this.getSentence() + 
            "\nStatus: " + this.getStatus() + "\nIn Custody: " + this.getInCustody();
    }

    public boolean partialCompare(Criminal criminal) {
        boolean ret = true;
        if(!super.partialCompare(criminal)) return false;
        /*if(!this.crimesCompare(crimes, criminal)){ 
            if(this.crimes==null) continue;
            return false;
        }*/
        if(this.getSentence()!=criminal.getSentence()){ 
            if(this.getSentence()!=0.0) return false;
        }
        if(!this.getStatus().equalsIgnoreCase(criminal.getStatus())){ 
            if(!this.getStatus().equals(BLANK)) return false;
        }
        if(!this.getInCustody()==criminal.getInCustody()) return false;
        return true;
    }

    /*public boolean crimesCompare(ArrayList<Crime> crimes, Criminal criminal) {
        for(Crime c : crimes){
            if(c.getID().equals(criminal.getID())) return true;
        }
        return false;
    }*/
    
}