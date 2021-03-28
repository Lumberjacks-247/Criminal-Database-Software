package src;
import java.util.ArrayList;

public class Criminal extends Suspect{

    protected ArrayList<Crime> crimes;
    protected double sentence;
    protected String status;
    protected boolean inCustody;

    /**
     * Creates a Crimianl object with passed in first and last name
     * @param firstName first name of criminal
     * @param lastName last name of criminal
     */
    public Criminal(String firstName, String lastName, boolean inCustody) {
        super(firstName, lastName, lastName, lastName, null, lastName, lastName, lastName, lastName, lastName, lastName, inCustody);
    }

    public Criminal(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits, ArrayList<Crime> crimes, double sentences, String status, boolean inCustody) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender, 
        accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits);
        this.crimes = crimes;
        this. sentence = sentences;
        this.status = status;
        this.inCustody = inCustody;
    }

    public Criminal(ArrayList<Crime> crimes, double sentence, String status, boolean inCustody) {
        this.crimes = crimes;
        this.sentence = sentence;
        this.status = status;
        this.inCustody = inCustody;
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

    //need crime class
    public ArrayList<Crime> getCrimes() {
        return crimes;
    }

    public void addCrime(Crime crime) {
        crimes.add(crime);
    }

    public int getCrimesLength() {
        return this.crimes.size();
    }

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

    public String listCrimes(ArrayList<Crime> crimes) {
        String ret = "";
        for(Crime crime : crimes) {
            ret = ret + crime.getID() + ", ";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCrimes: " + this.listCrimes(this.crimes) + "\nSentence: " + this.getSentence() + 
            "\nStatus: " + this.getStatus() + "\nIn Custody: " + this.getInCustody();
    }
    
}