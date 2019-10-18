package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class DaughterRelationship.
 * 
 * @author karthikeyan.v
 */
public class DaughterRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new daughter relationship.
	 *
	 * @param person
	 *            the person
	 */
	public DaughterRelationship(Person person) {
		super(person, RelationType.DAUGHTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> children = new HashSet<>(person.getChildren());
		Set<Person> daughters = children
				.stream()
				.filter(person -> person.getGender().equals(
						Person.Gender.FEMALE)).collect(Collectors.toSet());
		return getRelationBean(daughters, RelationType.DAUGHTER);
	}
}
