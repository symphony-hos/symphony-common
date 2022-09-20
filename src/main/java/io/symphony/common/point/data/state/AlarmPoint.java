package io.symphony.common.point.data.state;

import io.symphony.common.point.data.state.type.Alarm;
import io.symphony.common.point.data.state.type.Motion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class AlarmPoint extends StatePoint<Alarm> {

	private final String type = "Alarm";
	
	@Override
	public void setValueAsString(String str) {
		setValue(str != null ? Alarm.valueOf(str) : null);
	}

}
