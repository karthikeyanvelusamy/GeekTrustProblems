package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class PaternalAuntRelationshipTest {

	@Test
	public void When_GettingPaternalAunt_Expect_ListContainsSistersOfFather() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Drita");
		Person satya = shanFamily.getNodeById("Satya");
		PaternalAuntRelationship paternalAuntRelation = new PaternalAuntRelationship(
				drita);
		Set<Person> paternalAunt = paternalAuntRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalAunt.contains(satya));
	}

	@Test
	public void When_GettingPaternalAunt_Expect_ListContainsSistersInLawOfFather() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Drita");
		Person lika = shanFamily.getNodeById("Lika");
		PaternalAuntRelationship paternalAuntRelation = new PaternalAuntRelationship(
				drita);
		Set<Person> paternalAunt = paternalAuntRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalAunt.contains(lika));
	}

	@Test
	public void When_GettingPaternalAuntList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Drita");
		PaternalAuntRelationship paternalAuntRelation = new PaternalAuntRelationship(
				drita);
		Set<Person> paternalAunt = paternalAuntRelation.get().getRelative()
				.getRelativePeople();
		Assert.assertEquals(2, paternalAunt.size());
	}

	@Test
	public void When_AddingSistersOfFather_Expect_ChangeInPaternalAuntList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person kriya = shanFamily.getNodeById("Kriya");
		Person newNode = new Person("newSisToSavya", Gender.FEMALE);
		shanFamily.addNewNode(newNode, "Satya");

		PaternalAuntRelationship paternalAuntRelation = new PaternalAuntRelationship(
				kriya);
		Set<Person> paternalAunt = paternalAuntRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalAunt.contains(newNode));
	}

	@Test
	public void When_AddingSisterInLaw_Expect_ChangeInPaternalAuntList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Drita");
		Person ish = shanFamily.getNodeById("Ish");
		Person newWifeToIsh = new Person("wife to ish", Gender.FEMALE);
		ish.setSpouce(newWifeToIsh);
		newWifeToIsh.setSpouce(ish);

		PaternalAuntRelationship paternalAuntRelation = new PaternalAuntRelationship(
				drita);
		Set<Person> paternalAunt = paternalAuntRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalAunt.contains(newWifeToIsh));
	}

}
