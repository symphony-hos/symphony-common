package io.symphony.common.point.data.state.type;

public enum Switch implements BooleanState<Switch>  {
	
	ON, OFF;
	
	public static Switch fromBoolean(Boolean bool) {
		return bool == true ? ON : OFF;
	}

	@Override
	public Boolean toBoolean() {
		return this == ON ? true : false;
	}
	
	@Override
	public String asString() {
		return this.toString();
	}
	
}