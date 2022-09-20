package io.symphony.common.point;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.symphony.common.point.model.PointModel;
import io.symphony.common.utils.HateoasUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GlobalId {

	public static GlobalId fromString(String str) {
		str = URLDecoder.decode(str, StandardCharsets.UTF_8);
		
		String regex = "^([^/]+):([^/]+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(str);
		if (m.find()) {
			String ext = m.group(1);
			String id = m.group(2);
			return GlobalId.builder().extension(ext).identifier(id).build();	
		}
		throw new RuntimeException("Unable to parse global ID from string " + str);
	}

	public static GlobalId fromEntityModel(String ext, PointModel model) {
		String selfHref = HateoasUtils.getId(model);
		return fromString(selfHref);
	}

	private String extension;

	private String identifier;

	public String toString() {
		return extension + ":" + identifier;
	}

}