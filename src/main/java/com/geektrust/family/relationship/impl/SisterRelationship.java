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
 * The Class SisterRelationship.
 * 
 * @author karthikeyan.v
 */
public class SisterRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new sister relationship.
	 *
	 * @param person
	 *            the person
	 */
	public SisterRelationship(Person person) {
		super(person, RelationType.SISTER);
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
					.filter(p -> p.getGender().equals(Person.Gender.FEMALE))
					.collect(Collectors.toSet()));
			siblings.remove(person);
		}
		return getRelationBean(siblings, RelationType.SISTER);
	}
}
