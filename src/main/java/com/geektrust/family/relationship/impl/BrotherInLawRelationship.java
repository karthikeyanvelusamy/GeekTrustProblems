package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class BrotherInLawRelationship.
 * 
 * @author karthikeyan.v
 */
public class BrotherInLawRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new brother in law relationship.
	 *
	 * @param person
	 *            the person
	 */
	public BrotherInLawRelationship(Person person) {
		super(person, RelationType.BROTHER_IN_LAW);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Person mySpouce = person.getSpouce();
		Set<Person> myBrothersInLaw = new HashSet<>();
		if (mySpouce != null) {
			BrotherRelationship brotherRelationShip = new BrotherRelationship(
					mySpouce);
			Set<Person> brothersOfMySpouce = brotherRelationShip.get()
					.getRelative().getRelativePeople();
			myBrothersInLaw.addAll(brothersOfMySpouce);
		}
		SisterRelationship sisterRelationship = new SisterRelationship(person);
		Set<Person> mySisters = sisterRelationship.get().getRelative()
				.getRelativePeople();
		for (Person mySister : mySisters) {
			if (mySister.isMarried())
				myBrothersInLaw.add(mySister.getSpouce());
		}
		return getRelationBean(myBrothersInLaw, RelationType.BROTHER_IN_LAW);
	}
}
