package src;
import java.util.ArrayList;

public class Criminals {
	private static Criminals criminals;
	private ArrayList<Criminal> criminalList;
	
	private Criminals() {
		criminalList = DataLoader.loadCriminals();
	}
	
	public static Criminals getInstance() {
		if(criminals == null) {
			criminals = new Criminals();
		}
		return criminals;
	}
	
	//check if have criminal.
	public boolean haveCriminal(String criminalName) {
		for(Criminal criminal : criminalList) {
			if(criminal.getCriminalName().equals(criminalName)) 
				return true;
		}
		return false;
	}
	
	
	public Criminal getCriminal(String criminalName) {
		for(Criminal criminal: criminalList) {
			if(criminal.getCriminalName().equals(criminalName)) {
				return criminal;
			}
		}
		return null;
	}
	
	public ArrayList<Criminal> getCriminals(){
		return criminalList;
	}
	
	public boolean addCriminal(String firstName,  String lastName) {
		if(haveCriminal(firstName))
			return false;
		criminalList.add(new Criminal(firstName, lastName));
		return true;
	}
	
	public void saveCriminals() {
		DataWriter.saveCriminals();
	}



}
