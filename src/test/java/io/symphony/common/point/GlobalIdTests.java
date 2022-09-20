package io.symphony.common.point;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GlobalIdTests {

	@Test
	public void testFromString() {
		
		String str = "foo:bar";
		GlobalId id = GlobalId.fromString(str);
		assertEquals("foo", id.getExtension());
		assertEquals("bar", id.getIdentifier());
		
	}
	
}
