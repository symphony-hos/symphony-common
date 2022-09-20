package io.symphony.common.point.data.state.type;

public interface BooleanState<T> extends State {
	
	public Boolean toBoolean();

	@Override
	default int asNumber() {
		return toBoolean() == true ? 1 : 0;
	}

}
