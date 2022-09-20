package io.symphony.common.point.data.color;

import io.symphony.common.point.IColorPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import io.symphony.common.point.data.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.text.ParseException;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Document(collection = "point")
public class ColorPoint extends Point<Color> implements IColorPoint {

	private final String type = "Color";

	@Override
	public void setValueAsString(String str) throws ParseException {
		throw new RuntimeException("Not implemented, yet.");
	}

}
