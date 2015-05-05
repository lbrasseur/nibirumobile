package ar.com.oxen.nibiru.mobile.sample.ios.data;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;

public class CustomerImpl implements Customer {
	private Integer customerId;
	private String firstName;
	private String lastName;

	public CustomerImpl(Integer customerId, String firstName, String lastName) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = checkNotNull(customerId);
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		checkNotNull(firstName);
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		checkNotNull(lastName);
		this.lastName = lastName;
	}

	public boolean isNew() {
		return customerId == null;
	}
}
