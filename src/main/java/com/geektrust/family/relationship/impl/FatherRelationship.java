package com.geektrust.family.relationship.impl;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.SingleAbstractRelation;

/**
 * The Class FatherRelationship.
 * 
 * @author karthikeyan.v
 */
public class FatherRelationship extends SingleAbstractRelation {

	/**
	 * Instantiates a new father relationship.
	 *
	 * @param person
	 *            the person
	 */
	public FatherRelationship(Person person) {
		super(person, RelationType.FATHER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Person parent = person.getParent();
		Person father = parent;
		if (father != null && father.getGender().equals(Person.Gender.FEMALE)) {
			father = parent.getSpouce();
		}
		return getRelationBean(father, RelationType.FATHER);
	}
}
