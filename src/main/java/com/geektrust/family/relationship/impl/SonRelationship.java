package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class SonRelationship.
 * 
 * @author karthikeyan.v
 */
public class SonRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new son relationship.
	 *
	 * @param person
	 *            the person
	 */
	public SonRelationship(Person person) {
		super(person, RelationType.SON);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> children = person.getChildren();
		Set<Person> sons = new HashSet<>(
				children.stream()
						.filter(person -> person.getGender().equals(
								Person.Gender.MALE))
						.collect(Collectors.toSet()));
		return getRelationBean(sons, RelationType.SON);
	}
}
