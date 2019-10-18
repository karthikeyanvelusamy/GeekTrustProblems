package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class MaternalUncleRelationshipTest {

	@Test
	public void When_GettingMaternalUncle_Expect_ListContainsBrothersOfMother() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person satvy = shanFamily.getNodeById("Satvy");
		Person vich = shanFamily.getNodeById("Vich");
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				satvy);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(vich));
	}

	@Test
	public void When_GettingMaternalUncle_Expect_ListContainsBrotherInLawOfMother() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person jata = shanFamily.getNodeById("Jata");
		Person vrita = shanFamily.getNodeById("Vrita");
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				jata);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(vrita));
	}

	@Test
	public void When_GettingPaternalUncleList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Drita");
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				drita);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();
		Assert.assertEquals(2, maternalUncle.size());
	}

	@Test
	public void When_AddingBrotherOfMother_Expect_ChangeInPaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person satvy = shanFamily.getNodeById("Satvy");
		Person newNode = new Person("newBroToSatya", Gender.MALE);
		shanFamily.addNewNode(newNode, "King Shan");

		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(satvy);
		Set<Person> maternalUncle = maternalUncleRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(newNode));
	}

	@Test
	public void When_AddingBrotherInLaw_Expect_ChangeInPaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person kriya = shanFamily.getNodeById("Kriya");
		Person newNode = new Person("new son to satya", Gender.MALE);
		shanFamily.addNewNode(newNode, "Satya");
		
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				kriya);
		Set<Person> maternalUncle = maternalUncleRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(newNode));
	}

}
