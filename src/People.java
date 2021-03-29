package src;
import java.util.ArrayList;

public class People {
	private static People people;
	private ArrayList<Person> personList;
	
	private People() {
		personList = DataLoader.loadPeople();
	}
	
	public static People getInstance() {
		if(people == null) {
			people = new People();
		}
		return people;
	}
	
	//check if have person.
	public boolean havePerson(String personName) {
		for(Person person : personList) {
      String firstname = person.getFirstName();
      String lastname = person.getLastName();
      String name = firstname +" "+ lastname;
			if(name.equals(personName)) 
				return true;
		}
		return false;
	}
	
	
	public Person getPerson(String personName) {
		for(Person person: personList) {
      String firstname = person.getFirstName();
      String lastname = person.getLastName();
      String name = firstname +" "+ lastname;
			if(name.equals(personName)) {
				return person;
			}
		}
		return null;
	}
	
	public ArrayList<Person> getPeople(){
		return personList;
	}
	
	public boolean addPerson(String firstName,  String lastName) {
		if(havePerson(firstName))
			return false;
		personList.add(new Person(firstName, lastName));
		return true;
	}
	
	public void savePeople() {
		DataWriter.savePeople();
	}



}
