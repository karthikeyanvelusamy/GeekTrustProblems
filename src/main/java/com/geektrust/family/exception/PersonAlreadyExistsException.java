package com.geektrust.family.exception;

/**
 * This runtime exception will throw when try to add an node with already
 * existing id.
 * 
 * @author karthikeyan.v
 */
public class PersonAlreadyExistsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4937344658151282378L;

	/**
	 * Instantiates a new person already exists exception.
	 *
	 * @param id
	 *            the id
	 */
	public PersonAlreadyExistsException(String id) {
		super("Person already exists with the given id : " + id);
	}

}
