package com.geektrust.family.cli;

import com.geektrust.family.problems.KingShanFirstProblemMeetFamily;
import com.geektrust.family.problems.KingShanFourthProblemWhosDaddy;
import com.geektrust.family.problems.KingShanSecondProblemNewBorn;
import com.geektrust.family.problems.KingShanThirdProblemGirlChild;
import com.geektrust.family.problems.KingShanFifthProblemGen;
import com.geektrust.family.tree.FamilyTree;

/**
 * A factory for creating CLIOption objects.
 *
 * @author karthikeyan.v
 */
public class CLIOptionFactory {

	/** The family tree. */
	private FamilyTree familyTree;

	/**
	 * Instantiates a new CLI option factory.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public CLIOptionFactory(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}

	/**
	 * Gets the CLI option impl.
	 *
	 * @param option
	 *            the option
	 * @return the CLI option impl
	 */
	public ICLIOption getCLIOptionImpl(String option) {

		ICLIOption cliOption = null;
		switch (option) {
		case "1":
			cliOption = new KingShanFirstProblemMeetFamily(familyTree);
			break;
		case "2":
			cliOption = new KingShanSecondProblemNewBorn(familyTree);
			break;
		case "3":
			cliOption = new KingShanThirdProblemGirlChild(familyTree);
			break;
		case "4":
			cliOption = new KingShanFourthProblemWhosDaddy(familyTree);
			break;
			case "5":
			cliOption = new KingShanFifthProblemGen(familyTree);
			break;
		default:
			cliOption = null;
		}
		return cliOption;
	}
}
