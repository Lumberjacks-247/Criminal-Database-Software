package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private Users users = Users.getInstance();
    private Crimes crimes = Crimes.getInstance();
    private Criminals criminals = Criminals.getInstance();
    private Evidences evidences = Evidences.getInstance();
    private HospitalReports hospitalReports = HospitalReports.getInstance();
    private Officers officers = Officers.getInstance();
    private People people = People.getInstance();
    private POIs pois = POIs.getInstance();
    private Suspects suspects = Suspects.getInstance();
    private Victims victims = Victims.getInstance();
    private ArrayList<Crime> crimeList = crimes.getCrimes();
    private ArrayList<Criminal> criminalList = criminals.getCriminals();
    private ArrayList<Evidence> evidenceList = evidences.getEvidences();
    private ArrayList<HospitalReport> reportList = hospitalReports.getHReports();
    private ArrayList<Officer> officerList = officers.getOfficers();
    private ArrayList<Person> personList = people.getPeople();
    private ArrayList<POI> poiList = pois.getPOIs();
    private ArrayList<Suspect> suspectList = suspects.getSuspects();
    private ArrayList<Victim> victimList = victims.getVictims();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
    public void setup() {
        crimeList.clear();
        criminalList.clear();
        evidenceList.clear();
        reportList.clear();
        officerList.clear();
        personList.clear();
        poiList.clear();
        suspectList.clear();
        victimList.clear();
        userList.clear();
        crimeList.add(new Crime("400", "Murder", 0, 0, false, null, "Spartanburg", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        crimeList.add(new Crime("202", "Assault", 1, 2, true, null, "724 E Main St", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        criminalList.add(new Criminal("Murder, Robbery", "124 years", "At ADX Florence", true));
        criminalList.add(new Criminal("Wire fraud", "6 months", "Probation", false));
        evidenceList.add(new Evidence("Wire Cutters", 303, "Fluke Wire Cutters, missing grips", "02/21/2021"));
        evidenceList.add(new Evidence("S&W 9MM", 40402, "Scraped serial number", "06/23/1992"));
        reportList.add(new HospitalReport("R0010", "GSW in abdomen", "Shot by cousin", null, null, "03/20/2020", 32));
        reportList.add(new HospitalReport("R0101", "Broken femur", "Fell down stairs", null, null, "11/01/2004", 5));
        officerList.add(new Officer("Detective", "I arrived on scene and he was beating the girl."));
        officerList.add(new Officer("Sergeant", "We fired upon the suspect after observing him retrieve a pistol from the dash."));
        personList.add(new Person("DJ", "Jim", "P001040", "M", "W", "Black", "Balding", "B", "920 E Verdia Dr", "42"));
        personList.add(new Person("Milton", "Gerold", "P020150", "F", "B", "Black", "Long", "G", "102 W Main St", "92"));
        poiList.add(new POI("dragon on left shoulder", "Crips", "cousin", "owns the gun", false));
        poiList.add(new POI("none", "none", "brother", "drove the car", false));
        suspectList.add(new Suspect(null, null, 8.0, "Hoodies", "Bibbi", "none", "Driving", "Cashier", "Bald", "6'2"));
        suspectList.add(new Suspect(null, null, 12.0, "Gucci pants", "L", "bruh", "Skydiving", "Dealer", "Eye tattoo", "5'9"));
        victimList.add(new Victim("He hit me with a baseball bat", true, null));
        victimList.add(new Victim("none", false, null));
        userList.add(new User("billybob", "Billy", "Bob", 0, "password!01@"));
        userList.add(new User("JohnnyTest", "Duke", "Soprano", 2, "mOltisanti"));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Crimes.getInstance().getCrimes().clear();
        Criminals.getInstance().getCriminals().clear();
        Evidences.getInstance().getEvidences().clear();
        HospitalReports.getInstance().getHReports().clear();
        Officers.getInstance().getOfficers().clear();
        People.getInstance().getPeople().clear();
        POIs.getInstance().getPOIs().clear();
        Suspects.getInstance().getSuspects().clear();
        Victims.getInstance().getVictims().clear();
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testGetUsersSize() {
        userList = DataLoader.loadUsers();
        assertEquals(2, userList.size());        
    }

    @Test
    void testGetUsersSizeZero() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    @Test 
    void testGetUserLastName() {
        userList = DataLoader.loadUsers();
        assertEquals("", userList.get(0).getLastName());
    }

    @Test
    void testGetCrimesSize() {
        crimeList = DataLoader.loadCrimes();
        assertEquals(2, crimeList.size());        
    }

    @Test
    void testGetCrimesSizeZero() {
        Crimes.getInstance().getCrimes().clear();
        DataWriter.saveCrimes();
        assertEquals(0, crimeList.size());
    }

    @Test 
    void testGetCrimesJurisdiction() {
        crimeList = DataLoader.loadCrimes();
        assertEquals("", crimeList.get(0).getJurisdiction());   // FINISH!
    }

    @Test 
    void testGetCriminalsSize() {
        criminalList = DataLoader.loadCriminals();
        assertEquals(2, criminalList.size());    
    }

    @Test 
    void testGetCriminalsSizeZero() {
        Criminals.getInstance().getCriminals().clear();
        DataWriter.saveCriminals();
        assertEquals(0, criminalList.size());
    }

    @Test 
    void testGetCriminalsSentence() {
        criminalList = DataLoader.loadCriminals();
        assertEquals("", criminalList.get(0).getSentence());    // FINISH!
    }

    @Test 
    void testGetEvidencesSize() {
        evidenceList = DataLoader.loadEvidence();
        assertEquals(2, evidenceList.size());
    }

    @Test
    void testGetEvidencesSizeZero() {
        Evidences.getInstance().getEvidences().clear();
        DataWriter.saveEvidences();
        assertEquals(0, evidenceList.size());
    }

    @Test
    void testGetEvidencesDescription() {
        evidenceList = DataLoader.loadEvidence();
        assertEquals("", evidenceList.get(0).getDescription()); // FINISH!
    }

    @Test 
    void testGetReportsSize() {
        reportList = DataLoader.loadHReports();
        assertEquals(2, reportList.size());
    }

    @Test
    void testGetReportsSizeZero() {
        HospitalReports.getInstance().getHReports().clear();
        DataWriter.saveHospitalReports();
        assertEquals(0, reportList.size());
    }

    @Test 
    void testGetReportsNumDaysAdmitted() {
        reportList = DataLoader.loadHReports();
        assertEquals(32, reportList.get(0).getNumDaysAdmitted());   // FINISH!
    }

    @Test
    void testGetOfficersSize() {
        officerList = DataLoader.loadOfficer();
        assertEquals(2, officerList.size());
    }

    @Test
    void testGetOfficersSizeZero() {
        Officers.getInstance().getOfficers().clear();
        DataWriter.saveOfficers();
        assertEquals(0, officerList.size());
    }

    @Test
    void testGetOfficersStatement() {
        officerList = DataLoader.loadOfficer();
        assertEquals("", officerList.get(0).getStatement());    // FINISH!
    }

    @Test
    void testGetPeopleSize() {
        personList = DataLoader.loadPeople();
        assertEquals(2, personList.size());
    }

    @Test
    void testGetPeopleSizeZero() {
        People.getInstance().getPeople().clear();
        DataWriter.savePeople();
        assertEquals(0, personList.size());
    }

    @Test
    void testGetPeopleLastName() {
        personList = DataLoader.loadPeople();
        assertEquals("", personList.get(0).getLastName());  // FINISH!
    }

    @Test
    void testGetPOISize() {
        poiList = DataLoader.loadPOI();
        assertEquals(2, poiList.size());
    }

    @Test
    void testGetPOISizeZero() {
        POIs.getInstance().getPOIs().clear();
        DataWriter.savePOIs();
        assertEquals(0, poiList.size());
    }

    @Test
    void testGetPOIRepeatOffender() {
        poiList = DataLoader.loadPOI();
        assertEquals(false, poiList.get(0).getIsRepeatOffender());  // FINISH!
    }

    @Test
    void testGetSuspectsSize() {
        suspectList = DataLoader.loadSuspects();
        assertEquals(2, suspectList.size());
    }

    @Test
    void testGetSuspectsSizeZero() {
        Suspects.getInstance().getSuspects().clear();
        DataWriter.saveSuspects();
        assertEquals(0, suspectList.size());
    }

    @Test
    void testGetSuspectsFootSize() {
        suspectList = DataLoader.loadSuspects();
        assertEquals(12.5, suspectList.get(0).getFootSize());   // FINISH!
    }

    @Test
    void testGetVictimsSize() {
        victimList = DataLoader.loadVictims();
        assertEquals(2, victimList.size());
    }

    @Test
    void testGetVictimsSizeZero() {
        Victims.getInstance().getVictims().clear();
        DataWriter.saveVictims();
        assertEquals(0, victimList.size());
    }

    @Test
    void testGetVictimsIsAlive() {
        victimList = DataLoader.loadVictims();
        assertEquals(true, victimList.get(0).getIsAlive());
    }
}
