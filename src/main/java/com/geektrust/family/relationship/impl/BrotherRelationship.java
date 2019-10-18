package com.geektrust.family.relationship.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class BrotherRelationship.
 * 
 * @author karthikeyan.v
 */
public class BrotherRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new brother relationship.
	 *
	 * @param person
	 *            the person
	 */
	public BrotherRelationship(Person person) {
		super(person, RelationType.BROTHER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> siblings = Collections.emptySet();
		if (person.getParent() != null) {
			Person parent = person.getParent();
			siblings = new HashSet<>(parent.getChildren().stream()
					.filter(p -> p.getGender().equals(Person.Gender.MALE))
					.collect(Collectors.toSet()));

			siblings.remove(person);
		}
		return getRelationBean(siblings, RelationType.BROTHER);
	}
}
