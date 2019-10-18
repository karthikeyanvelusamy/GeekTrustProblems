package com.geektrust.family.bean;

/**
 * This bean is used to encapsulate the relation details between people.
 * 
 * @author karthikeyan.v
 */
public class Relation {

	public Relation(Person person, RelationType relationType,
			Relatives relative) {
		this.person = person;
		this.relationType = relationType;
		this.relative = relative;
	}

	/** The person. */
	private Person person;

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Gets the relative.
	 *
	 * @return the relative
	 */
	public Relatives getRelative() {
		return relative;
	}

	/**
	 * Gets the relation type.
	 *
	 * @return the relation type
	 */
	public RelationType getRelationType() {
		return relationType;
	}

	/** The relative. */
	private Relatives relative;

	/** The relation type. */
	private RelationType relationType;

	/**
	 * The Enum RelationType.
	 */
	public enum RelationType {

		/** The father. */
		FATHER("father"),
		/** The mother. */
		MOTHER("mother"),
		/** The children. */
		CHILDREN("children"),
		/** The son. */
		SON("sons"),
		/** The daughter. */
		DAUGHTER("daughters"),
		/** The siblings. */
		SIBLINGS("siblings"),
		/** The brother. */
		BROTHER("brothers"),
		/** The sister. */
		SISTER("sisters"),
		/** The cousin. */
		COUSIN("cousins"),
		/** The sister in law. */
		SISTER_IN_LAW("sisters in law"),
		/** The brother in law. */
		BROTHER_IN_LAW("brother in law"),
		/** The paternal uncle. */
		PATERNAL_UNCLE("paternal uncle"),
		/** The paternal aunt. */
		PATERNAL_AUNT("paternal aunt"),
		/** The maternal uncle. */
		MATERNAL_UNCLE("maternal uncle"),
		/** The maternal aunt. */
		MATERNAL_AUNT("maternal aunt"),
		/** The grand children. */
		GRAND_CHILDREN("grand children"),
		/** The grand daughter. */
		GRAND_DAUGHTER("grand daughters"),
		/** The grand son. */
		GRAND_SON("grand sons");

		/** The code. */
		private String code;

		/**
		 * Gets the code.
		 *
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * Instantiates a new relation type.
		 *
		 * @param code
		 *            the code
		 */
		private RelationType(String code) {
			this.code = code;
		}

		/**
		 * Gets the.
		 *
		 * @param code
		 *            the code
		 * @return the relation type
		 */
		public static RelationType get(String code) {
			RelationType returnType = null;
			switch (code) {
			case "father":
				returnType = RelationType.FATHER;
				break;
			case "mother":
				returnType = RelationType.MOTHER;
				break;
			case "brother":
			case "brothers":
				returnType = RelationType.BROTHER;
				break;
			case "sister":
			case "sisters":
				returnType = RelationType.SISTER;
				break;
			case "cousin":
			case "cousins":
				returnType = RelationType.COUSIN;
				break;
			case "son":
			case "sons":
				returnType = RelationType.SON;
				break;
			case "daughter":
			case "daughters":
				returnType = RelationType.DAUGHTER;
				break;
			case "children":
				returnType = RelationType.CHILDREN;
				break;
			case "brothers in law":
			case "brother in law":
				returnType = RelationType.BROTHER_IN_LAW;
				break;
			case "sisters in law":
			case "sister in law":
				returnType = RelationType.SISTER_IN_LAW;
				break;
			case "siblings":
				returnType = RelationType.SIBLINGS;
				break;
			case "paternal uncles":
			case "paternal uncle":
				returnType = RelationType.PATERNAL_UNCLE;
				break;
			case "paternal aunts":
			case "paternal aunt":
				returnType = RelationType.PATERNAL_AUNT;
				break;
			case "maternal uncles":
			case "maternal uncle":
				returnType = RelationType.MATERNAL_UNCLE;
				break;
			case "maternal aunts":
			case "maternal aunt":
				returnType = RelationType.MATERNAL_AUNT;
				break;
			case "grand son":
			case "grand sons":
				returnType = RelationType.GRAND_SON;
				break;
			case "grand daughter":
			case "grand daughters":
				returnType = RelationType.GRAND_DAUGHTER;
				break;
			case "grand children":
				returnType = RelationType.GRAND_CHILDREN;
				break;
			default:
				returnType = null;
			}
			return returnType;
		}
	}
}
