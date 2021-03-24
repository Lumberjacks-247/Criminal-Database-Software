package src;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Crime {

    private int levelOfCharge, jurisdiction;
    private static int idCount = 0;
    private String id, typeOfCrime, location;
    private boolean isOpen = true;
    private User author;
    private static Crime crime;
    private ArrayList<POI> pois;
    private ArrayList<Crime> crimeList;
    private ArrayList<Suspect> suspects;
    private ArrayList<Criminal> criminals;
    private ArrayList<Victim> victims;
    private ArrayList<Witness> witnesses;
    private ArrayList<Officer> officers;
    private ArrayList<Evidence> evidence;
    DecimalFormat df = new DecimalFormat("000000");
    

    /**
     * creates a new crime object with just an id
     */
    public Crime() {
        idCount++;
        this.setID();
    }

    /**
     * creates a crime object by reading in parameters from a json file
     * @param id id of this crime
     * @param typeOfCrime what kind of crime was commited
     * @param levelOfCharge degree of crime commited
     * @param jurisdiction On what level was this crime commited (local, state, or federal)
     * @param isOpen boolean value for if this crime is an open or closed case
     * @param author who is currently accesing this crime
     * @param location where was this crime commited
     * @param pois list of known persons of interest related to this crime
     * @param suspects list of known suspects for this crime
     * @param criminals list of convicted criminals for this crime
     * @param victims list of known victims for this crime
     * @param witnesses list of known witnesses for this crime
     * @param officers list of known officers for this crime
     * @param evidence list of discovered evidence for this crime
     */
    public Crime(String id, String typeOfCrime, int levelOfCharge, int jurisdiction, boolean isOpen, User author, String location, 
        ArrayList<POI> pois, ArrayList<Suspect> suspects, ArrayList<Criminal> criminals, ArrayList<Victim> victims, 
        ArrayList<Witness> witnesses, ArrayList<Officer> officers, ArrayList<Evidence> evidence) {
            this.id = id;
            this.typeOfCrime = typeOfCrime;
            this.levelOfCharge = levelOfCharge;
            this.jurisdiction = jurisdiction;
            this.isOpen = isOpen;
            this.author = author;
            this.location = location;
            if(pois!=null) this.pois = pois;
            else pois = new ArrayList<>();
            if(suspects!=null) this.suspects = suspects;
            else suspects = new ArrayList<>();
            if(criminals!=null) this.criminals = criminals;
            else criminals = new ArrayList<>();
            if(victims!=null) this.victims = victims;
            else victims = new ArrayList<>();
            if(witnesses!=null) this.witnesses = witnesses;
            else witnesses = new ArrayList<>();
            if(officers!=null) this.officers = officers;
            else officers = new ArrayList<>();
            if(evidence!=null) this.evidence = evidence;
            else evidence = new ArrayList<>();
    }

    /**
     * returns the id of this crime
     * @return id as a String
     */
    public String getID() {
        return this.id;
    }

    /**
     * gives the crime an id
     */
    private void setID() {
        this.id = "C" + df.format(idCount);
    }

    /**
     * returns what type of crime was commited
     * @return type of crime as a String
     */
    public String getTypeOfCrime() {
        return this.typeOfCrime;
    }

    /**
     * sets the type of crimie commited to psased in String
     * @param typeOfCrime type of crime commited as a String
     */
    public void setTypeOfCrime(String typeOfCrime) {
        this.typeOfCrime = typeOfCrime;
    }

    /**
     * returns level of charge
     * @return level of charge as an int
     */
    public int getLevelOfCharge() {
        return this.levelOfCharge;
    }

    /**
     * sets level of charge to passed in int
     * @param levelOfCharge level of charge as an int
     */
    public void setLevelOfCharge(int levelOfCharge) {
        this.levelOfCharge = levelOfCharge;
    }

    /**
     * return jurdiction of crime
     * @return jurisdiction as an int
     */
    public int getJurisdiction() {
        return this.jurisdiction;
    }

    /**
     * sets jurisdiction of crime to passed in int
     * @param jurisdiction jurisdiction of charge as an int
     */
    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    /**
     * returns boolean value for if case is still open
     * @return true if open, false if closed
     */
    public boolean getIsOpen() {
		return isOpen;
	}

    /**
     * sets boolean value for if case is opened to passed in boolean
     * @param isOpen true if open, false if closed
     */
	public void setIsOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

    /**
     * returns User object who is currently logged in
     * @return User object
     */
	public User getAuthor() {
		return author;
	}

    /**
     * sets author to passed in User object
     * @param author User object currently logged in
     */
	public void setAuthor(User author) {
		this.author = author;
	}

    /**
     * returns location of where crime was commited
     * @return location of crime as a String
     */
    public String getLocation() {
		return location;
	}

    /**
     * sets location of crime committed to passed in String
     * @param location location of crime committed
     */
	public void setLocation(String location) {
		this.location = location;
	}

    public ArrayList<POI> getPois() {
		return pois;
	}

	public void setPois(ArrayList<POI> pois) {
		this.pois = pois;
	}

    public int getPoisLength() {
        return this.pois.size();
    }

	public ArrayList<Suspect> getSuspects() {
		return suspects;
	}

	public void setSuspects(ArrayList<Suspect> suspects) {
		this.suspects = suspects;
	}

    public int getSuspetcsLength() {
        return this.suspects.size();
    }

	public ArrayList<Criminal> getCriminals() {
		return criminals;
	}

	public void setCriminals(ArrayList<Criminal> criminals) {
		this.criminals = criminals;
	}

    public int getCriminalsLength() {
        return this.criminals.size();
    }

	public ArrayList<Victim> getVictims() {
		return victims;
	}

	public void setVictims(ArrayList<Victim> victims) {
		this.victims = victims;
	}

    public int getVictimsLength() {
        return this.victims.size();
    }

	public ArrayList<Witness> getWitnesses() {
		return witnesses;
	}

	public void setWitnesses(ArrayList<Witness> witnesses) {
		this.witnesses = witnesses;
	}

    public int getWitnessesLenght() {
        return this.witnesses.size();
    }

	public ArrayList<Officer> getOfficers() {
		return officers;
	}

	public void setOfficers(ArrayList<Officer> officers) {
		this.officers = officers;
	}

    public int getOfficersLength() {
        return this.officers.size();
    }

	public ArrayList<Evidence> getEvidence() {
		return evidence;
	}

	public void setEvidence(ArrayList<Evidence> evidence) {
		this.evidence = evidence;
	}

    public int getEvidenceLength() {
        return this.evidence.size();
    }

	public static Crime getInstance() {
		if(crime == null) {
			crime = new Crime();
		}
		return crime;
	}

	public boolean haveCrime(String crimeName) {
		for(Crime crime : crimeList) {
			if(crime.getCrime().equals(crime)) {
				return true;
			}
		}
		return false;
	}

	private Crime getCrime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCrimeName() {
		// TODO Auto-generated method stub
		return null;
	}
    
}