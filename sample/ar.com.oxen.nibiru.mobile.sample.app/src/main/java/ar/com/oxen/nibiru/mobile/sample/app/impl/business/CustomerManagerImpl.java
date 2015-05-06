package ar.com.oxen.nibiru.mobile.sample.app.impl.business;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.sample.app.api.business.CustomerManager;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

public class CustomerManagerImpl implements CustomerManager {
	private final CustomerDao customerDao;

	@Inject
	public CustomerManagerImpl(CustomerDao customerDao) {
		this.customerDao = checkNotNull(customerDao);
	}

	@Override
	public void getAllCustomers(Callback<List<Customer>> callback) {
		customerDao.findAll(callback);
	}

	@Override
	public void getCustomer(Integer id, Callback<Customer> callback) {
		customerDao.findById(id, callback);
	}

	@Override
	public Customer createCustomer() {
		return customerDao.create();
	}

	@Override
	public void saveCustomer(Customer customer, Callback<Void> callback) {
		customerDao.save(customer, callback);
	}
}
