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

		Person saayan = shanFamily.getNodeById("Saayan");
		Person vyan = saayan.getParent().getSpouce();
		FatherRelationship fatherRelationShip = new FatherRelationship(saayan);
		Person father = fatherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(father.equals(vyan));
	}

	@Test
	public void When_DirectDenscendantOfMaleParentAndGettingFather_Expect_Parent() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person misa = shanFamily.getNodeById("Misa");
		Person saayan = misa.getParent();
		FatherRelationship fatherRelationShip = new FatherRelationship(misa);
		Person father = fatherRelationShip.get().getRelative()
				.getRelativePerson();

		Assert.assertTrue(father.equals(saayan));
	}
}
