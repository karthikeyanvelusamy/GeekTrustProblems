package com.geektrust.family.relationship.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.geektrust.family.bean.Person;
import com.geektrust.family.bean.Person.Gender;
import com.geektrust.family.data.FamilyTreeInitializer;
import com.geektrust.family.tree.FamilyTree;

public class MaternalAuntRelationshipTest {

	@Test
	public void When_GettingMaternalAunt_Expect_ListContainsSistersOfMother() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person tritha = shanFamily.getNodeById("Tritha");
		MaternalAuntRelationship maternalAuntRelationShip = new MaternalAuntRelationship(
				yodhan);
		Set<Person> maternalAunt = maternalAuntRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalAunt.contains(tritha));
	}

	@Test
	public void When_GettingMaternalAunt_Expect_ListContainsSistersInLawOfMother() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person Asava = shanFamily.getNodeById("Asava");
		Person lika = shanFamily.getNodeById("Lika");
		MaternalAuntRelationship maternalAuntRelationShip = new MaternalAuntRelationship(
				Asava);
		Set<Person> maternalAunt = maternalAuntRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalAunt.contains(lika));
	}

	@Test
	public void When_GettingMaternalAuntList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person Asava = shanFamily.getNodeById("Asava");
		MaternalAuntRelationship maternalAuntRelationShip = new MaternalAuntRelationship(
				Asava);
		Set<Person> maternalAunt = maternalAuntRelationShip.get().getRelative()
				.getRelativePeople();
		Assert.assertEquals(3, maternalAunt.size());
	}

	@Test
	public void When_AddingSistersOfMother_Expect_ChangeInMaternalAuntList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person savya = shanFamily.getNodeById("Asava");
		Person newNode = new Person("new Sister to mom", Gender.FEMALE);
		shanFamily.addNewNode(newNode, "King Shan");

		MaternalAuntRelationship maternalAuntRelationShip = new MaternalAuntRelationship(
				savya);
		Set<Person> maternalAunt = maternalAuntRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalAunt.contains(newNode));
	}

	@Test
	public void When_AddingSisterInLaw_Expect_ChangeInMaternalAuntList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person saayan = shanFamily.getNodeById("Asava");
		Person ish = shanFamily.getNodeById("Ish");

		Person newWifeToIsh = new Person("wife to ish", Gender.FEMALE);
		ish.setSpouce(newWifeToIsh);
		newWifeToIsh.setSpouce(ish);

		MaternalAuntRelationship maternalAuntRelationShip = new MaternalAuntRelationship(
				saayan);
		Set<Person> maternalAunt = maternalAuntRelationShip.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalAunt.contains(newWifeToIsh));
	}

}
