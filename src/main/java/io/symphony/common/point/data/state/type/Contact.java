package io.symphony.common.point.data.state.type;

public enum Contact implements BooleanState<Contact> {
	OPEN, CLOSED;

	public static Contact fromBoolean(Boolean bool) {
		return bool == true ? OPEN : CLOSED;
	}

	@Override
	public Boolean toBoolean() {
		return this == OPEN ? true : false;
	}

	@Override
	public String asString() {
		return this.toString();
	}

}