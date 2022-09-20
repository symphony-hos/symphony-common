package io.symphony.common.messages.command;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.data.Point;
import io.symphony.common.selector.Selector;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = SetSwitch.class, name = "SetSwitch"),
	@Type(value = SetQuantity.class, name = "SetQuantity")
})
public abstract class PointCommand extends Command {
	
	public static enum DataType {
		DATA, METADATA
	}

	private Selector selector;
	
	public abstract Set<DataType> execute(Point point);

}
