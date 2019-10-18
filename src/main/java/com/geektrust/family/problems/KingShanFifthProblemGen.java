package com.geektrust.family.problems;

import com.geektrust.family.bean.Relation.RelationType;
import com.geektrust.family.cli.AbstractCLIOption;
import com.geektrust.family.service.FamilyTreeService;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;
import java.util.Map;
import java.util.HashMap;


/**
 * This is the solution for the fourth problem.
 *
 * @author karthikeyan.v
 */
public class KingShanFifthProblemGen extends AbstractCLIOption {

	/**
	 * Instantiates a new king shan fourth problem whos daddy.
	 *
	 * @param familyTree
	 *            the family tree
	 */
	public KingShanFifthProblemGen(FamilyTree familyTree) {
		super(familyTree, "Proplem 5 :Gen");


	}
	private static String CONSTANT_OLD = "OLD";
	private static String CONSTANT_SAME = "SAME";

	private static Map<String,String> relationGenMap  =  new HashMap<>();

static{
	init();
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
					CLIUtils.printAnswer(relation.toString() + " -  " + relationGenMap.get(relation.toString().toLowerCase()) + " Generation");
				}
			}
		} while (CLIUtils.shouldContinue());
	}


	private static void init(){
		relationGenMap.put("son",CONSTANT_OLD);
		relationGenMap.put("sister",CONSTANT_SAME);
		relationGenMap.put("sister in law",CONSTANT_SAME);
		relationGenMap.put("siblings",CONSTANT_SAME);
		relationGenMap.put("paternal uncle",CONSTANT_OLD);
		relationGenMap.put("paternal aunt",CONSTANT_OLD);
		relationGenMap.put("mother",CONSTANT_OLD);
		relationGenMap.put("maternal uncle",CONSTANT_OLD);
		relationGenMap.put("maternal aunt",CONSTANT_OLD);
		relationGenMap.put("grand son",CONSTANT_OLD);
		relationGenMap.put("grand daughter",CONSTANT_OLD);
		relationGenMap.put("grand_children",CONSTANT_OLD);
		relationGenMap.put("father",CONSTANT_OLD);
		relationGenMap.put("daughter",CONSTANT_OLD);
		relationGenMap.put("cousin",CONSTANT_SAME);
		relationGenMap.put("children",CONSTANT_OLD);
		relationGenMap.put("brother",CONSTANT_SAME);
		relationGenMap.put("brother in law",CONSTANT_SAME);
	}

}
