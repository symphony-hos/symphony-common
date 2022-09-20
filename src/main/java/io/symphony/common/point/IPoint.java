package io.symphony.common.point;

import io.symphony.common.point.data.Access;

import java.text.ParseException;
import java.util.Map;
import java.util.Set;

public interface IPoint<T> {

	String getId();

	void setId(String id);

	Map<String, String> getLabels();

	void setLabels(Map<String, String> labels);

	T getValue();

	void setValue(T value);

	Set<Access> getAccess();

	void setAccess(Set<Access> access);

	String getType();

}
