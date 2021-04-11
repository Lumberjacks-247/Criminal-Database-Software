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
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence))
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence))
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        officerList.add(new Officer(typeOfOfficer, statement));
        officerList.add(new Officer(typeOfOfficer, statement));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
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
