package com.geektrust.family.relationship;

import java.util.HashSet;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.relationship.impl.BrotherInLawRelationship;
import com.geektrust.family.relationship.impl.BrotherRelationship;
import com.geektrust.family.relationship.impl.ChildrenRelationship;
import com.geektrust.family.relationship.impl.CousinRelationship;
import com.geektrust.family.relationship.impl.DaughterRelationship;
import com.geektrust.family.relationship.impl.FatherRelationship;
import com.geektrust.family.relationship.impl.GrandChildrenRelationship;
import com.geektrust.family.relationship.impl.GrandDaughterRelationShip;
import com.geektrust.family.relationship.impl.GrandSonRelationShip;
import com.geektrust.family.relationship.impl.MaternalAuntRelationship;
import com.geektrust.family.relationship.impl.MaternalUncleRelationship;
import com.geektrust.family.relationship.impl.MotherRelationship;
import com.geektrust.family.relationship.impl.PaternalAuntRelationship;
import com.geektrust.family.relationship.impl.PaternalUncleRelationship;
import com.geektrust.family.relationship.impl.SiblingsRelationship;
import com.geektrust.family.relationship.impl.SisterInLawRelationship;
import com.geektrust.family.relationship.impl.SisterRelationship;
import com.geektrust.family.relationship.impl.SonRelationship;
import com.geektrust.family.tree.FamilyTree;

/**
 * A factory for creating RelationShip objects.
 *
 * @author karthikeyan.v
 */
public class RelationShipFactory {

	/** The family tree. */
	private FamilyTree familyTree;





	/**
	 * Instantiates a new relation ship factory.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public RelationShipFactory(FamilyTree familyTree) {
		if (familyTree == null) {
			throw new IllegalArgumentException("Null is not allowed here");
		}
		this.familyTree = familyTree;
	}

	/**
	 * Gets the relation ship manager.
	 *
	 * @param id
	 *            the id
	 * @param relationshipType
	 *            the relationship type
	 * @return the relation ship manager
	 */
	public AbstractRelationShip getRelationShipManager(String id,
			RelationType relationshipType) {
		AbstractRelationShip relationShip;
		Person person = familyTree.getNodeById(id);
		switch (relationshipType) {
		case FATHER:
			relationShip = new FatherRelationship(person);
			break;
		case MOTHER:
			relationShip = new MotherRelationship(person);
			break;
		case CHILDREN:
			relationShip = new ChildrenRelationship(person);
			break;
		case SON:
			relationShip = new SonRelationship(person);
			break;
		case DAUGHTER:
			relationShip = new DaughterRelationship(person);
			break;
		case COUSIN:
			relationShip = new CousinRelationship(person);
			break;
		case BROTHER:
			relationShip = new BrotherRelationship(person);
			break;
		case SISTER:
			relationShip = new SisterRelationship(person);
			break;
		case BROTHER_IN_LAW:
			relationShip = new BrotherInLawRelationship(person);
			break;
		case SISTER_IN_LAW:
			relationShip = new SisterInLawRelationship(person);
			break;
		case PATERNAL_UNCLE:
			relationShip = new PaternalUncleRelationship(person);
			break;
		case PATERNAL_AUNT:
			relationShip = new PaternalAuntRelationship(person);
			break;
		case MATERNAL_UNCLE:
			relationShip = new MaternalUncleRelationship(person);
			break;
		case MATERNAL_AUNT:
			relationShip = new MaternalAuntRelationship(person);
			break;
		case GRAND_DAUGHTER:
			relationShip = new GrandDaughterRelationShip(person);
			break;
		case SIBLINGS:
			relationShip = new SiblingsRelationship(person);
			break;
		case GRAND_CHILDREN:
			relationShip = new GrandChildrenRelationship(person);
			break;
		case GRAND_SON:
			relationShip = new GrandSonRelationShip(person);
			break;
		default:
			relationShip = null;
			break;
		}
		return relationShip;
	}

	/**
	 * Gets the all available relation ships.
	 *
	 * @param id
	 *            the id
	 * @return the all available relation ships
	 */
	public Set<AbstractRelationShip> getAllAvailableRelationShips(String id) {
		Set<AbstractRelationShip> availableRelationships = new HashSet<>();
		for (RelationType r : RelationType.values()) {
			if (!r.equals(RelationType.CHILDREN)
					&& !r.equals(RelationType.SIBLINGS))
				availableRelationships.add(getRelationShipManager(id, r));
		}
		return availableRelationships;

	}




}
