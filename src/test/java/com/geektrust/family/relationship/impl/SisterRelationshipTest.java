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

		Person chit = shanFamily.getNodeById("Chit");
		Person vich = shanFamily.getNodeById("Vich");
		SisterRelationship sisRelationship = new SisterRelationship(chit);
		Set<Person> sis = sisRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertFalse(sis.contains(vich));
	}

	@Test
	public void When_AddingNewFemaleChildToParent_Expect_ListContainsNewChildrenOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person lavnya = shanFamily.getNodeById("Lavnya");
		Person newNode = new Person("newSis", Gender.FEMALE);
		shanFamily.addNewNode(newNode, "Vila");
		SisterRelationship sisRelationship = new SisterRelationship(lavnya);
		Set<Person> sis = sisRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(sis.contains(newNode));
	}
	
	
}
