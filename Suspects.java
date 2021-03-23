import java.util.ArrayList;

public class Suspects {
	private static Suspects suspects;
	private ArrayList<Suspect> suspectList;
	
	private Suspects() {
		suspectList = DataLoader.loadSuspects();
	}
	
	public static Suspects getInstance() {
		if(suspects == null) {
			suspects = new Suspects();
		}
		return suspects;
	}
	
	//check if have criminal.
	public boolean haveSuspect(String suspectName) {
		for(Suspect suspect : suspectList) {
			if(suspect.getSuspectName().equals(suspectName)) 
				return true;
		}
		return false;
	}
	
	
	public Suspect getSuspect(String suspectName) {
		for(Suspect suspect: suspectList) {
			if(suspect.getSuspectName().equals(suspectName)) {
				return suspect;
			}
		}
		return null;
	}
	
	public ArrayList<Suspect> getSuspects(){
		return suspectList;
	}
	
	public boolean addSuspect(String firstName,  String lastName, String accomplices, String familyMembers, Long footSize,
			String prefClothes, String nicknames, String commonWords, String hobbies, String job, String physicalTraits) {
		if(haveSuspect(firstName))
			return false;
		suspectList.add(new Suspect(firstName, lastName, accomplices, familyMembers, footSize, prefClothes, nicknames, commonWords, hobbies, job, physicalTraits, false));
		return true;
	}
	
	public void saveSuspects() {
		DataWriter.saveSuspects();
	}



}
