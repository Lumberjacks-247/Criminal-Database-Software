package src.Reports;
import src.Data.*;
import java.util.ArrayList;

public class Crimes {
	private static Crimes crimes;
	private ArrayList<Crime> crimeList;
	
	private Crimes() {
		crimeList = DataLoader.loadCrimes();
	}
	
	public static Crimes getInstance() {
		if(crimes == null) {
			crimes = new Crimes();
		}
		return crimes;
	}
	
	//check if have crime.
	public boolean haveCrime(String crimeName) {
		for(Crime crime : crimeList) {
			if(crime.getCrimeName().equals(crimeName)) 
				return true;
		}
		return false;
	}
	
	
	public Crime getCrime(String crimeName) {
		for(Crime crime: crimeList) {
			if(crime.getCrimeName().equals(crimeName)) {
				return crime;
			}
		}
		return null;
	}
	
	public ArrayList<Crime> getCrimes(){
		return crimeList;
	}
	
	public boolean addCrimes(String crimeName) {
		if(haveCrime(crimeName))
			return false;
		crimeList.add(new Crime()); //add parameters into crime
		return true;
	}
	
	public void saveCrimes() {
		DataWriter.saveCrimes();
	}



}
