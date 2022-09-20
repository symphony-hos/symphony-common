package io.symphony.common.point.data;

import java.util.Set;

public enum Access {
	READ, WRITE;
	
	public static Set<Access> READ_ONLY = Set.of(READ);
	
	public static Set<Access> READ_WRITE = Set.of(READ, WRITE);
	
}