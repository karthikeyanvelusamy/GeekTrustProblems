package com.geektrust.family.relationship.impl;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.MultiAbstractRelationShip;

/**
 * The Class PaternalAuntRelationship.
 * 
 * @author karthikeyan.v
 */
public class PaternalAuntRelationship extends MultiAbstractRelationShip {

	/**
	 * Instantiates a new paternal aunt relationship.
	 *
	 * @param person
	 *            the person
	 */
	public PaternalAuntRelationship(Person person) {
		super(person, RelationType.PATERNAL_AUNT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.relationship.AbstractRelationShip#get()
	 */
	@Override
	public Relation get() {
		Set<Person> paternalAunt = new HashSet<>();
		if (person.getParent() != null) {
			FatherRelationship fatherRelationShip = new FatherRelationship(
					person);
			Person myFather = fatherRelationShip.get().getRelative()
					.getRelativePerson();
			SisterRelationship sisterRelationShip = new SisterRelationship(
					myFather);
			SisterInLawRelationship sisterInLawRelationship = new SisterInLawRelationship(
					myFather);
			Set<Person> sisterOfMyFather = sisterRelationShip.get()
					.getRelative().getRelativePeople();
			Set<Person> sisterInLawOfMyFather = sisterInLawRelationship.get()
					.getRelative().getRelativePeople();
			paternalAunt.addAll(sisterOfMyFather);
			paternalAunt.addAll(sisterInLawOfMyFather);
		}
		return getRelationBean(paternalAunt, RelationType.PATERNAL_AUNT);
	}
}
