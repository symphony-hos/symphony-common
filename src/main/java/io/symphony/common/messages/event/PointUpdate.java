package io.symphony.common.messages.event;

import io.symphony.common.point.data.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PointUpdate extends Event {

	private String extension;
	
	private String identifier;
	
	private final String type = "PointUpdate";
	
	private Point point;
	
}
