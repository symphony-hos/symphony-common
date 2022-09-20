package io.symphony.common.point.model;

import io.symphony.common.point.data.state.AlarmPoint;
import io.symphony.common.point.data.state.StatePoint;
import io.symphony.common.point.data.state.type.Alarm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AlarmPointModel extends StatePointModel<Alarm> {
	
	private final String type = "Alarm";

	public AlarmPointModel(AlarmPoint point) {
		super(point);
	}

}