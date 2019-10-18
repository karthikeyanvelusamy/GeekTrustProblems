package com.geektrust.family.problems;

import com.geektrust.family.bean.Relation;
import com.geektrust.family.cli.AbstractCLIOption;
import com.geektrust.family.exception.UnsupportedRelation;
import com.geektrust.family.service.FamilyTreeService;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;

/**
 * This is the solution for the first problem.
 * 
 * @author karthikeyan.v
 * 
 */
public class KingShanFirstProblemMeetFamily extends AbstractCLIOption {

	/**
	 * Instantiates a new king shan first problem meet family.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public KingShanFirstProblemMeetFamily(FamilyTree familyTree) {
		super(familyTree, "Proplem 1 : Meet the family");
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
			if (validationUtils.isExists(person)) {
				String relation = CLIUtils.readValue("Relation").toLowerCase();
				if (validationUtils.isValidRelation(relation)) {
					try {
						Relation relations = service.getRelatives(person,
								relation);
						CLIUtils.printAnswer(relations);
					} catch (UnsupportedRelation e) {
						CLIUtils.printValue("Unsupported relation!!! please retry.");
					}
				}
			}
		} while (CLIUtils.shouldContinue());
	}
}
