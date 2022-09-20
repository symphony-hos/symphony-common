package io.symphony.common.selector;

import java.util.List;
import java.util.stream.Collectors;

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
public class CompositeSelector implements Selector {

	public static enum LogicalOperator {
		AND, OR, XOR
	}
	
	private LogicalOperator operator;
	
	private List<Selector> selectors;
	
	private final String type = "CompositeSelector";
	
	@Override
	public SelectionResult select(IPoint point) {
		Assert.notNull(operator, "Operator must not be null");
		Assert.isTrue(selectors.size() > 0, "Must have at least one selector.");
		
		List<Boolean> positiveResults = selectors.stream()
			.map(s -> s.select(point))
			.map(s -> s.isSelected())
			.filter(s -> s == true)
			.collect(Collectors.toList());
		
		String reasons = selectors.stream()
			.map(s -> s.select(point))
			.map(s -> s.getReason())
			.map(e -> e.toString())
			.reduce(", ", String::concat);
		
		if (this.operator == LogicalOperator.AND) {
			boolean result = positiveResults.size() == selectors.size();
			String reason = (result == false) ? "One or more selectors returned false " + reasons : "All selectors returned true. " + reasons;
			return SelectionResult.builder()
				.selected(result)
				.reason(reason)
				.build();
		}
		
		if (this.operator == LogicalOperator.OR) {
			boolean result = positiveResults.size() > 0;
			String reason = (result == false) ? "No selector returned true " + reasons : "One or more selectors returned true. " + reasons;
			return SelectionResult.builder()
				.selected(result)
				.reason(reason)
				.build();
		}

		if (this.operator == LogicalOperator.XOR) {
			boolean result = positiveResults.size() > 0;
			String reason = (result == false) ? "None or multiple selectors returned true. " + reasons : "Exactly one selector returned true. " + reasons;
			return SelectionResult.builder()
				.selected(result)
				.reason(reason)
				.build();
		}
		
		return SelectionResult.builder()
				.selected(false)
				.reason("Unable to determine result:  " + reasons)
				.build();
		
	}

}
