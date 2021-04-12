package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
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
    void testWriteZeroUsers() {
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testWriteOneUser() {
        userList.add(new User("gs1", "Greg", "Stich", 1, "lol123"));
        DataWriter.saveUsers();
        assertEquals("lol123", DataLoader.loadUsers().get(0).getPassword());
    }

    @Test 
    void testWriteFiveUser() {
        userList.add(new User("010", "Binary", "Numbers", 0, "progRock"));
        userList.add(new User("webrakefornobody", "Space", "Ball", 2, "Barf"));
        userList.add(new User("0xFFB", "Memory", "Hex", 2, "helpMe"));
        userList.add(new User("period", "Full", "Stop", 1, "WowAPassword"));
        userList.add(new User("dajokerbaby", "Jay", "Leno", 1, "MickeyMouse"));
        DataWriter.saveUsers();
        assertEquals("dajokerbaby", DataLoader.loadUsers().get(4).getUserName());
    }

    @Test 
    void testWriteEmptyUser() {
        userList.add(new User("", "", "", 0, ""));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.loadUsers().get(0).getFirstName());
    }

    @Test 
    void testWriteNullUser() {
        userList.add(new User(null, "", "", 2, ""));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.loadUsers().get(0).getUserName());
    }

    @Test
    void testWriteZeroCrimes() {
        crimeList = DataLoader.loadCrimes();
        assertEquals(0, crimeList.size());
    }

    @Test
    void testWriteOneCrime() {
        crimeList.add(new Crime("400", "Murder", 0, 0, false, null, "Spartanburg", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(0).getID()); // FINISH!
    }

    @Test
    void testWriteFiveCrimes() {
        crimeList.add(new Crime("400", "Murder", 0, 0, false, null, "Spartanburg", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        crimeList.add(new Crime("202", "Assault", 1, 2, true, null, "724 E Main St", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        crimeList.add(new Crime("402", "Robbery", 3, 2, false, null, "120 Street St", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        crimeList.add(new Crime("011", "Public Nudity", 1, 0, true, null, "9009 Blossom Rd", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        crimeList.add(new Crime("909", "Terrorism", 3, 0, false, null, "785 Knox Abbott Dr", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(3).getLocation()); // FINISH!
    }

    @Test
    void testWriteEmptyCrimes() {
        crimeList.add(new Crime("400", "Murder", 0, 0, false, null, "Spartanburg", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(0).getTypeOfCrime());
    }

    @Test
    void testWriteNullCrimes() {
        crimeList.add(new Crime(null, "Murder", 0, 0, false, null, "Spartanburg", new ArrayList<POI>(), new ArrayList<Suspect>(), new ArrayList<Criminal>(), new ArrayList<Victim>(), new ArrayList<Witness>(), new ArrayList<Officer>(), new ArrayList<Evidence>()));
        DataWriter.saveCrimes();
        assertEquals(null, DataLoader.loadCrimes().get(0).getID());
    }

    @Test
    void testWriteZeroCriminals() {
        criminalList = DataLoader.loadCriminals();
        assertEquals(0, criminalList.size());
    }

    @Test
    void testWriteOneCriminals() {
        criminalList.add(new Criminal("Manufac 3rd off sched I", "23 years", "At Riker's Island", true));
        DataWriter.saveCriminals();
        assertEquals("", DataLoader.loadCriminals().get(0).getSentence());
    }

    @Test
    void testWriteFiveCriminals() {
        criminalList.add(new Criminal("Murder, Robbery", "124 years", "At ADX Florence", true));
        criminalList.add(new Criminal("Wire fraud", "6 months", "Probation", false));
        criminalList.add(new Criminal("Public Nudity", "2 months", "none", false));
        criminalList.add(new Criminal("Manufac 3rd off sched I", "23 years", "At Riker's Island", true));
        criminalList.add(new Criminal("Hacking", "1 year", "Probation", false));
        DataWriter.saveCriminals();
        assertEquals("", DataLoader.loadCriminals().get(2).getStatus());
    }

    @Test
    void testWriteEmptyCriminals() {
        criminalList.add(new Criminal("", "", "", false));
        DataWriter.saveCriminals();
        assertEquals("", DataLoader.loadCriminals().get(0).getCrimes());
    }

    @Test
    void testWriteNullCriminals() {
        criminalList.add(new Criminal("Manufac 3rd off sched I", null, "At Riker's Island", true));
        DataWriter.saveCriminals();
        assertEquals(null, DataLoader.loadCriminals().get(0).getSentence());
    }

    @Test
    void testWriteOneEvidences() {
        evidenceList.add(new Evidence("Baseball bat", 30, "Stanley bat", "12/25/1994"));
        DataWriter.saveEvidences();
        assertEquals("", DataLoader.loadEvidence().get(0).getDateOfDiscovery());
    }

    @Test
    void testWriteFiveEvidences() {
        evidenceList.add(new Evidence("Wire Cutters", 303, "Fluke Wire Cutters, missing grips", "02/21/2021"));
        evidenceList.add(new Evidence("S&W 9MM", 40402, "Scraped serial number", "06/23/1992"));
        evidenceList.add(new Evidence("Baseball bat", 30, "Stanley bat", "12/25/1994"));
        evidenceList.add(new Evidence("Taurus Judge", 404, "Had 4 shotgun shells inside it", "08/29/2004"));
        evidenceList.add(new Evidence("Dell laptop", 4005, "Missing k on keyboard", "04/09/2021"));
        DataWriter.saveEvidences();
        assertEquals("", DataLoader.loadEvidence().get(3).getDescription());
    }

    @Test
    void testWriteEmptyEvidences() {
        evidenceList.add(new Evidence("", 1, "", ""));
        DataWriter.saveEvidences();
        assertEquals("", DataLoader.loadEvidence().get(0).getDateOfDiscovery());
    }

    @Test
    void testWriteNullEvidences() {
        evidenceList.add(new Evidence("Baseball bat", 30, "Stanley bat", null));
        DataWriter.saveEvidences();
        assertEquals(null, DataLoader.loadEvidence().get(0).getDateOfDiscovery());
    }

    @Test
    void testWriteOneReports() {
        reportList.add(new HospitalReport("R9920", "Scraped ankle", "Rock thrown at them by stranger", null, null, "02/20/1994", 0));
        DataWriter.saveHospitalReports();
        assertEquals("", DataLoader.loadHReports().get(0).getCause());
    }

    @Test
    void testWriteFiveReports() {
        reportList.add(new HospitalReport("R0010", "GSW in abdomen", "Shot by cousin", null, null, "03/20/2020", 32));
        reportList.add(new HospitalReport("R0101", "Broken femur", "Fell down stairs", null, null, "11/01/2004", 5));
        reportList.add(new HospitalReport("R4510", "GSW in head", "Shot by mom", null, null, "03/20/2021", 90));
        reportList.add(new HospitalReport("R9920", "Scraped ankle", "Rock thrown at them by stranger", null, null, "02/20/1994", 0));
        reportList.add(new HospitalReport("R0001", "Missing foot", "Car crash", null, null, "04/09/2021", 40));
        DataWriter.saveHospitalReports();
        assertEquals("", DataLoader.loadHReports().get(4).getDoctor());
    }

    @Test
    void testWriteEmptyReports() {
        reportList.add(new HospitalReport("", "", "", null, null, "", 0));
        DataWriter.saveHospitalReports();
        assertEquals("", DataLoader.loadHReports().get(0).getDiagnosis());
    }

    @Test
    void testWriteNullReports() {
        reportList.add(new HospitalReport(null, "Scraped ankle", "Rock thrown at them by stranger", null, null, "02/20/1994", 0));
        DataWriter.saveHospitalReports();
        assertEquals(null, DataLoader.loadHReports().get(0).getID());
    }

    @Test
    void testWriteOneOfficers() {
        officerList.add(new Officer("Private", "I used a PIT maneuver on the suspect."));
        DataWriter.saveOfficers();
        assertEquals("", DataLoader.loadOfficer().get(0).getTypeOfOfficer());
    }

    @Test
    void testWriteFiveOfficers() {
        officerList.add(new Officer("Detective", "I arrived on scene and he was beating the girl."));
        officerList.add(new Officer("Sergeant", "We fired upon the suspect after observing him retrieve a pistol from the dash."));
        officerList.add(new Officer("Corporal", "Me and my partner handcuffed the man after seeing a crack baggie in his pants."));
        officerList.add(new Officer("Private", "I used a PIT maneuver on the suspect."));
        officerList.add(new Officer("Detective", "I got a statement from the girl after she claimed the other girl hit her car."));
        DataWriter.saveOfficers();
        assertEquals("", DataLoader.loadOfficer().get(2).getStatement());
    }

    @Test
    void testWriteEmptyOfficers() {
        officerList.add(new Officer("", ""));
        DataWriter.saveOfficers();
        assertEquals("", DataLoader.loadOfficer().get(0).getTypeOfOfficer());
    }

    @Test
    void testWriteNullOfficers() {
        officerList.add(new Officer(null, "I used a PIT maneuver on the suspect."));
        DataWriter.saveOfficers();
        assertEquals(null, DataLoader.loadOfficer().get(0).getStatement());
    }

    @Test
    void testWriteOnePeople() {
        personList.add(new Person("Dillon", "Alex", "P230540", "M", "W", "R", "Straight", "B", "404 Langley Rd", "20"));
        DataWriter.savePeople();
        assertEquals("", DataLoader.loadPeople().get(0).getFirstName());
    }

    @Test
    void testWriteFivePeople() {
        personList.add(new Person("DJ", "Jim", "P001040", "M", "W", "Black", "Balding", "B", "920 E Verdia Dr", "42"));
        personList.add(new Person("Milton", "Gerold", "P020150", "F", "B", "Black", "Long", "G", "102 W Main St", "92"));
        personList.add(new Person("Alissa", "Stephens", "P511040", "F", "W", "Brown", "Curly", "B", "920 E Wesley Dr", "24"));
        personList.add(new Person("Ken", "German", "P025653", "M", "B", "Black", "Balding", "B", "102 Whaley St", "67"));
        personList.add(new Person("Dillon", "Alex", "P230540", "M", "W", "R", "Straight", "B", "404 Langley Rd", "20"));
        DataWriter.savePeople();
        assertEquals("", DataLoader.loadPeople().get(1).getHairColor());
    }

    @Test
    void testWriteEmptyPeople() {
        personList.add(new Person("", "", "", "", "", "", "", "", "", ""));
        DataWriter.savePeople();
        assertEquals("", DataLoader.loadPeople().get(0).getLastName());
    }

    @Test
    void testWriteNullPeople() {
        personList.add(new Person("Dillon", null, "P230540", "M", "W", "R", "Straight", "B", "404 Langley Rd", "20"));
        DataWriter.savePeople();
        assertEquals(null, DataLoader.loadPeople().get(0).getLastName());
    }

    @Test
    void testWriteOnePOIs() {
        poiList.add(new POI("dragon on left shoulder", "Crips", "cousin", "owns the gun", false));
        DataWriter.savePOIs();
        assertEquals("", DataLoader.loadPOI().get(0).getGang());
    }

    @Test
    void testWriteFivePOIs() {
        poiList.add(new POI("dragon on left shoulder", "Crips", "cousin", "owns the gun", false));
        poiList.add(new POI("none", "none", "brother", "drove the car", false));
        poiList.add(new POI("ice cream cone on forehead", "Bloods", "sister", "owns a similar gun", true));
        poiList.add(new POI("none", "MS13", "sister", "fingerprint were found nearby", false));
        poiList.add(new POI("none", "none", "mother", "owns the gun", false));
        DataWriter.savePOIs();
        assertEquals("", DataLoader.loadPOI().get(3).getVictimRelationship());
    }

    @Test
    void testWriteEmptyPOIs() {
        poiList.add(new POI("", "", "", "", false));
        DataWriter.savePOIs();
        assertEquals("", DataLoader.loadPOI().get(0).getTattoos());
    }

    @Test
    void testWriteNullPOIs() {
        poiList.add(new POI(null, "Crips", "cousin", "owns the gun", false));
        DataWriter.savePOIs();
        assertEquals(null, DataLoader.loadPOI().get(0).getTattoos());
    }

    @Test
    void testWriteOneSuspects() {
        suspectList.add(new Suspect(null, null, 12.0, "Gucci pants", "L", "bruh", "Skydiving", "Dealer", "Eye tattoo", "5'9"));
        DataWriter.saveSuspects();
        assertEquals("", DataLoader.loadSuspects().get(0).getPrefferedClothes());
    }

    @Test
    void testWriteFiveSuspects() {
        suspectList.add(new Suspect(null, null, 8.0, "Hoodies", "Bibbi", "none", "Driving", "Cashier", "Bald", "6'2"));
        suspectList.add(new Suspect(null, null, 12.0, "Gucci pants", "L", "bruh", "Skydiving", "Dealer", "Eye tattoo", "5'9"));
        suspectList.add(new Suspect(null, null, 7.0, "None", "Steph", "none", "Shopping", "Cashier", "Scar on left heel", "5'2"));
        suspectList.add(new Suspect(null, null, 6.0, "Louboutin heels", "Exe", "Heyo", "Drugs", "none", "back tattoo", "5'4"));
        suspectList.add(new Suspect(null, null, 14.0, "Ultraboosts", "none", "none", "Driving", "Executive", "Bald", "6'8"));
        DataWriter.saveSuspects();
        assertEquals("", DataLoader.loadSuspects().get(3).getFootSize());
    }

    @Test
    void testWriteEmptySuspects() {
        suspectList.add(new Suspect(null, null, 0.0, "", "", "", "", "", "", ""));
        DataWriter.saveSuspects();
        assertEquals("", DataLoader.loadSuspects().get(0).getHobbies());
    }

    @Test
    void testWriteNullSuspects() {
        suspectList.add(new Suspect(null, null, 12.0, null, "L", "bruh", "Skydiving", "Dealer", "Eye tattoo", "5'9"));
        DataWriter.saveSuspects();
        assertEquals(null, DataLoader.loadSuspects().get(0).getPrefferedClothes());
    }

    @Test
    void testWriteOneVictims() {
        victimList.add(new Victim("My cousin shot me", true, null));
        DataWriter.saveVictims();
        assertEquals(false, DataLoader.loadVictims().get(0).getIsAlive());
    }

    @Test
    void testWriteFiveVictims() {
        victimList.add(new Victim("He hit me with a baseball bat", true, null));
        victimList.add(new Victim("none", false, null));
        victimList.add(new Victim("I was ran over by a 1998 Lexus", true, null));
        victimList.add(new Victim("none", false, null));
        victimList.add(new Victim("My cousin shot me", true, null));
        DataWriter.saveVictims();
        assertEquals("", DataLoader.loadVictims().get(4).getHospitalReports());
    }

    @Test
    void testWriteEmptyVictims() {
        victimList.add(new Victim("", true, null));
        DataWriter.saveVictims();
        assertEquals("", DataLoader.loadVictims().get(0).getStatement());
    }

    @Test
    void testWriteNullVictims() {
        victimList.add(new Victim(null, true, null));
        DataWriter.saveVictims();
        assertEquals(null, DataLoader.loadVictims().get(0).getStatement());
    }
}