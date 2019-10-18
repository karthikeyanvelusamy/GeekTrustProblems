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

		Person driya = shanFamily.getNodeById("Driya");
		Person vrita = shanFamily.getNodeById("Vrita");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				driya);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(vrita));
	}

	@Test
	public void When_GettingPaternalUncle_Expect_ListContainsBrotherInLawOfFather() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person savya = shanFamily.getNodeById("Savya");
		Person vich = shanFamily.getNodeById("Vich");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				savya);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(vich));
	}

	@Test
	public void When_GettingPaternalUncleList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person saayan = shanFamily.getNodeById("Saayan");
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				saayan);
		Set<Person> paternalUncle = paternalUncleRelationShip.get()
				.getRelative().getRelativePeople();
		Assert.assertEquals(3, paternalUncle.size());
	}

	@Test
	public void When_AddingBrotherOfFather_Expect_ChangeInPaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person lavnya = shanFamily.getNodeById("Lavnya");
		Person newNode = new Person("newBroToVila", Gender.MALE);
		shanFamily.addNewNode(newNode, "Vich");

		PaternalUncleRelationship paternalUncleRelationship = new PaternalUncleRelationship(lavnya);
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

		Person satvy = shanFamily.getNodeById("Satvy");
		Person newNode = new Person("new son to shan", Gender.MALE);
		shanFamily.addNewNode(newNode, "King Shan");
		
		PaternalUncleRelationship paternalUncleRelationShip = new PaternalUncleRelationship(
				satvy);
		Set<Person> paternalUncle = paternalUncleRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(paternalUncle.contains(newNode));
	}

}
