package com.geektrust.family.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.bean.Relation;

/**
 * This util class is for the CLI functions.
 *
 * @author karthikeyan.v
 */
public class CLIUtils {

	private CLIUtils() {

	}

	/** The scanner. */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Read value.
	 *
	 * @param key
	 *            the key
	 * @return the string
	 */
	public static String readValue(String key) {
		System.out.print("Enter " + key + " : ");
		return scanner.nextLine();
	}

	/**
	 * Prints the value.
	 *
	 * @param value
	 *            the value
	 */
	public static void printValue(String value) {
		System.out.println(value);
	}

	/**
	 * Prints the answer.
	 *
	 * @param relation
	 *            the relation
	 */
	public static void printAnswer(Relation relation) {
		Set<Person> relatives = relation.getRelative().getRelativePeople();
		Person p = relation.getRelative().getRelativePerson();
		if (p != null) {
			relatives = new HashSet<>();
			relatives.add(p);
		}

		printAnswer(relatives);

	}

	/**
	 * Prints the answer.
	 *
	 * @param data
	 *            the data
	 */
	public static void printAnswer(Set<Person> data) {
		String value = data.stream().map(per -> per.getId())
				.collect(Collectors.joining(","));
		printAnswer(value);

	}

	/**
	 * Prints the answer.
	 *
	 * @param value
	 *            the value
	 */
	public static void printAnswer(String value) {
		printValue("\n   Answer :" + value);
	}

	/**
	 * Should continue.
	 *
	 * @return true, if successful
	 */
	public static boolean shouldContinue() {
		System.out.println("\n        Do u want to repeat (N/Y) ?");
		return scanner.nextLine().equalsIgnoreCase("Y");
	}

	/**
	 * Input for new child.
	 *
	 * @return the map
	 */
	public static Map<String, String> inputForNewChild() {
		String mother = CLIUtils.readValue("MotherName/FatherName");
		String genderInput = CLIUtils.readValue("Is it Boy or Girl (M/F)?");
		Gender childGender = genderInput.equalsIgnoreCase("M") ? Gender.MALE
				: Gender.FEMALE;
		String inputStr = childGender.equals(Gender.MALE) ? "Son" : "Daughter";
		String childName = CLIUtils.readValue(inputStr + " Name :");

		final Map<String, String> inputs = new HashMap<>();
		inputs.put("MotherName/FatherName", mother);
		inputs.put("Gender", childGender.toString());
		inputs.put("ChildName", childName);

		return inputs;
	}

	/**
	 * Home menu.
	 *
	 * @return the string
	 */
	public static String homeMenu() {

		clearConsole();

		System.out
				.println("********************************** Main Menu ***********************");
		System.out.println("Problem 1 : Meet the family");
		System.out.println("Problem 2 : New Born");
		System.out.println("Problem 3 : Girl Child");
		System.out.println("Problem 4 : Who's your daddy");

		System.out.println("To Exit enter 0");
		System.out
				.println("********************************************************************");
		return CLIUtils.readValue("Select any problem by entering the NO : ");

	}

	/**
	 * Clear console.
	 */
	public static void clearConsole() {
		final String os = System.getProperty("os.name");
		if (os.contains("Linux")) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
	}

	/**
	 * Prints the bye.
	 */
	public static void printBye() {
		System.out.println("Bye!");
	}

	/**
	 * Prints the error.
	 */
	public static void printError() {
		System.out.println("Something went wrong!!");
	}
}
