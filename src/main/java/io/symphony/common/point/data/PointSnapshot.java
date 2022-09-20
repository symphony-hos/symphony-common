package io.symphony.common.point.data;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class PointSnapshot {

	public static PointSnapshot from(String ext, String id, Point point) {
		return PointSnapshot.builder()
			.ext(ext)
			.id(id)
			.content(point)
			.createdAt(LocalDateTime.now())
			.build();
	}

	@EqualsAndHashCode.Include
	private String ext;

	@EqualsAndHashCode.Include
	private String id;
	
	@EqualsAndHashCode.Exclude
	private Point content;
	
	@EqualsAndHashCode.Exclude
	private LocalDateTime createdAt;
		
}
