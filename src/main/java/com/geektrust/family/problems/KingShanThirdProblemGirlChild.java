package com.geektrust.family.problems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.cli.AbstractCLIOption;
import com.geektrust.family.relationship.impl.DaughterRelationship;
import com.geektrust.family.service.FamilyTreeService;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;

/**
 * This is the solution for the third problem.
 * 
 * @author karthikeyan.v
 */
public class KingShanThirdProblemGirlChild extends AbstractCLIOption {

	/**
	 * Instantiates a new king shan third problem girl child.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public KingShanThirdProblemGirlChild(FamilyTree familyTree) {
		super(familyTree, "Proplem 3 : The Girl Child");
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
			// Getting all mothers
			final Set<Person> allMembers = service.getAllMembersOfFamily();

			// Filtering only highest girl child holding mothers
			Set<Person> mothers = getMothersWithMostGirlChild(allMembers);

			CLIUtils.printValue("Following are the mothers who has most number of girl child.");
			CLIUtils.printAnswer(mothers);

			// Adding new child
			CLIUtils.printValue("\nAdding new child");
			final Map<String, String> inputs = CLIUtils.inputForNewChild();
			final String motherName = inputs.get("MotherName/FatherName");
			final Gender gender = Gender.valueOf(inputs.get("Gender"));
			final String childName = inputs.get("ChildName");
			if (validationUtils.isExists(motherName)
					&& validationUtils.isAvailableToBeTaken(childName)) {
				Person child = new Person(childName, gender);
				String message = service
						.addNewMemberToFamily(motherName, child);
				CLIUtils.printValue(message);
			}

		} while (CLIUtils.shouldContinue());
	}

	/**
	 * Gets the mothers with most girl child.
	 *
	 * @param allMembers
	 *            the all members
	 * @return the mothers with most girl child
	 */
	private Set<Person> getMothersWithMostGirlChild(Set<Person> allMembers) {
		int max = 0;
		Set<Person> mothers = new HashSet<>();
		for (Person person : allMembers) {
			if (person.isMarried()) {
				DaughterRelationship daughter = new DaughterRelationship(person);
				int girlChildCount = daughter.get().getRelative()
						.getRelativePeople().size();
				Person mother = person.getGender().equals(Gender.FEMALE) ? person
						: person.getSpouce();
				if (girlChildCount > max) {
					max = girlChildCount;
					mothers.clear();
					mothers.add(mother);
				} else if (max == girlChildCount) {
					mothers.add(mother);
				}
			}
		}
		return mothers;
	}
}
