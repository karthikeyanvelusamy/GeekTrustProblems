package com.geektrust.family.exception;

/**
 * This runtime exception will be thrown when an non valid relation found.
 * 
 * @author karthikeyan.v
 */
public class UnsupportedRelation extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8030591713428695626L;

	/**
	 * Instantiates a new unsupported relation.
	 *
	 * @param relation
	 *            the relation
	 */
	public UnsupportedRelation(String relation) {
		super("Unsupported relation :" + relation);
	}
}
