package io.symphony.common.point.data.state.type;

public enum Motion implements BooleanState<Motion> {
	MOTION, NO_MOTION;

	public static Motion fromBoolean(Boolean bool) {
		return bool == true ? MOTION : NO_MOTION;
	}

	@Override
	public Boolean toBoolean() {
		return this == MOTION ? true : false;
	}
	
	@Override
	public String asString() {
		return this.toString();
	}

}