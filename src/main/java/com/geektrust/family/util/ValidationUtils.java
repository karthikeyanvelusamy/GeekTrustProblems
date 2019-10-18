package com.geektrust.family.util;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.tree.FamilyTree;

/**
 * The Class ValidationUtils.
 */
public class ValidationUtils {

	/**
	 * Instantiates a new validation utils.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public ValidationUtils(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}

	/** The family tree. */
	public FamilyTree familyTree;

	/**
	 * Checks if is available to be taken.
	 *
	 * @param id
	 *            the id
	 * @return true, if is available to be taken
	 */
	public boolean isAvailableToBeTaken(String id) {
		if (familyTree.isExists(id)) {
			CLIUtils.printValue("Already another one with that name, reconsider the name again!!");
			return false;
		}
		return true;
	}

	/**
	 * Checks if is exists.
	 *
	 * @param id
	 *            the id
	 * @return true, if is exists
	 */
	public boolean isExists(String id) {
		if (!familyTree.isExists(id)) {
			CLIUtils.printValue("No node found with that name!!");
			return false;
		}
		return true;
	}

	/**
	 * Checks if is valid relation.
	 *
	 * @param relation
	 *            the relation
	 * @return true, if is valid relation
	 */
	public boolean isValidRelation(String relation) {
		if (RelationType.get(relation) == null) {
			CLIUtils.printValue("No relation found with that given input!!");
			return false;
		}
		return true;
	}

	public boolean isMarried(String id) {
		Person node = familyTree.getNodeById(id);

		if (node != null) {
			if (node.isMarried()) {
				return true;
			}
			System.out.println(id + " is not married!!");
		} else {
			System.out.println("No node found for the given id");
		}
		return false;
	}
}
