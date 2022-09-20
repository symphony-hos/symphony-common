package io.symphony.common.point.data.state;

import io.symphony.common.point.data.state.type.Alarm;
import io.symphony.common.point.data.state.type.Motion;
import io.symphony.common.point.data.state.type.Switch;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SwitchPoint extends StatePoint<Switch> {

	private final String type = "Switch";

	@Override
	public void setValueAsString(String str) {
		setValue(str != null ? Switch.valueOf(str) : null);
	}

}
