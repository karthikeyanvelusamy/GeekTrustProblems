package com.geektrust.family.relationship.impl;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class FatherRelationshipTest {

	@Test
	public void When_DirectDenscendantOfFemaleParentAndGettingFather_Expect_SpouceOfParent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person jaya = shanFamily.getNodeById("Jaya");
		FatherRelationship fatherRelationShip = new FatherRelationship(yodhan);
		Person father = fatherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(father.equals(jaya));
	}

	@Test
	public void When_DirectDenscendantOfMaleParentAndGettingFather_Expect_Parent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person vila = shanFamily.getNodeById("Vila");
		Person chit = vila.getParent();
		FatherRelationship fatherRelationShip = new FatherRelationship(vila);
		Person father = fatherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(father.equals(chit));
	}
}
