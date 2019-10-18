package com.geektrust.family.relationship.impl;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.SingleAbstractRelation;

/**
 * The Class MotherRelationship.
 * 
 * @author karthikeyan.v
 */
public class MotherRelationship extends SingleAbstractRelation {

	/**
	 * Instantiates a new mother relationship.
	 *
	 * @param person
	 *            the person
	 */
	public MotherRelationship(Person person) {
		super(person, RelationType.MOTHER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Person parent = person.getParent();
		Person mother = parent;
		if (mother != null && mother.getGender().equals(Person.Gender.MALE)) {
			mother = parent.getSpouce();
		}
		return getRelationBean(mother, RelationType.MOTHER);
	}
}
