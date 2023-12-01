/**
 * 
 */
package com.rushikesh.qp.assessment.java.enums;

/**
 * 
 */
public enum ApiKey {

	MESSAGE("message"), SUCCESS("SUCCESS"), DATA("DATA");
	
	String value;

	private ApiKey(String value) {
		this.value = value;
	}

	public String val() {
		return value;
	}
}
