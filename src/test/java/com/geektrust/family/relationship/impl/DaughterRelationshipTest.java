package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class DaughterRelationshipTest {

	@Test
	public void When_GettingDaugterList_Expect_ListNotContainsMaleChildren() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person drita = shanFamily.getNodeById("Vritha");
		DaughterRelationship daughterRelationship = new DaughterRelationship(
				chit);
		Set<Person> daughters = daughterRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertFalse(daughters.contains(drita));
	}

	@Test
	public void When_AddingNewFemaleChildToParent_Expect_ListContainsNewChild() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person newNode = new Person("newDaughter", Gender.FEMALE);
		shanFamily.addNewNode(newNode, "Chit");
		DaughterRelationship daughterRelationship = new DaughterRelationship(
				chit);
		Set<Person> daughters = daughterRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(daughters.contains(newNode));
	}

}
