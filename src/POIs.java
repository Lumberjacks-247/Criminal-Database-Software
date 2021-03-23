import java.util.ArrayList;

public class POIs {
	private static POIs pOIS;
	private ArrayList<POI> pOISList;
	
	private POIs() {
		pOISList = DataLoader.loadPOI();
	}
	
	public static POIs getInstance() {
		if(pOIS == null) {
			pOIS = new POIs();
		}
		return pOIS;
	}
	
	//check if have criminal.
	public boolean havePOI(String POIName) {
		for(POI pOI : pOISList) {
			if(pOI.getPOIName().equals(POIName)) 
				return true;
		}
		return false;
	}
	
	
	public POI getPOI(String POIName) {
		for(POI pOI: pOISList) {
			if(pOI.getPOIName().equals(POIName)) {
				return pOI;
			}
		}
		return null;
	}
	
	public ArrayList<POI> getPOIs(){
		return pOISList;
	}
	
	public boolean addPOI(String firstName,  String lastName, String tattoos, String gang, String victimRelation, String evidenceConn, Boolean isRepeatOffender) {
		if(havePOI(firstName))
			return false;
		pOISList.add(new POI(firstName, lastName, tattoos, gang, victimRelation, evidenceConn, isRepeatOffender));
		return true;
	}
	
	public void savePOIs() {
		DataWriter.savePOIs();
	}



}
