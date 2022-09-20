package io.symphony.common.messages.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.symphony.common.point.data.Point;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
public class SetLabel extends PointCommand {

	public static enum Mode {
		REPLACE, MERGE
	}
	
	private Set<String> pointIds;

	private Map<String, String> labels;
	
	@Default
	private Mode mode = Mode.REPLACE;

	private final String type = "SetLabel";

	@Override
	public Set<DataType> execute(Point point) {
		 if (getLabels() == null || getLabels().size() == 0)
			 return Set.of();
		 
		 if (getMode() == Mode.REPLACE) {
			 point.setLabels(getLabels());
			 return Set.of(DataType.METADATA);
		 } else if (getMode() == Mode.MERGE) {
			 Map<String, String> newLabels = new HashMap<>(getLabels());
			 for (Entry<String, String> entry: getLabels().entrySet())
				 newLabels.put(entry.getKey(), entry.getValue()); 
			 setLabels(newLabels);
			 return Set.of(DataType.METADATA);
		 }
		 
		 return Set.of();
	}
	
}
