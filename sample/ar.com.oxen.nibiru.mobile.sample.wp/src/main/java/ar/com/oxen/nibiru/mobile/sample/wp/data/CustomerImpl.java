package ar.com.oxen.nibiru.mobile.sample.wp.data;

import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;

public class CustomerImpl implements Customer {
	private int customerId;
	private String firstName;
	private String lastName;

	CustomerImpl() {
	}

	CustomerImpl(int customerId, String firstName, String lastName) {
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
