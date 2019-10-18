package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class BrotherInLawRelationshipTest {

	@Test
	public void When_GettingBrosInLawList_Expect_ListContainsBrothersOfSpouce() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person mnu = shanFamily.getNodeById("Mnu");
		Person jata = shanFamily.getNodeById("Jata");
		BrotherInLawRelationship broInLaw = new BrotherInLawRelationship(mnu);
		Set<Person> brosInLaw = broInLaw.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(jata));
	}

	@Test
	public void When_GettingBrosInLawList_Expect_ListContainsHusbandsOfSiblings() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person ish = shanFamily.getNodeById("Ish");
		Person vyan = shanFamily.getNodeById("Vyan");
		BrotherInLawRelationship broInLaw = new BrotherInLawRelationship(ish);
		Set<Person> brosInLaw = broInLaw.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(vyan));
	}

	@Test
	public void When_GettingBrosInLawList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person ish = shanFamily.getNodeById("Ish");
		BrotherInLawRelationship broInLawRelation = new BrotherInLawRelationship(
				ish);
		Set<Person> brosInLaw = broInLawRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertEquals(1, brosInLaw.size());
	}

	@Test
	public void When_AddingBrothersOfSpouce_Expect_ChangeInBrosInLawList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person jnki = shanFamily.getNodeById("Jnki");
		Person newNode = new Person("TestChild", Gender.MALE);
		shanFamily.addNewNode(newNode, "Vich");

		BrotherInLawRelationship broInLawRelation = new BrotherInLawRelationship(
				jnki);
		Set<Person> brosInLaw = broInLawRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(newNode));
	}

	@Test
	public void When_AddingHusbandsOfSiblings_Expect_ChangeInBrosInLawList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person kriya = shanFamily.getNodeById("Kriya");

		Person newSister = new Person("sister to kriya", Gender.FEMALE);
		Person husbandToNewSister = new Person("husbandOfNewSis", Gender.MALE,
				null,newSister);

		shanFamily.addNewNode(newSister, "Savya");

		BrotherInLawRelationship broInLawRelation = new BrotherInLawRelationship(
				kriya);
		Set<Person> brosInLaw = broInLawRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(husbandToNewSister));
	}
}
