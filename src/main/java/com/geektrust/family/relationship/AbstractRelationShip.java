package com.geektrust.family.relationship;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;

/**
 * The Class AbstractRelationShip.
 * 
 * @author karthikeyan.v
 */
public abstract class AbstractRelationShip {

	/** The person. */
	protected Person person;

	/** The relation ship type. */
	protected RelationType relationShipType;

	/**
	 * Instantiates a new abstract relation ship.
	 *
	 * @param person
	 *            the person
	 * @param relationShipType
	 *            the relation ship type
	 */
	public AbstractRelationShip(Person person, RelationType relationShipType) {
		if (person == null) {
			throw new IllegalArgumentException("Null is not allowed here");
		}
		this.person = person;
		this.relationShipType = relationShipType;
	}

	/**
	 * Gets the relation type.
	 *
	 * @return the relation type
	 */
	public RelationType getRelationType() {
		return relationShipType;
	}

	/**
	 * Checks for relation.
	 *
	 * @param person1
	 *            the person1
	 * @return true, if successful
	 */
	public abstract boolean hasRelation(Person person1);

	/**
	 * Gets the.
	 *
	 * @return the relation
	 */
	public abstract Relation get();

}
