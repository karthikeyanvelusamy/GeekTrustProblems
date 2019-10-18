package com.geektrust.family.cli;

import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;
import com.geektrust.family.util.CLIUtils;

/**
 * This is the driver class for this application.
 * 
 * @author karthikeyan.v
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		FamilyTreeInitializer initializer = new FamilyTreeInitializer();
		initializer.init();
		FamilyTree kingShanFamily = initializer.getFamilyTree("King Shan");
		CLIOptionFactory factory = new CLIOptionFactory(kingShanFamily);
		String problemNo;
		do {
			problemNo = CLIUtils.homeMenu();
			ICLIOption problem = factory.getCLIOptionImpl(problemNo);
			if (problem != null) {
				problem.execute();
			}
		} while (!"0".equals(problemNo));

	}
}
