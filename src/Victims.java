package src;
import java.util.ArrayList;

public class Victims {
	private static Victims victims;
	private ArrayList<Victim> victimList;
	
	private Victims() {
		victimList = DataLoader.loadVictims();
	}
	
	public static Victims getInstance() {
		if(victims == null) {
			victims = new Victims();
		}
		return victims;
	}
	
	//check if have victim.
	public boolean haveVictim(String victimName) {
		for(Victim victim : victimList) {
			if(victim.getVictimName().equals(victimName)) 
				return true;
		}
		return false;
	}
	
	
	public Victim getVictim(String victimName) {
		for(Victim victim: victimList) {
			if(victim.getVictimName().equals(victimName)) {
				return victim;
			}
		}
		return null;
	}
	
	public ArrayList<Victim> getVictims(){
		return victimList;
	}
	
	public boolean addVictim(String firstName,  String lastName) {
		if(haveVictim(firstName))
			return false;
		victimList.add(new Victim(firstName, lastName));
		return true;
	}
	
	public void saveVictims() {
		DataWriter.saveVictims();
	}



}
