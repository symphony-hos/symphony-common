package io.symphony.common.point.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.IStatePoint;
import io.symphony.common.point.data.state.StatePoint;
import io.symphony.common.point.data.state.type.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value = SwitchPointModel.class, name = "Switch"),
	@Type(value = MotionPointModel.class, name = "Motion"),
	@Type(value = VerticalDirectionPointModel.class, name = "VerticalDirection"),
	@Type(value = ContactPointModel.class, name = "Contact"),
	@Type(value = AlarmPointModel.class, name = "Alarm")
})
public abstract class StatePointModel<T extends State> extends PointModel {

	private T value;

	public StatePointModel(StatePoint<T> point) {
		super(point);
		setValue(point.getValue());
	}
	
}