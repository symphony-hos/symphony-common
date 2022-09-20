package io.symphony.common.messages.command;

import io.symphony.common.point.data.state.type.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
public abstract class SetState<T extends State> extends PointCommand {

	private T value;
	
}
