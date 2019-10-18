package com.geektrust.family.relationship.impl;

import java.util.HashSet;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class ChildrenRelationship.
 * 
 * @author karthikeyan.v
 */
public class ChildrenRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new children relationship.
	 *
	 * @param person
	 *            the person
	 */
	public ChildrenRelationship(Person person) {
		super(person, RelationType.CHILDREN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		return getRelationBean(new HashSet<>(person.getChildren()),
				RelationType.CHILDREN);
	}
}
