package io.symphony.common.conversion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.measure.Unit;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import tec.units.ri.unit.Units;

@Component
@WritingConverter
@SuppressWarnings("rawtypes")
public class UnitToStringConverter implements Converter<Unit, String> {

	@Override
	public String convert(Unit source) {
		if (source == null)
			return null;

		Class<Units> unitsClass = Units.class;
		Field[] fields = unitsClass.getDeclaredFields();
				
		for (Field field: fields) {
			if (!Modifier.isStatic(field.getModifiers()))
				continue;
			
			Object value = getOrNull(field, null);
			
			if (value == null || !(value instanceof Unit))
				continue;
			
			Unit unit = (Unit) value;
			if (unit.equals(source))
				return field.getName();
		}
	
		throw new RuntimeException("Unable to convert Unit to String: " + source);
	}
	
	private static Object getOrNull(Field field, Object o) {
		try {
			return field.get(o);
		} catch (Exception e) {
			return null;
		}
	}
	
}