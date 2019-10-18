package com.geektrust.family.problems;

import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.cli.AbstractCLIOption;
import com.geektrust.family.service.FamilyTreeService;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;

/**
 * This is the solution for the fourth problem.
 * 
 * @author karthikeyan.v
 */
public class KingShanFourthProblemWhosDaddy extends AbstractCLIOption {

	/**
	 * Instantiates a new king shan fourth problem whos daddy.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public KingShanFourthProblemWhosDaddy(FamilyTree familyTree) {
		super(familyTree, "Proplem 4 : Who's Daddy");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.geektrust.family.cli.ICLIOption#execute()
	 */
	@Override
	public void execute() {
		FamilyTreeService service = new FamilyTreeService(familyTree);
		do {
			String person = CLIUtils.readValue("Person");
			String relative = CLIUtils.readValue("Relative");
			if (validationUtils.isExists(person)
					&& validationUtils.isExists(relative)) {
				RelationType relation = service.getRelationType(person,
						relative);
				if (relation == null) {
					CLIUtils.printValue("Sorry no relation exists!!");
				} else {
					CLIUtils.printAnswer(relation.toString());
				}
			}
		} while (CLIUtils.shouldContinue());
	}

}
