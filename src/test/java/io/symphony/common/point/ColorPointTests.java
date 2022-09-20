package io.symphony.common.point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import io.symphony.common.point.data.color.RGBColor;

public class ColorPointTests {

	@Test
	public void rgbColorEquals() {
		RGBColor col1 = RGBColor.builder().red(10).green(20).blue(30).build();
		RGBColor col2 = RGBColor.builder().red(30).green(20).blue(10).build();
		RGBColor col3 = RGBColor.builder().red(10).green(20).blue(30).build();
		
		assertEquals(col1, col3);
		assertEquals(col3, col1);
		assertNotEquals(col1, col2);
		assertNotEquals(col3, col2);
	}
	
	
}
