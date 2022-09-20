package io.symphony.common.selector;

import java.util.List;
import java.util.stream.Collectors;

import io.symphony.common.selector.CompositeSelector.LogicalOperator;
import io.symphony.common.selector.LabelSelector.ComparisonOperator;
import lombok.Data;

@Data
public class SelectorPropertiesLoader {


	private String type;
	
	/* Label Selector */
	
	private String name;

	private String value;

	/* ID Selector */
	
	private String id;
	
	/* Composite Selector */
	
	private List<SelectorPropertiesLoader> selectors;
	
	/* Common */
	
	private String operator;

	
	
	public Selector load() {
		if ("LabelSelector".equals(type))
			return LabelSelector.builder()
				.name(name)
				.operator(ComparisonOperator.valueOf(operator))
				.value(value)
				.build();
		else if ("IdSelector".equals(type))
			return IdSelector.builder()
				.id(id)
				.build();
		else if ("CompositeSelector".equals(type)) {
			List<Selector> instances = selectors.stream()
				.map(sp -> sp.load())
				.collect(Collectors.toList());
			return CompositeSelector.builder()
				.operator(LogicalOperator.valueOf(operator))
				.selectors(instances)
				.build();
		}
		else if ("AnySelector".equals(type)) {
			return AnySelector.builder()
				.build();
		}
		return null;
	}
	
}
