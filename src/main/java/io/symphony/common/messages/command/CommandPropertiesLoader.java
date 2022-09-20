package io.symphony.common.messages.command;

import java.util.List;
import java.util.function.Function;

import io.symphony.common.point.data.state.type.Switch;
import io.symphony.common.selector.SelectorPropertiesLoader;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommandPropertiesLoader {
	
	/* Common */
	
	private String type;

	/* Point Command */
	
	private SelectorPropertiesLoader selector;
	
	/* State Command */
	
	private String state;
	
	/* Quantity Command */
	
	private Double value;
	
	
	public Command load() {
		return loaders.stream()
			.map(l -> l.apply(this))
			.filter(c -> c != null)
			.findFirst()
			.orElse(null);
	}
	
	private Function<CommandPropertiesLoader, ? extends Command> setQuantity = (props) -> {
		if (!"SetQuantity".equals(props.getType()))
			return null;
		return SetQuantity.builder()
			.selector(props.getSelector().load())
			.value(props.getValue())
			.build();
	};
	
	private Function<CommandPropertiesLoader, ? extends Command> setSwitch = (props) -> {
		if (!"SetSwitch".equals(props.getType()))
			return null;
		return SetSwitch.builder()
			.selector(props.getSelector().load())
			.value(Switch.valueOf(props.getState()))
			.build();
	};
	
	private List<Function<CommandPropertiesLoader, ? extends Command>> loaders = List.of(
		setQuantity,
		setSwitch
	);
	
	
}
