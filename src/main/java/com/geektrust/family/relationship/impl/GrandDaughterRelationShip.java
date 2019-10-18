package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class GrandDaughterRelationShip.
 * 
 * @author karthikeyan.v
 */
public class GrandDaughterRelationShip extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new grand daughter relation ship.
	 *
	 * @param person
	 *            the person
	 */
	public GrandDaughterRelationShip(Person person) {
		super(person, RelationType.GRAND_DAUGHTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> grandDaughters = new HashSet<>();
		Set<Person> children = new HashSet<>(person.getChildren());
		for (Person p : children) {
			DaughterRelationship daughterRel = new DaughterRelationship(p);
			grandDaughters.addAll(daughterRel.get().getRelative()
					.getRelativePeople());
		}
		return getRelationBean(grandDaughters, RelationType.GRAND_DAUGHTER);
	}
}
