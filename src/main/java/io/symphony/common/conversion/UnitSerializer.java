package io.symphony.common.conversion;

import java.io.IOException;

import javax.measure.Unit;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
@SuppressWarnings("rawtypes")
public class UnitSerializer extends JsonSerializer<Unit> {

	private Converter<Unit, String> converter = new UnitToStringConverter();
	
	@Override
	public void serialize(Unit value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String str = converter.convert(value);
		if (str == null || str.trim().length() == 0)
			gen.writeNull();
		else
			gen.writeString(converter.convert(value));
	}

	@Override
	public Class<Unit> handledType() {
		return Unit.class;
	}

}
