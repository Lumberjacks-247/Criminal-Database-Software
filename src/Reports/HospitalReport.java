package src.Reports;
import src.People.*;

public class HospitalReport {

    private String id, diagnosis, cause, dateAdmitted;
    private Person doctor, nurse;
    private int numDaysAdmitted;
    private static int idCount = 000000;

    /**
     * creates HospitalReport object and gives it an id
     */
    public HospitalReport() {
        idCount++;
        this.setID();
    }

    /**
     * creates HospitalReport object with passed in parameters from a json file
     * @param id id of hospital report
     * @param diagnosis diagnosis that the doctor gave the patient after evaluating
     * @param cause cause of the hospitalization
     * @param doctor doctor that provided care to patient
     * @param nurse nurse that provided care to patient
     * @param dateAdmitted date patient was admitted to hospital
     * @param numDaysAdmitted amount of days patient was admitted to hospital
     */
    public HospitalReport(String id, String diagnosis, String cause, Person doctor, Person nurse, String dateAdmitted, int numDaysAdmitted) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.cause = cause;
        this.doctor = doctor;
        this.nurse = nurse;
        this.dateAdmitted = dateAdmitted;
        this.numDaysAdmitted = numDaysAdmitted;
    }

    public String getID() {
		return id;
	}

	public void setID() {
        this.id = "R" + idCount;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

    public Person getDoctor() {
		return doctor;
	}

	public void setDoctor(Person doctor) {
		this.doctor = doctor;
	}

	public Person getNurse() {
		return nurse;
	}

	public void setNurse(Person nurse) {
		this.nurse = nurse;
	}

    public String getDateAdmitted() {
		return dateAdmitted;
	}

	public void setDateAdmitted(String dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}

    public int getNumDaysAdmitted() {
		return numDaysAdmitted;
	}

	public void setNumDaysAdmitted(int numDaysAdmitted) {
		this.numDaysAdmitted = numDaysAdmitted;
	}
    
}
