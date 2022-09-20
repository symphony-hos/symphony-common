package io.symphony.common.exception;

public class PointNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public PointNotFoundException(String id) {
		super("Point", id);
	}

}
