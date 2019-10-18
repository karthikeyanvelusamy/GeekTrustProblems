package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class SonRelationshipTest {

	@Test
	public void When_GettingSonList_Expect_ListNotContainsFemaleChildren() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person Tritha = shanFamily.getNodeById("Tritha");
		SonRelationship sonsRelationship = new SonRelationship(chit);
		Set<Person> sons = sonsRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertFalse(sons.contains(Tritha));
	}

	@Test
	public void When_AddingNewMaleChildToParent_Expect_ListContainsNewChild() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person newNode = new Person("newSon", Gender.MALE);
		shanFamily.addNewNode(newNode, "Chit");
		SonRelationship sonsRelationship = new SonRelationship(chit);
		Set<Person> sons = sonsRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(sons.contains(newNode));
	}

}
