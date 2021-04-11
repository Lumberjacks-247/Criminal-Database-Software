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
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(0).getID()); // FINISH!
    }

    @Test
    void testWriteFiveCrimes() {
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(3).getLocation()); // FINISH!
    }

    @Test
    void testWriteEmptyCrimes() {
        crimeList.add(new Crime(id, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.loadCrimes().get(0).getTypeOfCrime());
    }

    @Test
    void testWriteNullCrimes() {
        crimeList.add(new Crime(null, typeOfCrime, levelOfCharge, jurisdiction, isOpen, author, location, pois, suspects, criminals, victims, witnesses, officers, evidence));
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
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        DataWriter.saveCriminals();
        assertEquals("", DataLoader.loadCriminals().get(0).getSentence());
    }

    @Test
    void testWriteFiveCriminals() {
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
        criminalList.add(new Criminal(crimes, sentence, status, inCustody));
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
        criminalList.add(new Criminal(crimes, null, status, inCustody));
        DataWriter.saveCriminals();
        assertEquals(null, DataLoader.loadCriminals().get(0).getSentence());
    }

    @Test
    void testWriteOneEvidences() {
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        DataWriter.saveEvidences();
        assertEquals("", DataLoader.loadEvidence().get(0).getDateOfDiscovery());
    }

    @Test
    void testWriteFiveEvidences() {
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
        evidenceList.add(new Evidence(evidenceName, id, description, dateCollected));
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
        evidenceList.add(new Evidence("", 0, "", null));
        DataWriter.saveEvidences();
        assertEquals(null, DataLoader.loadEvidence().get(0).getDateOfDiscovery());
    }

    @Test
    void testWriteOneReports() {
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        DataWriter.saveHospitalReports();
        assertEquals("", DataLoader.loadHReports().get(0).getCause());
    }

    @Test
    void testWriteFiveReports() {
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        reportList.add(new HospitalReport(id, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
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
        reportList.add(new HospitalReport(null, diagnosis, cause, doctor, nurse, dateAdmitted, numDaysAdmitted));
        DataWriter.saveHospitalReports();
        assertEquals(null, DataLoader.loadHReports().get(0).getID());
    }

    @Test
    void testWriteOneOfficers() {
        officerList.add(new Officer(typeOfOfficer, statement));
        DataWriter.saveOfficers();
        assertEquals("", DataLoader.loadOfficer().get(0).getTypeOfOfficer());
    }

    @Test
    void testWriteFiveOfficers() {
        officerList.add(new Officer(typeOfOfficer, statement));
        officerList.add(new Officer(typeOfOfficer, statement));
        officerList.add(new Officer(typeOfOfficer, statement));
        officerList.add(new Officer(typeOfOfficer, statement));
        officerList.add(new Officer(typeOfOfficer, statement));
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
        officerList.add(new Officer(null, ""));
        DataWriter.saveOfficers();
        assertEquals(null, DataLoader.loadOfficer().get(0).getStatement());
    }

    @Test
    void testWriteOnePeople() {
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        DataWriter.savePeople();
        assertEquals("", DataLoader.loadPeople().get(0).getFirstName());
    }

    @Test
    void testWriteFivePeople() {
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
        personList.add(new Person(firstName, lastName, id, gender, race, hairColor, hairStyle, eyeColor, address, age));
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
        personList.add(new Person("", null, "", "", "", "", "", "", "", ""));
        DataWriter.savePeople();
        assertEquals(null, DataLoader.loadPeople().get(0).getLastName());
    }

    @Test
    void testWriteOnePOIs() {
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        DataWriter.savePOIs();
        assertEquals("", DataLoader.loadPOI().get(0).getGang());
    }

    @Test
    void testWriteFivePOIs() {
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
        poiList.add(new POI(tattoos, gang, victimRelationship, evidenceConnection, isRepeatOffender));
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
        poiList.add(new POI(null, "", "", "", true));
        DataWriter.savePOIs();
        assertEquals(null, DataLoader.loadPOI().get(0).getTattoos());
    }

    @Test
    void testWriteOneSuspects() {
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        DataWriter.saveSuspects();
        assertEquals("", DataLoader.loadSuspects().get(0).getPrefferedClothes());
    }

    @Test
    void testWriteFiveSuspects() {
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
        suspectList.add(new Suspect(accomplices, familyMembers, footSize, prefferedClothes, nickNames, commonWords, hobbies, job, distinctPhysicalTraits, height));
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
        suspectList.add(new Suspect(null, null, 0.0, null, "", "", "", "", "", ""));
        DataWriter.saveSuspects();
        assertEquals(null, DataLoader.loadSuspects().get(0).getPrefferedClothes());
    }

    @Test
    void testWriteOneVictims() {
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        DataWriter.saveVictims();
        assertEquals(false, DataLoader.loadVictims().get(0).getIsAlive());
    }

    @Test
    void testWriteFiveVictims() {
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
        victimList.add(new Victim(statement, isAlive, hospitalReports));
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
        victimList.add(new Victim(null, false, null));
        DataWriter.saveVictims();
        assertEquals(null, DataLoader.loadVictims().get(0).getStatement());
    }
}