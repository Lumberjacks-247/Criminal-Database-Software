package CriminalDatabaseSoftware;

import java.util.ArrayList;

public class Victim extends Person{

    private String statement;
    private boolean isAlive = true;
    private ArrayList<HospitalReport> hospitalReports;

    /**
     * creates a Victim object with passed in first and last names
     * @param firstName first name of victim
     * @param lastName last name of victim
     */
    public Victim(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * returns victims report of the crime
     * @return victims statement as a String
     */
    public String getStatement() {
        return this.statement;
    }

    /**
     * sets the victims report of the crime to the passed in String
     * @param statement the victims report of the crime
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * returns if the victim is alive or not
     * @return boolean value for if the victim is alive
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * changes the boolean value for if the victim is alive between true and false
     */
    public void changeIsAlive() {
        this.isAlive = !isAlive;
    }

    //need HospitalReport class
    public HospitalReport getHospitalReport() {

    }

    public void addHospitalReport() {
        
    }
    
}
