package com.geektrust.family.bean;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class is the node of the family tree.
 * 
 * @author karthikeyan.v
 */
public class Person {

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param parent
	 *            the parent
	 * @param spouce
	 *            the spouce
	 * @param children
	 *            the children
	 */
	public Person(String name, Gender gender, Person parent, Person spouce,
			Set<Person> children) {
		this.name = name;
		this.id = name;
		this.gender = gender;
		this.parent = parent;
		if (spouce != null && spouce.getSpouce() == null) {
			spouce.setSpouce(this);
		}
		this.spouce = spouce;
		this.children = children;
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param parent
	 *            the parent
	 * @param spouce
	 *            the spouce
	 */
	public Person(String name, Gender gender, Person parent, Person spouce) {
		this(name, gender, parent, spouce, null);
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param parent
	 *            the parent
	 */
	public Person(String name, Gender gender, Person parent) {
		this(name, gender, parent, null);
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 */
	public Person(String name, Gender gender) {
		this(name, gender, null);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Person getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the new parent
	 */
	public void setParent(Person parent) {
		this.parent = parent;
	}

	/**
	 * Gets the spouce.
	 *
	 * @return the spouce
	 */
	public Person getSpouce() {
		return spouce;
	}

	/**
	 * Sets the spouce.
	 *
	 * @param spouce
	 *            the new spouce
	 */
	public void setSpouce(Person spouce) {

		this.spouce = spouce;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public Set<Person> getChildren() {
		return (children == null) ? Collections.emptySet() : new HashSet<>(
				children);
	}

	/**
	 * Adds the child.
	 *
	 * @param child
	 *            the child
	 */
	public void addChild(Person child) {
		if (children == null) {
			children = new HashSet<>();
		}
		children.add(child);
	}

	/**
	 * Checks if is married.
	 *
	 * @return true, if is married
	 */
	public boolean isMarried() {
		return (spouce != null) ? true : false;
	}

	/**
	 * Checks for children.
	 *
	 * @return true, if successful
	 */
	public boolean hasChildren() {
		return (this.children != null && !this.children.isEmpty());
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/** The id. */
	private String id;

	/** The name. */
	private String name;

	/** The gender. */
	private Gender gender;

	/** The parent. */
	private Person parent;

	/** The spouce. */
	private Person spouce;

	/** The children. */
	private Set<Person> children;

	/**
	 * The Enum Gender.
	 */
	public enum Gender {

		/** The male. */
		MALE,
		/** The female. */
		FEMALE;

		/**
		 * From value.
		 *
		 * @param value
		 *            the value
		 * @return the gender
		 */
		public Gender fromValue(String value) {
			return fromValue(value);
		}
	}

	/*
	 * Considering the identifier woukd be based on Id field.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Person otherPerson = (Person) obj;
		if (id != null && id.equalsIgnoreCase(otherPerson.getName())) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
