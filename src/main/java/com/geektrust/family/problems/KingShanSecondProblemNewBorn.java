package com.geektrust.family.problems;

import java.util.Map;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.bean.Relation;
import com.geektrust.family.cli.AbstractCLIOption;
import com.geektrust.family.cli.TreePrinter;
import com.geektrust.family.service.FamilyTreeService;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;

/**
 * This is the solution for the second problem.
 * 
 * @author karthikeyan.v
 */
public class KingShanSecondProblemNewBorn extends AbstractCLIOption {

	/**
	 * Instantiates a new king shan second problem new born.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public KingShanSecondProblemNewBorn(FamilyTree familyTree) {
		super(familyTree, "Proplem 2 : A New Born");
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
			/*
			 * Reading input for new child
			 */
			final Map<String, String> inputs = CLIUtils.inputForNewChild();
			final String parentName = inputs.get("MotherName/FatherName");
			final Gender gender = Gender.valueOf(inputs.get("Gender"));
			final String childName = inputs.get("ChildName");
			if (isValidInput(parentName, childName)) {
				Person child = new Person(childName, gender);
				String message = service
						.addNewMemberToFamily(parentName, child);

				CLIUtils.printValue("\n" + message);
				// Printing refreshed tree
				CLIUtils.printValue("The refreshed tree\n");
				TreePrinter.printTree(familyTree.getRoot());

				// Getting the relation details after the new addition to the
				// tree
				CLIUtils.printValue("-->Check any relation details\n");
				String person = CLIUtils.readValue("Person");
				String relation = CLIUtils.readValue("Relation").toLowerCase();
				if (validationUtils.isExists(person)
						&& validationUtils.isValidRelation(relation)) {
					Relation relations = service.getRelatives(person, relation);
					CLIUtils.printAnswer(relations);
				}
			}

		} while (CLIUtils.shouldContinue());
	}

	private boolean isValidInput(String parentName, String childName) {
		return validationUtils.isExists(parentName)
				&& validationUtils.isMarried(parentName)
				&& validationUtils.isAvailableToBeTaken(childName);
	}
}
