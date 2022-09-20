package io.symphony.common.selector;

import org.springframework.util.Assert;

import io.symphony.common.point.IPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdSelector implements Selector {

	private String id;
	
	private final String type = "IdSelector";

	@Override
	public SelectionResult select(IPoint point) {
		Assert.notNull(id, "Name must not be null");
		
		boolean selected = (point == null || point.getId() == null) ? false : point.getId().equals(id); 
		
		return SelectionResult.builder()
			.selected(selected)
			.reason("ID " + (selected == true ? "matches" : "does not match"))
			.build();
	}

}
