package io.symphony.common.point;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.symphony.common.point.data.quantity.QuantityPoint;
import tec.units.ri.unit.Units;

import java.text.ParseException;

public class QuantityPointTests extends PointTests<QuantityPoint> {

	@Test
	public void testSetValueFromStringWithoutUnit() throws ParseException {
		QuantityPoint p = QuantityPoint.builder()
			.value(20.0d)
			.unit(Units.KELVIN)
			.build();

		String str = "25";

		p.setValueAsString(str);

		assertEquals(25d, p.getValue());
		assertEquals(Units.KELVIN, p.getUnit());
	}

	@Test
	public void testSetValueFromStringWithUnit() throws ParseException {
		QuantityPoint p = QuantityPoint.builder()
			.value(20.0d)
			.unit(Units.KELVIN)
			.build();
	
		String str = "25.2 °C";
		
		p.setValueAsString(str);
		
		assertEquals(25.2d, p.getValue());
		assertEquals(Units.CELSIUS, p.getUnit());
	}

	@Override
	public QuantityPoint instantiatePoint() {
		return QuantityPoint.builder().build();
	}
	
}
