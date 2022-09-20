package io.symphony.common.selector;

import org.springframework.util.Assert;

import io.symphony.common.point.IPoint;
import io.symphony.common.point.IQuantityPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueSelector implements Selector {

	private NumberOperator operator;

	private Double value;
	
	private final String type = "ValueSelector";

	@Override
	public SelectionResult select(IPoint point) {
		Assert.notNull(operator, "Operator must not be null");
		Assert.notNull(value, "Value must not be null");
		
		if (point instanceof IQuantityPoint) {
			IQuantityPoint q = (IQuantityPoint) point;
			Double pVal = q.getValue();
			
			Boolean result = null;
			if (operator == NumberOperator.LESS_THAN)
				result = pVal < value;
			else if (operator == NumberOperator.LESS_OR_EQUAL)
				result = pVal <= value;
			else if (operator == NumberOperator.EQUAL)
				result = pVal == value;
			else if (operator == NumberOperator.GREATER_OR_EQUAL)
				result = pVal >= value;
			else if (operator == NumberOperator.GREATER_THAN)
				result = pVal > value;
				
			String reason = (result == true) ? "Value " + pVal + " is " + operator + " to " + value : "Value " + pVal + " is not " + operator + " to " + value;
		
			return SelectionResult.builder()
				.selected(result)
				.reason(reason)
				.build();
		}

		return SelectionResult.builder()
			.selected(false)
			.reason("Unable to determine selection result")
			.build();
	}

}
