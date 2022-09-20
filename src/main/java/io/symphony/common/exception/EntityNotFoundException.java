package io.symphony.common.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String entity, String id) {
		super("Cound not find " + entity + " with id " + id);
	}

}
