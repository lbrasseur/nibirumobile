package ar.com.oxen.nibiru.mobile.sample.gwt.data;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public class InMemoryCustomerDao implements CustomerDao {
	private static int lastId = 0;
	private Map<Integer, Customer> customers = Maps.newHashMap();

	@Override
	public void findAll(Callback<List<Customer>> callback) {
		checkNotNull(callback);
		callback.onSuccess(ImmutableList.copyOf(customers.values()));
	}

	@Override
	public void findById(Integer id, Callback<Customer> callback) {
		checkNotNull(id);
		checkNotNull(callback);
		callback.onSuccess(customers.get(id));
	}

	@Override
	public Customer create() {
		return new CustomerImpl();
	}

	@Override
	public void save(Customer customer, Callback<Void> callback) {
		checkNotNull(customer);
		checkNotNull(callback);

		if (customer.getCustomerId() == 0) {
			customer.setCustomerId(++lastId);
		}
		customers.put(customer.getCustomerId(), customer);
	}
}
