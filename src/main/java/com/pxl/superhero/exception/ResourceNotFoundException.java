package com.pxl.superhero.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String resource, String field, String value) {
		super("Not found: " + resource + " with " + field + "=" + value);
	}
	public ResourceNotFoundException(String resource, String field, long value) {
		this(resource, field, Long.toString(value));
	}
}
