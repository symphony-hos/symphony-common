package io.symphony.common.conversion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.measure.Unit;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import tec.units.ri.unit.Units;

@Component
@ReadingConverter
public class StringToUnitConverter implements Converter<String, Unit<?>> {

	@Override
	public Unit<?> convert(String source) {
		if (source == null || source.trim().length() == 0)
			return null;
		
		Class<Units> unitsClass = Units.class;
		Field[] fields = unitsClass.getDeclaredFields();
				
		for (Field field: fields) {
			if (!Modifier.isStatic(field.getModifiers()))
				continue;
			
			if (field.getName().equals(source))
				return (Unit<?>) getOrNull(field, null);
		}
	
		throw new RuntimeException("Unable to convert String to Unit: " + source);
	}
	
	private static Object getOrNull(Field field, Object o) {
		try {
			return field.get(o);
		} catch (Exception e) {
			return null;
		}
	}
	
}