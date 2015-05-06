package ar.com.oxen.nibiru.mobile.sample.app.api.business;

import java.util.List;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;

public interface CustomerManager {
	void getAllCustomers(Callback<List<Customer>> callback);

	void getCustomer(Integer id, Callback<Customer> callback);

	Customer createCustomer();

	void saveCustomer(Customer customer, Callback<Void> callback);
}
