package ar.com.oxen.nibiru.mobile.sample.app.api.data;

import com.google.common.base.Function;

public interface Customer {
	Function<Customer, String> TO_NAME = new Function<Customer, String>() {
		@Override
		public String apply(Customer customer) {
			return customer.getLastName() + ", " + customer.getFirstName();
		}
	};

	int getCustomerId();

	void setCustomerId(int id);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);
}
