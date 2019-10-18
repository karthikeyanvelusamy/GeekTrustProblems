package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class BrotherRelationshipTest {

	@Test
	public void When_GettingBrotherList_Expect_ListNotContainsFemaleChildrenOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person satya = shanFamily.getNodeById("Satya");
		BrotherRelationship broRelationship = new BrotherRelationship(chit);
		Set<Person> bros = broRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertFalse(bros.contains(satya));
	}

	@Test
	public void When_AddingNewMaleChildToParent_Expect_ListContainsNewChildrenOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person satvy = shanFamily.getNodeById("Satvy");
		Person newNode = new Person("newBro", Gender.MALE);
		shanFamily.addNewNode(newNode, "Satya");
		BrotherRelationship broRelationship = new BrotherRelationship(satvy);
		Set<Person> bros = broRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(bros.contains(newNode));
	}

	@Test
	public void When_GettingBrotherList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person satvy = shanFamily.getNodeById("Satvy");
		BrotherRelationship broRelationship = new BrotherRelationship(satvy);
		Set<Person> bros = broRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertEquals(2, bros.size());
	}
}
