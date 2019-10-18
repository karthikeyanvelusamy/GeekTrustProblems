package com.geektrust.family.bean;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is used to encapsulate the two different type of response.
 * 
 * @author karthikeyan.v
 */
public class Relatives {

	/** The relative person. */
	private Person relativePerson;

	/** The relative people. */
	private Set<Person> relativePeople;

	public Relatives(Person relativePerson) {
		this.relativePerson = relativePerson;
	}

	public Relatives(Set<Person> relatives) {
		this.relativePeople = relatives;
	}

	/**
	 * Gets the relative person.
	 *
	 * @return the relative person
	 */
	public Person getRelativePerson() {
		return relativePerson;
	}

	/**
	 * Gets the relative people.
	 *
	 * @return the relative people
	 */
	public Set<Person> getRelativePeople() {
		return (relativePeople == null) ? Collections.emptySet()
				: new HashSet<>(relativePeople);
	}
}
