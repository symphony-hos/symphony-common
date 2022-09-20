package io.symphony.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HateoasUtilsTests {

	@Test
	public void testGetIdFromString() {
		
		String href = "http://127.0.0.1:8080/foo/bar";
		String id = HateoasUtils.getId(href);
		
		assertEquals("bar", id);
		
	}
	
}
