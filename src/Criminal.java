package src;
import java.util.ArrayList;

public class Criminal extends Suspect{

    protected ArrayList<Crime> crimes;
    protected double sentence;
    protected String status;
    protected boolean inCustody;

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
    String commonWords, String hobbies, String job, String distinctPhysicalTraits, ArrayList<Crime> crimes, double sentences, String status, boolean inCustody) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender, 
        accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits);
        this.crimes = crimes == null ? new ArrayList<Crime>() : crimes;
        this.sentence = sentences;
        this.status = status == null ? "" : status;
        this.inCustody = inCustody;
    }

    //USED FOR LOADING INTO JSON
    public Criminal(ArrayList<Crime> crimes, double sentence, String status, boolean inCustody) {
        this.crimes = crimes;
        this.sentence = sentence;
        this.status = status;
        this.inCustody = inCustody;
    }

    public Criminal() {
      setSuspectInfo(null,null,null,null,null,null,null,null,null,null,null,null,null,null,false,new ArrayList<Person>(),new ArrayList<Person>(),-1.0,null,null,null,null,null,null,null);
      this.crimes = new ArrayList<Crime>();
      this.sentence = -1;
      this.status = "";
      this.inCustody = false;
    }

    public void setSuspectInfo(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, String age, String tattoos, String gang, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender,
    ArrayList<Person> accomplices, ArrayList<Person> familyMembers, double footSize, String prefferedClothes, String nickNames,
    String commonWords, String hobbies, String job, String distinctPhysicalTraits) {
        super.setPOIInfo(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age, tattoos, gang, victimRelationShip, evidenceConnection, isRepeatOffender);
        this.accomplices = accomplices == null ? new ArrayList<Person>() : accomplices;
        this.familyMembers = familyMembers == null ? new ArrayList<Person>() : familyMembers;
        this.footSize = footSize;
        this.prefferedClothes = prefferedClothes == null ? "" : prefferedClothes;
        this.nickNames = nickNames == null ? "" : nickNames;
        this.commonWords = commonWords == null ? "" : commonWords;
        this.hobbies = hobbies == null ? "" : hobbies;
        this.job = job == null ? "" : job;
        this.distintPhysicalTraits = distinctPhysicalTraits == null ? "" : distinctPhysicalTraits;
    }

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
        return ret;
    }

    @Override
    public String toString() {
      String[] details = new String[]{sentence,};
        return super.toString() + "\nCrimes: " + this.listCrimes(this.crimes) + "\nSentence: " + this.getSentence() + 
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