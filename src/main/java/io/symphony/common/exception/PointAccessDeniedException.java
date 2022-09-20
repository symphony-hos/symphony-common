package io.symphony.common.exception;

public class PointAccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PointAccessDeniedException(String id) {
		super("Access denied to point with id " + id);
	}

}
