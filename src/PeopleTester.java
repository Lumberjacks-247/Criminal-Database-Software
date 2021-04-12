package src;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeopleTester {

	Person dylan = new Person("dylan", "neff");
	Person bob = new Person("bob", "jones", null, null, null, "brown", null, null, null, null);    
	POI james = new POI("james", "castle", null, null, "white", "black", null, "green", null, "22", null, null, null, null, true);
	Suspect rocko = new Suspect("rocko", "rock", null, null, "black", "red", null, null, null, null, null, null, null, null, true, null, null, 13.0, null, null, null, "jump rope", "stock broker", null, null);
	Criminal hector = new Criminal("hector", "moose", null, null, "white", null, "bald", null, null, "30s", null, null, null, null, true, null, null, 11.0, null, null, null, null, null, null, "6'2", null, "5 years", "in jail", true);
	Victim bill = new Victim("bill", "bradley", null, "male", null, null, null, null, null, null, "I was stabbed by a man in a black hoodie", true, null);
	Witness karen = new Witness("karen", "wagner", null, "female", null, null, null, null, null, null, "803-777-6565", "karenw123@gmail.com", "man in a black hoodie stabbed another man with a knife", null);
	Officer doug = new Officer("doug", "williams", "detective");
	Crime crime = new Crime(null, "murder", 3, 2, false, null, "Orlando, FL", null, null, null, null, null, null, null);

	//PARTIAL COMPARE TESTS
    @Test
    public void testPersonPartialCompareRight() {
        Person dylanClone = new Person("dylan", "neff", "hfhf", "hfhfh", "hffhf", "fhfhf", "hfhfhf", "fhfh", "hfhf", "hfh");
        boolean test = dylan.partialCompare(dylanClone);
        assertTrue(test);
    }

	@Test
    public void testPersonPartialCompareWrong() {
        Person dylanClone = new Person("dylan", "brown", "hfhf", "hfhfh", "hffhf", "fhfhf", "hfhfhf", "fhfh", "hfhf", "hfh");
        boolean test = dylan.partialCompare(dylanClone);
        assertFalse(test);
    }

	@Test
    public void testPersonPartialCompareMoreInfo() {
        Person bobTest = new Person("bob", "jones", "hfhf", "hfhfh", "hffhf", "brown", "hfhfhf", "fhfh", "hfhf", "hfh");
        boolean test = bob.partialCompare(bobTest);
        assertTrue(test);
    }

	@Test
    public void testPersonPartialCompareLessInfoWrong() {
        Person bobTest = new Person("bob", "jones");
        boolean test = bob.partialCompare(bobTest);
        assertFalse(test);
    }

	@Test
	public void testPersonPartialCompareLessInfoRight() {
        Person dylanTest = new Person("dylan", "neff");
        boolean test = dylan.partialCompare(dylanTest);
        assertTrue(test);
    }

	//TOSTRING TESTS
	@Test
	public void testPersonToStringSmall() {
		String ret = dylan.toString();
		String expected = "First Name: dylan | Last Name: neff";
		assertEquals(expected, ret);
	}

	@Test
	public void testPersonToStringLarge() {
		String ret = bob.toString();
		String expected = "First Name: bob | Last Name: jones | Hair Color: brown";
		assertEquals(expected, ret);
	}

	@Test
	public void testPOIPartialCompareToPersonRight() {
		POI testDylan = new POI("dylan", "neff", null, null, null, null, null, "blue", null, "47", "dove", null, null, null, false);
		boolean test = dylan.partialCompare(testDylan);
		assertTrue(test);
	}

	@Test
	public void testPOIPartialCompareToPersonWrong() {
		POI testBob = new POI("bob", "jones", null, null, null, null, null, "blue", null, "47", "dove", null, null, null, false);
		boolean test = bob.partialCompare(testBob);
		assertFalse(test);
	}

	@Test
	public void testPOIPartialCompareToPOIRight() {
		POI testJames = new POI(null, null, null, null, "white", "black", null, "green", null, "22", null, null, null, null, true);
		boolean test = testJames.partialCompare(james);
		assertTrue(test);
	}

	@Test
	public void testPOIPartialCompareToPOIWrong() {
		POI testJames = new POI("dylan", null, null, null, "white", "black", null, "green", null, "22", null, null, null, null, true);
		boolean test = testJames.partialCompare(james);
		assertFalse(test);
	}

	@Test
	public void testPOIToStringRight() {
		String ret = james.toString();
		String expected = "First Name: james | Last Name: castle | Age: 22 | Race: white | Hair Color: black | Eye Color: green | Repeat Offender: true";
		assertEquals(expected, ret);
	}

	@Test
	public void testSuspectPartialCompareRight() {
		Suspect testJames = new Suspect("james", "castle", null, null, "white", "black", null, "green", null, "22", null, null, null, null, true, null, null, 0.0, null, null, null, null, null, null, null);
		boolean test = james.partialCompare(testJames);
		assertTrue(test);
	}

	@Test
	public void testSuspectPartialCompareWrong() {
		boolean test = james.partialCompare(rocko);
		assertFalse(test);
	}

	@Test
	public void testSuspectToString() {
		String ret = rocko.toString();
		String expected = "First Name: rocko | Last Name: rock | Race: black | Hair Color: red | Repeat Offender: true | Foot Size: 13.0 | Hobbies: jump rope | Job: stock broker";
		assertEquals(expected, ret);
	}

	@Test
	public void testCriminalPartialCompareRight() {
		Criminal testHector = new Criminal("hector", null, null, null, "white", null, "bald", null, null, "30s", null, null, null, null, true, null, null, 11.0, null, null, null, null, null, null, "6'2", null, "5 years", "in jail", true);
		boolean test = testHector.partialCompare(hector);
		assertTrue(test);
	}

	@Test
	public void testCriminalPartialCompareWrong() {
		boolean test = hector.partialCompare(rocko);
		assertFalse(test);
	}

	@Test
	public void testCriminalToString() {
		String ret = hector.toString();
		String expected = "First Name: hector | Last Name: moose | Age: 30s | Race: white | Hair Style: bald | Repeat Offender: true | Height: 6'2 | Foot Size: 11.0 | Sentence: 5 years | Status: in jail | In Custody: true";
		assertEquals(expected, ret);
	}

	@Test
	public void testVictimPartialCompareRight() {
		Victim vic = new Victim("bill", null, null, null, null, null, null, null, null, null, "I was stabbed by a man in a black hoodie", true, null);
		boolean test = vic.partialCompare(bill);
		assertTrue(test);
	}

	@Test
	public void testVictimPartialCompareWrong() {
		boolean test = bill.partialCompare(dylan);
		assertFalse(test);
	}

	@Test
	public void testVictimToString() {
		String ret = bill.toString();
		String expected = "First Name: bill | Last Name: bradley | Gender: male | Statement: I was stabbed by a man in a black hoodie | Is Alive: true";
		assertEquals(expected, ret);
	}

	@Test
	public void testWitnessPartialCompareRight() {
		Witness wit = new Witness("karen", null, null, null, null, null, null, null, null, null, "803-777-6565", "karenw123@gmail.com", "man in a black hoodie stabbed another man with a knife", null);
		boolean test = wit.partialCompare(karen);
		assertTrue(test);
	}

	@Test
	public void testWitnessPartialCompareWrong() {
		boolean test = karen.partialCompare(dylan);
		assertFalse(test);
	}

	@Test
	public void testWitnessToString() {
		String ret = karen.toString();
		String expected = "";
		assertEquals(expected, ret);
	}

	@Test
	public void testOfficerPartialCompareRight() {
		Officer off = new Officer("doug", "williams", "detective");
		boolean test = off.partialCompare(doug);
		assertTrue(test);
	}

	@Test
	public void testOfficerPartialCompareWrong() {
		boolean test = doug.partialCompare(dylan);
		assertFalse(test);
	}

	@Test
	public void testOfficerToString() {
		String ret = doug.toString();
		String expected = "First Name: doug | Last Name: williams | Type of Officer: detective | Statement: ";
		assertEquals(expected, ret);
	}

	@Test
	public void testCrimeToString() {
		String ret = crime.toString();
		String expected = "Type of Crime: murder | Level of Charge: 3 | Jurisdiction: 2 | Location: Orlando,FL | Open: false";
		assertEquals(expected, ret);
	}
}
