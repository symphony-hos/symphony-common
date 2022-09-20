package io.symphony.common.point.model;

import javax.measure.Unit;

import io.symphony.common.point.IQuantityPoint;
import io.symphony.common.point.data.quantity.QuantityPoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.ParseException;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class QuantityPointModel extends PointModel {

	private final String type = "Quantity";

	private Double value;

	private Unit<?> unit;

	public QuantityPointModel(QuantityPoint point) {
		super(point);
		setValue(point.getValue());
		this.unit = point.getUnit();
	}

}