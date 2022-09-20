package io.symphony.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class HateoasUtils {

	public static String getId(RepresentationModel<?> model) {
		if (model == null)
			return null;
		return getId(model.getLink("self").orElse(null));
	}
	
	public static String getId(Link link) {
		if (link == null)
			return null;
		return getId(link.getHref());
	}
	
	public static String getId(String href) {
		String regex = "/([^/]+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(href);		
		if (m.find())
			return m.group(1);
		return null;
	}
	
}
