package io.symphony.common.messages.command;

import java.util.Set;

import org.springframework.data.annotation.Transient;

import io.symphony.common.point.data.Point;
import io.symphony.common.point.data.state.SwitchPoint;
import io.symphony.common.point.data.state.type.Switch;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class SetSwitch extends SetState<Switch> {

	@Transient
	private final String type = "SetSwitch";

	@Override
	public Set<DataType> execute(Point point) {
		if (!SwitchPoint.class.isAssignableFrom(point.getClass()))
			return Set.of();
		
		SwitchPoint s = (SwitchPoint) point;
		
		if (getValue() != null && !getValue().equals(s.getValue())) {
			s.setValue(getValue());
			return Set.of(DataType.DATA);
		}
		
		return Set.of();
	}

}
