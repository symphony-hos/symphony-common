package io.symphony.common.point.model;


import io.symphony.common.point.data.color.Color;
import io.symphony.common.point.data.color.ColorPoint;
import io.symphony.common.point.IColorPoint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ColorPointModel extends PointModel {

	private final String type = "Color";

	private Color value;
	
	public ColorPointModel(ColorPoint point) {
		super(point);
		setValue(point.getValue());
	}

}