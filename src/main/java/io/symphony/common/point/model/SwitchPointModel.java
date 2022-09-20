package io.symphony.common.point.model;

import io.symphony.common.point.data.state.MotionPoint;
import io.symphony.common.point.data.state.SwitchPoint;
import io.symphony.common.point.data.state.type.Switch;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SwitchPointModel extends StatePointModel<Switch> {
	
	private final String type = "Switch";

	public SwitchPointModel(SwitchPoint point) {
		super(point);
	}

}