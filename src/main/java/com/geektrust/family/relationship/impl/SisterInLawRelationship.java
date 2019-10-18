package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class SisterInLawRelationship.
 * 
 * @author karthikeyan.v
 */
public class SisterInLawRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new sister in law relationship.
	 *
	 * @param person
	 *            the person
	 */
	public SisterInLawRelationship(Person person) {
		super(person, RelationType.SISTER_IN_LAW);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> mySistersInLaw = new HashSet<>();
		if (person.isMarried()) {
			Person mySpouce = person.getSpouce();
			SisterRelationship sisterRelationShip = new SisterRelationship(
					mySpouce);
			Set<Person> sistersOfMySpouce = sisterRelationShip.get()
					.getRelative().getRelativePeople();
			mySistersInLaw.addAll(sistersOfMySpouce);
		}

		BrotherRelationship brotherRelationShip = new BrotherRelationship(
				person);
		Set<Person> myBrothers = brotherRelationShip.get().getRelative()
				.getRelativePeople();
		for (Person myBrother : myBrothers) {
			if (myBrother.isMarried())
				mySistersInLaw.add(myBrother.getSpouce());
		}

		return getRelationBean(mySistersInLaw, RelationType.SISTER_IN_LAW);
	}
}
