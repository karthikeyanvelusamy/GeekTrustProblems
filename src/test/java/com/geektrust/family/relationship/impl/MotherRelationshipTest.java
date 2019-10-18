package com.geektrust.family.relationship.impl;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class MotherRelationshipTest {

	@Test
	public void When_DirectDenscendantOfMaleParentAndGettingMother_Expect_SpouceOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person queenAnga = chit.getParent().getSpouce();
		MotherRelationship motherRelationShip = new MotherRelationship(chit);
		Person mother = motherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(mother.equals(queenAnga));
	}

	@Test
	public void When_DirectDenscendantOfFemaleParentAndGettingMother_Expect_Parent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person savya = shanFamily.getNodeById("Savya");
		Person satya = savya.getParent();
		MotherRelationship motherRelationShip = new MotherRelationship(savya);
		Person mother = motherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(mother.equals(satya));
	}
}
