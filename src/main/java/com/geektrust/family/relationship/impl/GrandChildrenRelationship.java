package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class GrandChildrenRelationship.
 * 
 * @author karthikeyan.v
 */
public class GrandChildrenRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new grand children relationship.
	 *
	 * @param person
	 *            the person
	 */
	public GrandChildrenRelationship(Person person) {
		super(person, RelationType.GRAND_CHILDREN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> grandChildren = new HashSet<>();
		Set<Person> children = new HashSet<>(person.getChildren());
		for (Person p : children) {
			ChildrenRelationship childrenRelationship = new ChildrenRelationship(
					p);
			grandChildren.addAll(childrenRelationship.get().getRelative()
					.getRelativePeople());
		}
		return getRelationBean(grandChildren, RelationType.GRAND_CHILDREN);
	}
}
