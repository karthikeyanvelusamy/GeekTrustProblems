package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class SisterInLawRelationshipTest {

	@Test
	public void When_GettingSisInLawList_Expect_ListContainsSistersOfSpouce() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person ambi = shanFamily.getNodeById("Ambi");
		Person satya = shanFamily.getNodeById("Satya");
		SisterInLawRelationship sisterInLawRelationship = new SisterInLawRelationship(ambi);
		Set<Person> sistersInLaw = sisterInLawRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(sistersInLaw.contains(satya));
	}

	@Test
	public void When_GettingSistersInLawList_Expect_ListContainsWifesOfSiblings() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person chit = shanFamily.getNodeById("Chit");
		Person lika = shanFamily.getNodeById("Lika");
		SisterInLawRelationship sisterInLawRelatioship = new SisterInLawRelationship(chit);
		Set<Person> sistersInLaw = sisterInLawRelatioship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(sistersInLaw.contains(lika));
	}

	@Test
	public void When_GettingSistersInLawList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person ish = shanFamily.getNodeById("Ish");
		SisterInLawRelationship sisterInLawRelatioship = new SisterInLawRelationship(ish);
		Set<Person> sistersInLaw = sisterInLawRelatioship.get().getRelative()
				.getRelativePeople();

		Assert.assertEquals(2, sistersInLaw.size());
	}

	@Test
	public void When_AddingSistersOfSpouce_Expect_ChangeInSistersInLawList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person newNode = new Person("Daughter to shan",Gender.FEMALE);
		shanFamily.addNewNode(newNode, "King Shan");
		Person ambi = shanFamily.getNodeById("Ambi");
		SisterInLawRelationship sisterInLawRelatioship = new SisterInLawRelationship(ambi);
		Set<Person> sistersInLaw = sisterInLawRelatioship.get().getRelative()
				.getRelativePeople();


		Assert.assertTrue(sistersInLaw.contains(newNode));
	}

	@Test
	public void When_AddingWifesToSiblings_Expect_ChangeInSistersInLawList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person ish = shanFamily.getNodeById("Ish");
		Person chit = shanFamily.getNodeById("Chit");
		Person newWifeToIsh = new Person("Wife to Ish", Gender.FEMALE);
		ish.setSpouce(newWifeToIsh);
		newWifeToIsh.setSpouce(ish);
		SisterInLawRelationship sisterInLawRelatioship = new SisterInLawRelationship(chit);
		Set<Person> sistersInLaw = sisterInLawRelatioship.get().getRelative()
				.getRelativePeople();


		Assert.assertTrue(sistersInLaw.contains(newWifeToIsh));
	}
}
