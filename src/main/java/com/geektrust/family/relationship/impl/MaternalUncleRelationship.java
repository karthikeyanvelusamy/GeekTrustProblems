package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class MaternalUncleRelationship.
 * 
 * @author karthikeyan.v
 */
public class MaternalUncleRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new maternal uncle relationship.
	 *
	 * @param person
	 *            the person
	 */
	public MaternalUncleRelationship(Person person) {
		super(person, RelationType.MATERNAL_UNCLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> maternalUncles = new HashSet<>();
		if (person.getParent() != null) {
			MotherRelationship motherRelationShip = new MotherRelationship(
					person);
			Person myMother = motherRelationShip.get().getRelative()
					.getRelativePerson();
			BrotherRelationship brotherRelationShip = new BrotherRelationship(
					myMother);
			BrotherInLawRelationship brotherInLawRelationShip = new BrotherInLawRelationship(
					myMother);
			Set<Person> brothersOfMyMother = brotherRelationShip.get()
					.getRelative().getRelativePeople();
			Set<Person> brothersInLawOfMyMother = brotherInLawRelationShip
					.get().getRelative().getRelativePeople();
			maternalUncles.addAll(brothersOfMyMother);
			maternalUncles.addAll(brothersInLawOfMyMother);
		}
		return getRelationBean(maternalUncles, RelationType.MATERNAL_UNCLE);
	}
}
