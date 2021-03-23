package src;
public class Witness extends Person{

    private String phoneNumber, email, statement, relationToBadGuy;

    /**
     * creates Witness object with passed in first and last name
     * @param firstName first name of witness
     * @param lastName last name of witness
     */
    public Witness(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Witness(String firstName, String lastName, String phoneNumber, String email, String statement, String relationToBadGuy) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.statement = statement;
        this.relationToBadGuy = relationToBadGuy;
    }

    /**
     * returns witness's phone number
     * @return witness's phone number as a String
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * sets witness's phone number to passed in String
     * @param phoneNumber witness's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * returns the witness's email
     * @return witness's email as a String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * sets witness's email to passed in String
     * @param email witness's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns witness's statement of the crime
     * @return statement of crime as a String
     */
    public String getStatement() {
        return this.statement;
    }

    /**
     * sets witness's statement of crime to passed in String
     * @param statement witness's report of crime
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * returns the witness's relation to poi/suspect/criminal of crime
     * @return String containing witness's relation to a bad guy related to crime
     */
    public String getRelationToBadGuy() {
        return this.relationToBadGuy;
    }

    /**
     * sets witness's relation to poi/suspect/criminal of crime
     * @param relation String containing witness's relation to a bad guy related to crime
     */
    public void setRelationToBadGuy(String relation) {
        this.relationToBadGuy = relation;
    }

	public Object getWitnessName() {
		// TODO Auto-generated method stub
		return null;
	}

    
}