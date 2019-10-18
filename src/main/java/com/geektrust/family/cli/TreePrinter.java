package com.geektrust.family.cli;

import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.util.CLIUtils;

/**
 * This class will print the family tree in tree format.
 * 
 * @author karthikeyan.v
 */
public class TreePrinter {

	/**
	 * Instantiates a new tree printer.
	 */
	private TreePrinter() {

	}

	/**
	 * Prints the tree.
	 *
	 * @param root
	 *            the root
	 */
	public static void printTree(Person root) {
		printTree(root, "", false);
	}

	/**
	 * Prints the tree.
	 *
	 * @param person
	 *            the person
	 * @param indent
	 *            the indent
	 * @param last
	 *            the last
	 */
	private static void printTree(Person person, String indent, boolean last) {
		String spouceName = (person.isMarried()) ? " * "
				+ person.getSpouce().toString() : "";
		CLIUtils.printValue(indent + "+- " + person + spouceName);
		indent += last ? "        " : "|     ";
		Set<Person> children = person.getChildren();
		if (children.isEmpty() && person.isMarried()) {
			children = person.getSpouce().getChildren();
		}
		int size = children.size();
		int i = 0;
		for (Person child : children) {
			printTree(child, indent, i == size - 1);
			i++;
		}
	}
}
