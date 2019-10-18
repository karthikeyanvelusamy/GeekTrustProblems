package com.geektrust.family.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.tree.FamilyTree;

/**
 * The familytree initializer class will load the initial data.
 * 
 * @author karthikeyan.v
 */
public class FamilyTreeInitializer {

	/** The family trees. */
	private Map<String, FamilyTree> familyTrees = new HashMap<>();

	/**
	 * Inits the.
	 */
	public void init() {
		Person kingShan = new Person("King Shan", Gender.MALE);
		new Person("Queen Anga", Gender.FEMALE, null, kingShan);

		FamilyTree shanFamilyTree = new FamilyTree(kingShan);

		try {
			InputStream in = this.getClass().getResourceAsStream(
					"ShanFamilyChildren");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String personName = data[0];
				Gender gender = Gender.valueOf(data[1]);
				String parentId = data[2];
				Person descendant = new Person(personName, gender);
				if (data.length > 3) {
					String spouceName = data[3];
					Gender spouceGender = Gender.valueOf(data[4]);
					new Person(spouceName, spouceGender, null, descendant);
				}
				shanFamilyTree.addNewNode(descendant, parentId);
			}
		} catch (Exception e) {
			System.out.println("Error occured while building the family tree,"
					+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		familyTrees.put("King Shan", shanFamilyTree);

	}

	/**
	 * Gets the family tree.
	 *
	 * @param id
	 *            the id
	 * @return the family tree
	 */
	public FamilyTree getFamilyTree(String id) {
		return familyTrees.get(id);
	}

}
