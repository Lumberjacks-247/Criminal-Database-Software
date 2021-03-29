package src;
public class Officer extends Person{

    private String typeOfOfficer; //use enumeration
    private String statement;

    /**
     * CREATES OFFICER FROM UI
     * NEED TYPEOFOFFICER TO AVOID ERROR WITH OTHER CONSTUCTOR
     * creates Officer object with passed in first and last name
     * @param firstName officers first name
     * @param lastName officers last name
     */
    public Officer(String firstName, String lastName, String typeOfOfficer) {
        super(firstName, lastName);
        this.typeOfOfficer = typeOfOfficer == null ? "" : typeOfOfficer;
    }

    //USED FOR CREATING OFFICER FROM JSON
    public Officer(String firstName, String lastName, String typeOfOfficer, String statement) {
        super(firstName, lastName);
        this.typeOfOfficer = typeOfOfficer == null ? "" : typeOfOfficer;
        this.statement = statement == null ? "" : statement;
    }

    //uSED FOR LOADING INTO JSON
    public Officer(String typeOfOfficer, String statement) {
        this.typeOfOfficer = typeOfOfficer;
        this.statement = statement;
    }

    public void setPersonInfo(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * returns what kind of officer the officer is
     * @return String for type of officer
     */
    public String getTypeOfOfficer() {
        return this.typeOfOfficer;
    }

    /**
     * sets officers type to passed in String
     * @param typeOfOfficer officers type
     */
    public void setTypeOfOfficer(String typeOfOfficer) {
        this.typeOfOfficer = typeOfOfficer;
    }

    /**
     * returns officers statement of crime
     * @return String for officers statement of crime
     */
    public String getStatement() {
        return this.statement;
    }

    /**
     * sets officers statement of crime to passed in String
     * @param statement officer statement of crime
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

	public Object getOfficerName() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public String toString() {
        return super.toString() + "\nType of Officer: " + this.getTypeOfOfficer() + "\nStatement: " + this.getStatement();
    }

    public boolean partialCompare(Officer officer) {
        if(!super.partialCompare(officer)) return false;
        if(!this.getTypeOfOfficer().equalsIgnoreCase(officer.getTypeOfOfficer())){ 
            if(this.getTypeOfOfficer().equals(BLANK)) continue;
            return false;
        }
        if(!this.getStatement().equalsIgnoreCase(officer.getStatement())){ 
            if(this.getStatement().equals(BLANK)) continue;
            return false;
        }
        return true;
    }
    
}