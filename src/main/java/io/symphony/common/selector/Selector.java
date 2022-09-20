package io.symphony.common.selector;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.IPoint;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = LabelSelector.class, name = "LabelSelector"),
	@Type(value = CompositeSelector.class, name = "CompositeSelector"),
	@Type(value = ValueSelector.class, name = "ValueSelector")
})
public interface Selector {

	public SelectionResult select(IPoint point);
	
	@Transient
	public String getType();
	
}
