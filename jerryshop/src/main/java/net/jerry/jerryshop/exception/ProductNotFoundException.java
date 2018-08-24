package net.jerry.jerryshop.exception;

import java.io.Serializable;


public class ProductNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNotFoundException() {
		this("product is not availabe!");
	}

	public ProductNotFoundException(String message) {
		this.message = System.getSecurityManager() + ": " + message;
	}

	public String getMessage() {
		return message;
	}

}
