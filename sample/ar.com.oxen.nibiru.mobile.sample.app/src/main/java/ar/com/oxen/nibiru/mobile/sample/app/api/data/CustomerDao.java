package ar.com.oxen.nibiru.mobile.sample.app.api.data;

import java.util.List;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

public interface CustomerDao {
	void findAll(Callback<List<Customer>> callback);

	void findById(Integer id, Callback<Customer> callback);

	Customer create();

	void save(Customer customer, Callback<Void> callback);
}
