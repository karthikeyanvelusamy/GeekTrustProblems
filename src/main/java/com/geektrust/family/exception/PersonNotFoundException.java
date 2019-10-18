package com.geektrust.family.exception;

/**
 * This runtime exception will be thrown when an node is not found with given
 * id.
 * 
 * @author karthikeyan.v
 */
public class PersonNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -868059704917675447L;

	/**
	 * Instantiates a new person not found exception.
	 *
	 * @param id
	 *            the id
	 */
	public PersonNotFoundException(String id) {
		super("Person can not be found with given Id : " + id);
	}
}
