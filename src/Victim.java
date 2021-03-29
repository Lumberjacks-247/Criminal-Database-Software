package src;
import java.util.ArrayList;

import src.HospitalReport;

public class Victim extends Person{

    private String statement;
    private boolean isAlive;
    private ArrayList<HospitalReport> hospitalReports;

    /**
     * creates a Victim object with passed in first and last names
     * @param firstName first name of victim
     * @param lastName last name of victim
     */
    public Victim(String firstName, String lastName, String statement, boolean isAlive, ArrayList<HospitalReport> hospitalReports) {
        super(firstName, lastName);
        this.statement = statement;
        this.isAlive = isAlive;
        this.hospitalReports = hospitalReports;
        this.setID();
    }

    public Victim(String statement, boolean isAlive, ArrayList<HospitalReport> hospitalReports) {
        this.statement = statement;
        this.isAlive = isAlive;
        this.hospitalReports = hospitalReports;
    }

    public void setPersonInfo(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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

    public ArrayList<HospitalReport> getHospitalReports() {
        return this.hospitalReports;
    }

    public void addHospitalReport(HospitalReport hospitalReport) {
        this.hospitalReports.add(hospitalReport);
    }

    public String listHR(ArrayList<HospitalReport> hr) {
        String ret = "";
        for(HospitalReport report : hr) {
            ret = ret + report.getID() + ", ";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nStatement" + this.getStatement() + "\nIs Alive: " + this.getIsAlive() + 
            "\nHospital Reports: " + this.listHR(hospitalReports);
    }

	public Object getVictimName() {
		// TODO Auto-generated method stub
		return null;
	}
    
}