package io.symphony.common.messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.messages.command.PublishAll;
import io.symphony.common.messages.command.SetSwitch;
import io.symphony.common.messages.event.PointUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = PointUpdate.class, name = "PointUpdate"),
	@Type(value = PublishAll.class, name = "PublishAll"),
	@Type(value = SetSwitch.class, name = "SetSwitch"),
})
public abstract class Message {

	public abstract String getType();
	
}
