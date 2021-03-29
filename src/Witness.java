package src;
public class Witness extends Person{

    private String phoneNumber, email, statement, relationToBadGuy;

    /**
     * USED FOR CREATING WITNESS THROUGH UI
     * creates Witness object with passed in first and last name
     * @param firstName first name of witness
     * @param lastName last name of witness
     */
    public Witness(String firstName, String lastName) {
        super(firstName, lastName);
    }

    //USED FOR CREATING wITNESS FROM JSON
    public Witness(String firstName, String lastName, String id, String gender, String race, String hairColor, String hairStyle, String eyeColor, String address, String age, String phoneNumber, String email, String statement, String relationToBadGuy) {
        super(firstName, lastName, id,  gender,  race,  hairColor,  hairStyle,  eyeColor,  address,  age);
        this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
        this.email = email == null ? "" : email;
        this.statement = statement == null ? "" : statement;
        this.relationToBadGuy = relationToBadGuy == null ? "" : relationToBadGuy;
    }

    //USED FOR LOADING INTO JSON
    public Witness(String phoneNumber, String email, String statement, String relationToBadGuy) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.statement = statement;
        this.relationToBadGuy = relationToBadGuy;
    }

    public void setPersonInfo(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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

    @Override
    public String toString() {
        return super.toString() + "\nPhone Number: " + this.getPhoneNumber() + "\nEmail: " + this.getEmail() + 
            "\nStatement: " + this.getStatement() + "Relation to Bad Guy: " + this.getRelationToBadGuy();
    }

    public boolean partialCompare(Witness witness) {
        if(!super.partialCompare(witness)) return false;
        if(!this.getPhoneNumber().equalsIgnoreCase(witness.getPhoneNumber())){ 
            if(this.getPhoneNumber().equals(BLANK)) continue;
            return false;
        }
        if(!this.getEmail().equalsIgnoreCase(witness.getEmail())){ 
            if(this.getEmail().equals(BLANK)) continue;
            return false;
        }
        if(!this.getStatement().equalsIgnoreCase(witness.getStatement())){ 
            if(this.getStatement().equals(BLANK)) continue;
            return false;
        }
        if(!this.getRelationToBadGuy().equalsIgnoreCase(witness.getRelationToBadGuy())){ 
            if(this.getRelationToBadGuy().equals(BLANK)) continue;
            return false;
        }
        return true;
    }

	public Object getWitnessName() {
		// TODO Auto-generated method stub
		return null;
	}

    
}