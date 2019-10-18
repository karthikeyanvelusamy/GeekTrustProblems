package com.geektrust.family.relationship;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.bean.Relatives;

/**
 * This class is used when one person is available for the relation.
 * 
 * @author karthikeyan.v
 */
public abstract class SingleAbstractRelation extends AbstractRelationShip {

	/**
	 * Instantiates a new single abstract relation.
	 *
	 * @param person
	 *            the person
	 * @param relationShipType
	 *            the relation ship type
	 */
	public SingleAbstractRelation(Person person, RelationType relationShipType) {
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
		Person relative = get().getRelative().getRelativePerson();
		if (relative == null) {
			return false;
		}
		return person1.equals(relative);
	}

	/**
	 * This method will set the relative of the specified relation to the
	 * person.
	 *
	 * @param relativePerson
	 *            the relative person
	 * @param relationType
	 *            the relation type
	 * @return the relation bean
	 */
	public Relation getRelationBean(Person relativePerson,
			Relation.RelationType relationType) {
		Relatives relatives = new Relatives(relativePerson);
		return new Relation(person, relationType, relatives);
	}
}
