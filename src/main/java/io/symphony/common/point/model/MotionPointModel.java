package io.symphony.common.point.model;

import io.symphony.common.point.data.state.ContactPoint;
import io.symphony.common.point.data.state.MotionPoint;
import io.symphony.common.point.data.state.type.Motion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class MotionPointModel extends StatePointModel<Motion> {
	
	private final String type = "Motion";

	public MotionPointModel(MotionPoint point) {
		super(point);
	}

}