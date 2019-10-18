package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class CousinsRelationshipTest {

	@Test
	public void When_GettingCousinsList_Expect_ListContainsAllChildrenOfParentsSibling() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person vila = shanFamily.getNodeById("Vila");
		Person chit = shanFamily.getNodeById("Chit");
		CousinRelationship cousinsRelationShip = new CousinRelationship(vila);
		Set<Person> cousins = cousinsRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(cousins.containsAll(chit.getChildren()));
	}

	@Test
	public void When_AddingChildToParentsSiblings_Expect_NewlyAddedAvaialbeInList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person vila = shanFamily.getNodeById("Vila");
		Person newChild = new Person("newChildTest", Gender.FEMALE);
		shanFamily.addNewNode(newChild, "Chit");
		CousinRelationship cousinsRelationShip = new CousinRelationship(vila);
		Set<Person> cousins = cousinsRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(cousins.contains(newChild));
	}

}
