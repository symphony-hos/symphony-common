package io.symphony.common.conversion;

import java.io.IOException;

import javax.measure.Unit;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
@SuppressWarnings("rawtypes")
public class UnitDeserializer extends JsonDeserializer<Unit> {

	private Converter<String, Unit<?>> converter = new StringToUnitConverter();

	@Override
	public Unit<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String str = p.getValueAsString();
		if (str == null | str.trim().length() == 0)
			return null;
		return converter.convert(str);
	}

}
