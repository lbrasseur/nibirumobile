package ar.com.oxen.nibiru.mobile.sample.gwt.data;

import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;

public class CustomerImpl implements Customer {
	private int customerId;
	private String firstName;
	private String lastName;

	@Override
	public int getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
