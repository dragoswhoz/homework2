package tema_09_02;

import java.util.*;
import java.util.function.Supplier;


public class HobbyApp {
	private static Map<Person, List<Hobby>> hobbyBook = new Hashtable<>();

	static void start() {
		// HobbyApp app = new HobbyApp();

		Person dragosPirvu = new Person("Dragos", "Pirvu");
		Person ionelaNistorescu = new Person("Ionela", "Nistorescu");
		Person denisaPirvu = new Person("Denisa", "Pirvu");
		Person alinaRebosapca = new Person("Alina", "Rebosapca");
		Person evaAndreea = new Person("Eva", "Andreeea");

		List<Hobby> hobbyListDragosPirvu = new ArrayList<>();

		Hobby hobby1DragosPirvu = new Hobby("Football", 2);
		Hobby hobby2DragosPirvu = new Hobby("Running", 3);
		Hobby hobby3DragosPirvu = new Hobby("Java", 1);

		hobbyListDragosPirvu.add(hobby1DragosPirvu);
		hobbyListDragosPirvu.add(hobby2DragosPirvu);
		hobbyListDragosPirvu.add(hobby3DragosPirvu);

		hobby1DragosPirvu.addAddress(new Address("Pitesti", "Tudor Vladimirescu", "26"));
		hobby1DragosPirvu.addAddress(new Address("Pitesti", "Eremia Grigorescu", "12"));

		hobbyBook.put(dragosPirvu, hobbyListDragosPirvu);

		createHobbyList(evaAndreea, new Hobby("Swimming", 2), new Address("Pitesti", "Nicolae Balcescu", "15B"));
		createHobbyList(evaAndreea, new Hobby("Swimming", 2), new Address("Pitesti", "Nicolae Balcescu", "15B"));
		createHobbyList(evaAndreea, new Hobby("Swimming", 2), new Address("Pitesti", "Nicolae Balcescu", "1B"));
		createHobbyList(evaAndreea, new Hobby("Tennis", 2), new Address("Pitesti", "Nicolae Balcescu", "15B"));

		listHobbies(dragosPirvu);
		listHobbies(evaAndreea);
	}

	public static void listHobbies(Person person) {
		System.out.println(person.getFullName() + " has the following hobbies:");
		hobbyBook.get(person).forEach(hobby -> {
			System.out.println(hobby + " -> which can be done at the folowing addresses:");
			hobby.getHobbyAddresses().forEach(address -> System.out.println(address));
		});

	}

	public static void createHobbyList(Person person, Hobby hobby, Address address) {
		hobby.addAddress(address);
		List<Hobby> hobbyList;
		hobbyList = hobbyBook.containsKey(person) ? hobbyBook.get(person) : new ArrayList<>();
		if (hobbyList.contains(hobby)) {
			hobbyList.get(hobbyList.indexOf(hobby)).addAddress(address);
		} else {
			hobbyList.add(hobby);
		}
		hobbyBook.putIfAbsent(person, hobbyList);
		hobbyBook.computeIfPresent(person, (p, h) -> hobbyList);

	}

}
