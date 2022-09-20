package io.symphony.common.point.model;

import io.symphony.common.point.data.state.AlarmPoint;
import io.symphony.common.point.data.state.ContactPoint;
import io.symphony.common.point.data.state.type.Contact;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ContactPointModel extends StatePointModel<Contact> {
	
	private final String type = "Contact";

	public ContactPointModel(ContactPoint point) {
		super(point);
	}

}