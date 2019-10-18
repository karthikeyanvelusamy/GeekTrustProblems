package com.geektrust.family.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.geektrust.family.bean.Person;
import com.geektrust.family.exception.PersonAlreadyExistsException;
import com.geektrust.family.exception.PersonNotFoundException;

/**
 * This class holds the data structure of the tree.
 * 
 * @author karthikeyan.v
 */
public class FamilyTree {

	/** The root. */
	private Person root;

	/**
	 * Instantiates a new family tree.
	 *
	 * @param root
	 *            the root
	 */
	public FamilyTree(Person root) {
		this.root = root;
	}

	/**
	 * Adds the new node.
	 *
	 * @param newNode
	 *            the new node
	 * @param parentId
	 *            the parent id
	 * @return true, if successful
	 * @throws PersonNotFoundException
	 *             the person not found exception
	 * @throws PersonAlreadyExistsException
	 *             the person already exists exception
	 */
	public boolean addNewNode(Person newNode, String parentId)
			throws PersonNotFoundException, PersonAlreadyExistsException {
		if (isExists(newNode)) {
			throw new PersonAlreadyExistsException(newNode.getId());
		}
		Person parent = findNode(parentId);
		if (parent == null) {
			throw new PersonNotFoundException(parentId);
		}
		newNode.setParent(parent);
		parent.getSpouce().addChild(newNode);
		parent.addChild(newNode);

		return true;
	}

	/**
	 * Find node.
	 *
	 * @param id
	 *            the id
	 * @return the person
	 */
	private Person findNode(String id) {
		Person node = null;
		LinkedList<Person> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			Person currentPerson = queue.remove();
			Person spoucePerson = currentPerson.getSpouce();
			if (currentPerson.getId().equalsIgnoreCase(id)) {
				node = currentPerson;
				break;
			} else if (spoucePerson != null
					&& spoucePerson.getId().equalsIgnoreCase(id)) {
				node = spoucePerson;
				break;
			}
			if (currentPerson.hasChildren()) {
				queue.addAll(currentPerson.getChildren());
			}
		}
		return node;
	}

	/**
	 * Checks if is exists.
	 *
	 * @param person
	 *            the person
	 * @return true, if is exists
	 */
	public boolean isExists(Person person) {
		return (findNode(person.getName()) == null) ? false : true;
	}

	/**
	 * Checks if is exists.
	 *
	 * @param name
	 *            the name
	 * @return true, if is exists
	 */
	public boolean isExists(String name) {
		return (findNode(name) == null) ? false : true;
	}

	/**
	 * Gets the node by id.
	 *
	 * @param id
	 *            the id
	 * @return the node by id
	 */
	public Person getNodeById(String id) {
		return findNode(id);
	}

	/**
	 * Gets the all decentatns.
	 *
	 * @param id
	 *            the id
	 * @return the all decentatns
	 * @throws PersonNotFoundException
	 *             the person not found exception
	 */
	public Set<Person> getAllDecentatns(String id)
			throws PersonNotFoundException {
		return getAllDecentants(getNodeById(id));
	}

	/**
	 * Gets the all decentants.
	 *
	 * @param node
	 *            the node
	 * @return the all decentants
	 */
	private Set<Person> getAllDecentants(Person node) {
		Set<Person> children = node.getChildren();
		Set<Person> finalResult = new HashSet<>(children);
		for (Person child : children) {
			Set<Person> result = getAllDecentants(child);
			if (!result.isEmpty()) {
				finalResult.addAll(result);
			}
		}
		return finalResult;
	}

	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Person getRoot() {
		return root;
	}
}
