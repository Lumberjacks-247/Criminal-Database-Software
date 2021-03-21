
public class POI extends Person{

    private String tattoos, gang, victimRelationship, evidenceConnection;
    private boolean isRepeatOffender;

    /**
     * Creates POI object with passed in first and last names
     * @param firstName first name of POI
     * @param lastName last name of POI
     */
    public POI(String firstName, String lastName) {
        super(firstName, lastName);
        this.isRepeatOffender = false;
    }

    public POI(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, 
    String eyeColor, String address, int age, String tattoos, String victimRelationShip, String evidenceConnection, boolean isRepeatOffender) {
        super(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age);
        this.tattoos = tattoos;
        this.gang = gang;
        this.victimRelationship = victimRelationShip;
        this.evidenceConnection = evidenceConnection;
        this.isRepeatOffender = isRepeatOffender;
    }

    /**
     * returns tattoos of the poi
     * @return tattoos of the poi as a String
     */
    public String getTattoos() {
        return this.tattoos;
    }

    /**
     * sets tattoos of the poi to passed in String
     * @param tattoos tattoos of the poi as a String
     */
    public void setTattoos(String tattoos) {
        this.tattoos = tattoos;
    }

    /**
     * returns the gang of the poi
     * @return gang of the poi as a String
     */
    public String getGang() {
        return this.gang;
    }

    /**
     * sets gang of poi to passed in gang
     * @param gang gang of poi as a String
     */
    public void setGang(String gang) {
        this.gang = gang;
    }

    /**
     * returns if poi is a repeat offender or not
     * @return boolean value for if poi is repeat offender
     */
    public boolean getIsRepeatOffender() {
        return this.isRepeatOffender;
    }

    /**
     * changes boolean value of isRepeatOffender from false to true
     */
    public void changeRepeatOffender() {
        this.isRepeatOffender = true;
    }

    /**
     * returns poi's relationship with victim
     * @return String value containing poi's relationship with victim
     */
    public String getVictimRelationship() {
        return this.victimRelationship;
    }

    /**
     * sets poi's victimRelationship to passed in String
     * @param relationship String that contains poi's relationship to victim
     */
    public void setVictimRelationship(String relationship) {
        this.victimRelationship = relationship;
    }

    /**
     * returns poi's connection to evidence
     * @return String value containing poi's connection to evidence
     */
    public String getEvidenceConnection() {
        return this.evidenceConnection;
    }

    /**
     * sets poi's evidenceConnection to passed in String
     * @param evidenceConnection String that contains poi's connection to evidence
     */
    public void setEvidenceConnection(String evidenceConnection) {
        this.evidenceConnection = evidenceConnection;
    }

	public Object getPOIName() {
		// TODO Auto-generated method stub
		return null;
	}
    
}