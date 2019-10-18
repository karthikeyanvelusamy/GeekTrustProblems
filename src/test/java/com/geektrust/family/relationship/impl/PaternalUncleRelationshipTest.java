package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class PaternalUncleRelationshipTest {

	@Test
	public void When_GettingPaternalUncle_Expect_ListContainsBrothersOfFather() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person dritha = shanFamily.getNodeById("Dritha");
		Person ish = shanFamily.getNodeById("Ish");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				dritha);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(ish));
	}

	@Test
	public void When_GettingPaternalUncle_Expect_ListContainsBrotherInLawOfFather() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person vritha = shanFamily.getNodeById("Vritha");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				yodhan);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(vritha));
	}

	@Test
	public void When_GettingPaternalUncleList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				yodhan);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();
		Assert.assertEquals(1, paternalUncle.size());
	}

	@Test
	public void When_AddingBrotherOfFather_Expect_ChangeInPaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person vila = shanFamily.getNodeById("Vila");
		Person newNode = new Person("newBroToVich", Gender.MALE);
		shanFamily.addNewNode(newNode, "King Shan");

		PaternalUncleRelationship paternalUncleRelationship = new PaternalUncleRelationship(vila);
		Set<Person> paternalUncle = paternalUncleRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(newNode));
	}

	@Test
	public void When_AddingBrotherInLaw_Expect_ChangeInPaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person newNode = new Person("new son to chit", Gender.MALE);
		shanFamily.addNewNode(newNode, "Chit");

		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				yodhan);
		Set<Person> paternalUncle = paternalUncleRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(newNode));
	}

}
