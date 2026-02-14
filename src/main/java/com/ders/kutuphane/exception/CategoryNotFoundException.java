package com.ders.kutuphane.exception;


public class CategoryNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3804414913949955033L;

	public CategoryNotFoundException(String message) {
        super(message);
    }
}