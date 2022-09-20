package io.symphony.common.selector;

import java.util.Map;
import java.util.Optional;

import org.springframework.util.Assert;

import io.symphony.common.point.IPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelSelector implements Selector {

	public static enum ComparisonOperator {
		EQUALS, NOT_EQUALS
	}

	private String name;

	private ComparisonOperator operator;

	private String value;
	
	private final String type = "LabelSelector";

	@Override
	public SelectionResult select(IPoint point) {
		Assert.notNull(name, "Name must not be null");
		Assert.notNull(operator, "Operator must not be null");
		
		Map<String, String> labels = point.getLabels();
		String labelValue = labels != null ? labels.get(name) : null;

		boolean equals = (this.value == null && labelValue == null)
				|| (this.value != null && this.value.equals(labelValue));

		ComparisonOperator op = Optional.of(operator).orElse(ComparisonOperator.EQUALS);
		
		boolean result = op == ComparisonOperator.EQUALS ? equals : !equals;
		String reason = "Label selection: " + name + " " + operator + " " + value + " vs actual value " + labelValue;
		
		return SelectionResult.builder()
			.selected(result)
			.reason(reason)
			.build();
	}

}
