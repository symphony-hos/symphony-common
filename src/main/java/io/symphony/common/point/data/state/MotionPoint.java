package io.symphony.common.point.data.state;

import io.symphony.common.point.data.state.type.Alarm;
import io.symphony.common.point.data.state.type.Motion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class MotionPoint extends StatePoint<Motion> {

	private final String type = "Motion";

	@Override
	public void setValueAsString(String str) {
		setValue(str != null ? Motion.valueOf(str) : null);
	}

}
