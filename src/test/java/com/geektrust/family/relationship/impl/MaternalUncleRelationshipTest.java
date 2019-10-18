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

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person vritha = shanFamily.getNodeById("Vritha");
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				yodhan);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(vritha));
	}

	@Test
	public void When_GettingMaternalUncle_Expect_ListContainsBrotherInLawOfMother() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person yodhan = shanFamily.getNodeById("Yodhan");
		Person tritha = shanFamily.getNodeById("Tritha");
		Person newHusToTritha = new Person("husband to Tritha", Gender.MALE);
		tritha.setSpouce(newHusToTritha);
		newHusToTritha.setSpouce(tritha);
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				yodhan);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(newHusToTritha));
	}

	@Test
	public void When_GettingMaternalUncleList_Expect_Count() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person drita = shanFamily.getNodeById("Dritha");
		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				drita);
		Set<Person> maternalUncle = maternalUncleRelationship.get()
				.getRelative().getRelativePeople();
		Assert.assertEquals(3, maternalUncle.size());
	}

	@Test
	public void When_AddingBrotherOfMother_Expect_ChangeInMaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

		Person Asava = shanFamily.getNodeById("Asava");
		Person newNode = new Person("newBroToSatya", Gender.MALE);
		shanFamily.addNewNode(newNode, "King Shan");

		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(Asava);
		Set<Person> maternalUncle = maternalUncleRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(newNode));
	}

	@Test
	public void When_AddingBrotherInLaw_Expect_ChangeInMaternalUncleList() {
		FamilyTreeInitializer familyTreeInitializer = new FamilyTreeInitializer();
		familyTreeInitializer.init();
		FamilyTree shanFamily = familyTreeInitializer
				.getFamilyTree("King Shan");

				Person yodhan = shanFamily.getNodeById("Yodhan");
				Person tritha = shanFamily.getNodeById("Tritha");
				Person newHusToTritha = new Person("husband to Tritha", Gender.MALE);
				tritha.setSpouce(newHusToTritha);
				newHusToTritha.setSpouce(tritha);

		MaternalUncleRelationship maternalUncleRelationship = new MaternalUncleRelationship(
				yodhan);
		Set<Person> maternalUncle = maternalUncleRelationship.get().getRelative()
				.getRelativePeople();

		Assert.assertTrue(maternalUncle.contains(newHusToTritha));
	}

}
