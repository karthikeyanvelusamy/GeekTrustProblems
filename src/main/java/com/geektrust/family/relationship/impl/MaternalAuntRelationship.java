package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class MaternalAuntRelationship.
 * 
 * @author karthikeyan.v
 */
public class MaternalAuntRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new maternal aunt relationship.
	 *
	 * @param person
	 *            the person
	 */
	public MaternalAuntRelationship(Person person) {
		super(person, RelationType.MATERNAL_AUNT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> maternalAunt = new HashSet<>();
		if (person.getParent() != null) {
			MotherRelationship motherRelationShip = new MotherRelationship(
					person);
			Person myMother = motherRelationShip.get().getRelative()
					.getRelativePerson();
			SisterRelationship sisterRelationShip = new SisterRelationship(
					myMother);
			SisterInLawRelationship sisterInLawRelationship = new SisterInLawRelationship(
					myMother);
			Set<Person> sistersOfMyMother = sisterRelationShip.get()
					.getRelative().getRelativePeople();
			Set<Person> sisterInLawOfMyMother = sisterInLawRelationship.get()
					.getRelative().getRelativePeople();
			maternalAunt.addAll(sistersOfMyMother);
			maternalAunt.addAll(sisterInLawOfMyMother);
		}
		return getRelationBean(maternalAunt, RelationType.MATERNAL_AUNT);
	}
}
