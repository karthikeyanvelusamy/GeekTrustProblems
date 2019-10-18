package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class GrandSonRelationShip.
 * 
 * @author karthikeyan.vF
 */
public class GrandSonRelationShip extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new grand son relation ship.
	 *
	 * @param person
	 *            the person
	 */
	public GrandSonRelationShip(Person person) {
		super(person, RelationType.GRAND_SON);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> grandSons = new HashSet<>();
		Set<Person> children = new HashSet<>(person.getChildren());
		for (Person p : children) {
			SonRelationship sonRelationship = new SonRelationship(p);
			grandSons.addAll(sonRelationship.get().getRelative()
					.getRelativePeople());
		}
		return getRelationBean(grandSons, RelationType.GRAND_SON);
	}
}
