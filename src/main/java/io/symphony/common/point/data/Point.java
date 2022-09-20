package io.symphony.common.point.data;

import java.text.ParseException;
import java.util.Map;
import java.util.Set;

import io.symphony.common.point.IPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.data.color.ColorPoint;
import io.symphony.common.point.data.quantity.QuantityPoint;
import io.symphony.common.point.data.state.AlarmPoint;
import io.symphony.common.point.data.state.ContactPoint;
import io.symphony.common.point.data.state.MotionPoint;
import io.symphony.common.point.data.state.SwitchPoint;
import io.symphony.common.point.data.state.VerticalDirectionPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = QuantityPoint.class, name = "Quantity"), 
	@Type(value = SwitchPoint.class, name = "Switch") , 
	@Type(value = MotionPoint.class, name = "Motion"),
	@Type(value = VerticalDirectionPoint.class, name = "VerticalDirection"),
	@Type(value = ColorPoint.class, name = "Color"),
	@Type(value = ContactPoint.class, name = "Contact"),
	@Type(value = AlarmPoint.class, name = "Alarm") 
})
@Document("point")
public abstract class Point<T> implements IPoint<T> {

	@Id
	private String id;
	
	private Map<String, String> labels;
	
	private Set<Access> access;

	private T value;

	@Transient
	public abstract String getType();

	public abstract void setValueAsString(String str) throws ParseException;

	public String getValueAsString() {
		return value == null ? null : getValue().toString();
	}

}
