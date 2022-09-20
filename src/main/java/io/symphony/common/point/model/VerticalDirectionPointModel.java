package io.symphony.common.point.model;

import io.symphony.common.point.data.state.SwitchPoint;
import io.symphony.common.point.data.state.VerticalDirectionPoint;
import io.symphony.common.point.data.state.type.VerticalDirection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class VerticalDirectionPointModel extends StatePointModel<VerticalDirection> {
	
	private final String type = "VerticalDirection";

	public VerticalDirectionPointModel(VerticalDirectionPoint point) {
		super(point);
	}

}