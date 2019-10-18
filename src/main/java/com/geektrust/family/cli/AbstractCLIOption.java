package com.geektrust.family.cli;

import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;
import com.geektrust.family.util.ValidationUtils;

/**
 * The abstract class is mainly have the implementation of header
 * 
 * @author karthikeyan.v
 */
public abstract class AbstractCLIOption implements ICLIOption {

	/** The family tree. */
	protected FamilyTree familyTree;

	/** The validation utils. */
	protected ValidationUtils validationUtils;

	/**
	 * Instantiates a new abstract cli option.
	 *
	 * @param familyTree
	 *            the family tree
	 * @param cliOptionName
	 *            the cli option name
	 */
	public AbstractCLIOption(FamilyTree familyTree, String cliOptionName) {
		this.familyTree = familyTree;
		this.validationUtils = new ValidationUtils(familyTree);
		printHeader(cliOptionName);
	}

	/**
	 * Prints the header.
	 *
	 * @param cliOptionName
	 *            the cli option name
	 */
	protected void printHeader(String cliOptionName) {
		CLIUtils.clearConsole();
		System.out
				.println("********************************************************************************");
		System.out.println("                    "
				+ familyTree.getRoot().getId() + " Family");
		System.out
				.println("********************************************************************************");
		TreePrinter.printTree(familyTree.getRoot());

		System.out.println();
		System.out.println("********************** " + cliOptionName
				+ " ***********************");

	}

}
