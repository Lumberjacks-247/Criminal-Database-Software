package src;
import java.util.ArrayList;

public class Witnesses {
	private static Witnesses witnesses;
	private ArrayList<Witness> witnessList;
	
	private Witnesses() {
		witnessList = DataLoader.loadWitness();
	}
	
	public static Witnesses getInstance() {
		if(witnesses == null) {
			witnesses = new Witnesses();
		}
		return witnesses;
	}
	
	//check if have witness.
	public boolean haveWitness(String witnessName) {
		for(Witness witness : witnessList) {
			if(witness.getWitnessName().equals(witnessName)) 
				return true;
		}
		return false;
	}
	
	
	public Witness getWitness(String witnessName) {
		for(Witness witness: witnessList) {
			if(witness.getWitnessName().equals(witnessName)) {
				return witness;
			}
		}
		return null;
	}
	
	public ArrayList<Witness> getWitnesses(){
		return witnessList;
	}
	
	public boolean addWitness(String firstName,  String lastName, String phone, String email, String statement, String relationBad) {
		if(haveWitness(firstName))
			return false;
		witnessList.add(new Witness(firstName, lastName, phone, email, statement, relationBad));
		return true;
	}
	
	public void saveWitnesses() {
		DataWriter.saveWitnesses();
	}



}
