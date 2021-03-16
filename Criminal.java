package CriminalDatabaseSoftware;

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

    //need crime class
    public Crime getCrime() {

    }

    public void addCrime(Crime crime) {

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
    
}
