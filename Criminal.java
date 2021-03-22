import java.util.ArrayList;

public class Criminal extends Suspect{

    private ArrayList<Crime> crimes;
    private double sentence;
    private String status;
    private boolean inCustody;

    /**
     * Creates a Crimianl object with passed in first and last name
     * @param firstName first name of criminal
     * @param lastName last name of criminal
     */
    public Criminal(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Criminal(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, int age, String tattoos, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits, ArrayList<Crime> crimes, double sentences, String status, boolean inCustody) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, victimRelationShip, evidenceConnection, isRepeatOffender, 
        accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits);
        this.crimes = crimes;
        this. sentence = sentences;
        this.status = status;
        this.inCustody = inCustody;
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
    
}