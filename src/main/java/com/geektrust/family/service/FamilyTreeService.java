package com.geektrust.family.service;

import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.exception.PersonAlreadyExistsException;
import com.geektrust.family.exception.PersonNotFoundException;
import com.geektrust.family.relationship.AbstractRelationShip;
import com.geektrust.family.relationship.RelationShipFactory;
import com.geektrust.family.tree.FamilyTree;

/**
 * This class is for the business logic of some family tree related operations.
 * 
 * @author karthikeyan.v
 */
public class FamilyTreeService {

	/** The family tree. */
	private FamilyTree familyTree;

	/** The relationship factory. */
	private RelationShipFactory relationshipFactory;

	/**
	 * Instantiates a new family tree service.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public FamilyTreeService(FamilyTree familyTree) {
		this.familyTree = familyTree;
		this.relationshipFactory = new RelationShipFactory(familyTree);
	}

	/**
	 * Adds the new member to family.
	 *
	 * @param parentId
	 *            the parent id
	 * @param child
	 *            the child
	 * @return the string
	 */
	public String addNewMemberToFamily(String parentId, Person child) {
		String message = "New child added successfully!";
		try {
			familyTree.addNewNode(child, parentId);
		} catch (PersonNotFoundException | PersonAlreadyExistsException e) {
			message = e.getMessage();
		}
		return message;
	}

	/**
	 * Gets the relatives.
	 *
	 * @param id
	 *            the id
	 * @param relationship
	 *            the relationship
	 * @return the relatives
	 */
	public Relation getRelatives(String id, String relationship) {
		AbstractRelationShip relationShipManager = relationshipFactory
				.getRelationShipManager(id, RelationType.get(relationship));
		return relationShipManager.get();
	}

	/**
	 * Gets the relation type.
	 *
	 * @param id1
	 *            the id1
	 * @param id2
	 *            the id2
	 * @return the relation type
	 */
	public RelationType getRelationType(String id1, String id2) {
		Set<AbstractRelationShip> relationShips = relationshipFactory
				.getAllAvailableRelationShips(id1);
		Person person2 = familyTree.getNodeById(id2);

		for (AbstractRelationShip relationship : relationShips) {
			if (relationship.hasRelation(person2)) {
				return relationship.getRelationType();
			}
		}
		return null;
	}

	/**
	 * Gets the all members of family.
	 *
	 * @return the all members of family
	 */
	public Set<Person> getAllMembersOfFamily() {
		Set<Person> descendants = familyTree.getAllDecentatns(familyTree
				.getRoot().getId());
		descendants.add(familyTree.getRoot());
		return descendants;
	}
}
