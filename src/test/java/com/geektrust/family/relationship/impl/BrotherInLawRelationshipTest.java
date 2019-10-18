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

		Person amba = shanFamily.getNodeById("Amba");
		Person ish = shanFamily.getNodeById("Ish");
		BrotherInLawRelationship broInLaw = new BrotherInLawRelationship(amba);
		Set<Person> brosInLaw = broInLaw.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(ish));
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

		Person jaya = shanFamily.getNodeById("Jaya");
		Person newNode = new Person("TestChild", Gender.MALE);
		shanFamily.addNewNode(newNode, "Chit");

		BrotherInLawRelationship broInLawRelation = new BrotherInLawRelationship(
				jaya);
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

		Person vritha = shanFamily.getNodeById("Vritha");
		Person tritha = shanFamily.getNodeById("Tritha");
		Person husband = new Person("Husband to tritha", Gender.MALE);
		husband.setSpouce(tritha);
		tritha.setSpouce(husband);



		BrotherInLawRelationship broInLawRelation = new BrotherInLawRelationship(
				vritha);
		Set<Person> brosInLaw = broInLawRelation.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(brosInLaw.contains(husband));
	}
}
