package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class SisterRelationshipTest {

	@Test
	public void When_GettingSistersList_Expect_ListNotContainsMaleChildrenOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person dritha = shanFamily.getNodeById("Dritha");
		Person vritha = shanFamily.getNodeById("Vritha");
		SisterRelationship sisRelationship = new SisterRelationship(dritha);
		Set<Person> sis = sisRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertFalse(sis.contains(vritha));
	}

	@Test
	public void When_AddingNewFemaleChildToParent_Expect_ListContainsNewChildrenOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person vritha = shanFamily.getNodeById("Vritha");
		Person newNode = new Person("newSis", Gender.FEMALE);
		shanFamily.addNewNode(newNode, "Chit");
		SisterRelationship sisRelationship = new SisterRelationship(vritha);
		Set<Person> sis = sisRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(sis.contains(newNode));
	}


}
