package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class SiblingsRelationship.
 * 
 * @author karthikeyan.v
 */
public class SiblingsRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new siblings relationship.
	 *
	 * @param person
	 *            the person
	 */
	public SiblingsRelationship(Person person) {
		super(person, RelationType.SIBLINGS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Person parent = person.getParent();
		Set<Person> siblings = new HashSet<>();
		if (parent != null) {
			siblings.addAll(parent.getChildren());
			siblings.remove(person);
		}
		return getRelationBean(siblings, RelationType.SIBLINGS);
	}
}
