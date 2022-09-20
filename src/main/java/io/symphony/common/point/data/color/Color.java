package io.symphony.common.point.data.color;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ 
	@Type(value = RGBColor.class, name = "RGBColor"), 
	@Type(value = HSBColor.class, name = "HSBColor") , 
	@Type(value = CIEXYZColor.class, name = "CIEXYZColor") 
})
public abstract class Color {

	public String getType() {
		return getClass().getSimpleName();
	}

}