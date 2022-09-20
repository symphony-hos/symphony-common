package io.symphony.common.point.data.state;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.IStatePoint;
import io.symphony.common.point.data.Point;
import io.symphony.common.point.data.state.type.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = SwitchPoint.class, name = "Switch") , 
	@Type(value = MotionPoint.class, name = "Motion"),
	@Type(value = VerticalDirectionPoint.class, name = "VerticalDirection"),
	@Type(value = ContactPoint.class, name = "Contact"),
	@Type(value = AlarmPoint.class, name = "Alarm") 
})
@ToString(callSuper = true)
@Document("point")
public abstract class StatePoint<T extends State> extends Point<T> implements IStatePoint<T> {

}
