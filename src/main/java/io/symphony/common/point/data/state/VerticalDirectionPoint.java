package io.symphony.common.point.data.state;

import io.symphony.common.point.data.state.type.Alarm;
import io.symphony.common.point.data.state.type.Switch;
import io.symphony.common.point.data.state.type.VerticalDirection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class VerticalDirectionPoint extends StatePoint<VerticalDirection> {

	private final String type = "VerticalDirection";

	@Override
	public void setValueAsString(String str) {
		setValue(str != null ? VerticalDirection.valueOf(str) : null);
	}

}
