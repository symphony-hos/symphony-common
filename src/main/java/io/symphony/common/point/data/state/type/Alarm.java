package io.symphony.common.point.data.state.type;

public enum Alarm implements BooleanState<Alarm> {
	ALARM, NO_ALARM;

	public static Alarm fromBoolean(Boolean bool) {
		return bool == true ? ALARM : NO_ALARM;
	}

	@Override
	public Boolean toBoolean() {
		return this == ALARM ? true : false;
	}
	
	@Override
	public String asString() {
		return this.toString();
	}

}