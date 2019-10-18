package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class PaternalUncleRelationship.
 * 
 * @author karthikeyan.v
 */
public class PaternalUncleRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new paternal uncle relationship.
	 *
	 * @param person
	 *            the person
	 */
	public PaternalUncleRelationship(Person person) {
		super(person, RelationType.PATERNAL_UNCLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> paternalUncles = new HashSet<>();
		if (person.getParent() != null) {
			FatherRelationship fatherRelationShip = new FatherRelationship(
					person);
			Person myFather = fatherRelationShip.get().getRelative()
					.getRelativePerson();
			BrotherRelationship brotherRelationShip = new BrotherRelationship(
					myFather);
			BrotherInLawRelationship brotherInLawRelationShip = new BrotherInLawRelationship(
					myFather);
			Set<Person> brothersOfMyFather = brotherRelationShip.get()
					.getRelative().getRelativePeople();
			Set<Person> brothersInLawOfMyFather = brotherInLawRelationShip
					.get().getRelative().getRelativePeople();
			paternalUncles.addAll(brothersOfMyFather);
			paternalUncles.addAll(brothersInLawOfMyFather);
		}
		return getRelationBean(paternalUncles, RelationType.PATERNAL_UNCLE);
	}
}
