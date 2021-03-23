package src;
import java.util.ArrayList;

public class Evidences {
	private static Evidences evidences;
	private ArrayList<Evidence>evidenceList;
	
	private Evidences() {
		evidenceList = DataLoader.loadEvidence();
	}
	
	public static Evidences getInstance() {
		if(evidences == null) {
			evidences = new Evidences();
		}
		return evidences;
	}
	
	//check if have evidence.
	public boolean haveEvidence(String evidenceName) {
		for(Evidence evidence : evidenceList) {
			if(evidence.getEvidenceName().equals(evidenceName)) 
				return true;
		}
		return false;
	}
	
	
	public Evidence getEvidence(String evidenceName) {
		for(Evidence evidence: evidenceList) {
			if(evidence.getEvidenceName().equals(evidenceName)) {
				return evidence;
			}
		}
		return null;
	}
	
	public ArrayList<Evidence> getEvidences(){
		return evidenceList;
	}
	
	public boolean addEvidences(String evidenceName,int id, String description, String dateCollected) {
		if(haveEvidence(evidenceName))
			return false;
		evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
		return true;
	}
	
	public void saveEvidences() {
		DataWriter.saveEvidences();
	}



}
