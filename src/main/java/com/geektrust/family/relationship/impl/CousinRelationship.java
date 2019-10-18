package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class CousinRelationship.
 * 
 * @author karthikeyan.v
 */
public class CousinRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new cousin relationship.
	 *
	 * @param person
	 *            the person
	 */
	public CousinRelationship(Person person) {
		super(person, RelationType.COUSIN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Person parent = person.getParent();
		Set<Person> cousins = new HashSet<>();
		if (parent != null) {
			SiblingsRelationship siblingRelationship = new SiblingsRelationship(
					parent);
			Set<Person> parentsSiblings = siblingRelationship.get()
					.getRelative().getRelativePeople();
			for (Person parentSibling : parentsSiblings) {
				cousins.addAll(parentSibling.getChildren());
			}

		}
		return getRelationBean(cousins, RelationType.COUSIN);
	}
}
