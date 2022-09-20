package io.symphony.common.point.data.quantity;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

import io.symphony.common.point.IQuantityPoint;
import io.symphony.common.point.data.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import tec.units.ri.format.SimpleUnitFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Document("point")
public class QuantityPoint extends Point<Double> implements IQuantityPoint {

	private Unit<?> unit;
	
	private final String type = "Quantity";

	@Override
	public void setValueAsString(String str) throws ParseException {
		if (str == null) {
			this.setValue(null);
			return;
		}

		String numRegex = "([-+]?\\d*[.]?\\d+|^[-+]?\\d+[.]?\\d*)";
		Pattern patternWithUnit = Pattern.compile(numRegex + " (.*)");
		Matcher matcherWithUnit = patternWithUnit.matcher(str);
		if (matcherWithUnit.matches()) {
			String numStr = matcherWithUnit.group(1);
			String unitStr = matcherWithUnit.group(2);
			UnitFormat unitF = SimpleUnitFormat.getInstance();
			try {
				Double num = Double.parseDouble(numStr);
				Unit<?> unit = unitF.parse(unitStr);
				this.setValue(num.doubleValue());
				this.setUnit(unit);
			} catch(Exception ex) {
				throw new RuntimeException("Failed to parse QuantityPoint from string " + str, ex);
			}
			return;
		}

		Pattern patternNoUnit = Pattern.compile(numRegex);
		Matcher matcherNoUnit = patternNoUnit.matcher(str);
		if (matcherNoUnit.matches()) {
			String numStr = matcherNoUnit.group(1);
			try {
				Double num = Double.parseDouble(numStr);
				this.setValue(num.doubleValue());
			} catch(Exception ex) {
				throw new RuntimeException("Failed to parse QuantityPoint from string " + str, ex);
			}
			return;
		}

		throw new ParseException(str, 0);
	}

}
