package io.symphony.common.point.data.state;

import io.symphony.common.point.data.state.type.Alarm;
import io.symphony.common.point.data.state.type.Contact;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ContactPoint extends StatePoint<Contact> {

	private final String type = "Contact";

	@Override
	public void setValueAsString(String str) {
		setValue(str != null ? Contact.valueOf(str) : null);
	}
	
}
