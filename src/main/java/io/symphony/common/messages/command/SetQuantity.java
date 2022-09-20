package io.symphony.common.messages.command;

import java.util.Set;

import org.springframework.data.annotation.Transient;

import io.symphony.common.point.data.Point;
import io.symphony.common.point.data.quantity.QuantityPoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
public class SetQuantity extends PointCommand {

	private Double value;

	@Transient
	private final String type = "SetQuantity";
	
	@Override
	public Set<DataType> execute(Point point) {
		if (!QuantityPoint.class.isAssignableFrom(point.getClass()))
			return Set.of();
		
		QuantityPoint q = (QuantityPoint) point;
		
		if (!q.getValue().equals(getValue())) {
			q.setValue(getValue());
			return Set.of(DataType.DATA);
		}
		return Set.of();
	}
	
}
