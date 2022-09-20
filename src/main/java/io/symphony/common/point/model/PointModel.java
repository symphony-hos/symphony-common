package io.symphony.common.point.model;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.symphony.common.point.data.Access;
import io.symphony.common.point.IPoint;
import io.symphony.common.point.data.Point;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value = QuantityPointModel.class, name = "Quantity"),
	@Type(value = SwitchPointModel.class, name = "Switch"),
	@Type(value = MotionPointModel.class, name = "Motion"),
	@Type(value = VerticalDirectionPointModel.class, name = "VerticalDirection"),
	@Type(value = ColorPointModel.class, name = "Color"),
	@Type(value = ContactPointModel.class, name = "Contact"),
	@Type(value = AlarmPointModel.class, name = "Alarm")
})
public abstract class PointModel extends RepresentationModel<PointModel> {

	private Map<String, String> labels;

	private Set<Access> access;

	public PointModel(Point point) {
		this.labels = point.getLabels();
		this.access = point.getAccess();
	}
	
	public abstract String getType();

}