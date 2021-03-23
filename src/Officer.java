package src;
public class Officer extends Person{

    private String typeOfOfficer; //use enumeration
    private String statement;

    /**
     * creates Officer object with passed in first and last name
     * @param firstName officers first name
     * @param lastName officers last name
     */
    public Officer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Officer(String firstName, String lastName, String typeOfOfficer, String statement) {
        super(firstName, lastName);
        this.typeOfOfficer = typeOfOfficer;
        this.statement = statement;
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
    
}