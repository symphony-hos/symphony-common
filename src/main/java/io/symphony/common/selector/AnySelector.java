package io.symphony.common.selector;

import io.symphony.common.point.IPoint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AnySelector implements Selector {
	
	private final String type = "AnySelector";

	@Override
	public SelectionResult select(IPoint point) {
		return SelectionResult.builder()
			.selected(true)
			.reason(null)
			.build();
	}

}
