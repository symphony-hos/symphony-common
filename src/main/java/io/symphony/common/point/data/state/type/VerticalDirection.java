package io.symphony.common.point.data.state.type;

public enum VerticalDirection implements BooleanState<VerticalDirection> {
	UP, DOWN;
	
	public static VerticalDirection fromBoolean(Boolean bool) {
		return bool == true ? UP : DOWN;
	}

	@Override
	public Boolean toBoolean() {
		return this == DOWN ? true : false;
	}
	
	@Override
	public String asString() {
		return this.toString();
	}

}