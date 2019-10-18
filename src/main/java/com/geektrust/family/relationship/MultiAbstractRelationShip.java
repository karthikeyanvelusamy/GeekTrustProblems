package com.geektrust.family.relationship;

import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.bean.Relatives;

/**
 * This class is used when more than one person is available for the relation.
 * 
 * @author karthikeyan.v
 */
public abstract class MultiAbstractRelationShip extends AbstractRelationShip {

	/**
	 * Instantiates a new multi abstract relation ship.
	 *
	 * @param person
	 *            the person
	 * @param relationShipType
	 *            the relation ship type
	 */
	public MultiAbstractRelationShip(Person person,
			RelationType relationShipType) {
		super(person, relationShipType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.geektrust.family.relationship.AbstractRelationShip#hasRelation(com
	 * .geektrust.family.bean.Person)
	 */
	@Override
	public boolean hasRelation(Person person1) {
		Set<Person> relatives = get().getRelative().getRelativePeople();
		return relatives.contains(person1);
	}

	/**
	 * This method will set the set of relatives of the specified relation to
	 * the person.
	 *
	 * @param relativePeople
	 *            the relative people
	 * @param relationType
	 *            the relation type
	 * @return the relation bean
	 */
	public Relation getRelationBean(Set<Person> relativePeople,
			Relation.RelationType relationType) {
		Relatives relatives = new Relatives(relativePeople);
		return new Relation(person, relationType, relatives);
	}
}
