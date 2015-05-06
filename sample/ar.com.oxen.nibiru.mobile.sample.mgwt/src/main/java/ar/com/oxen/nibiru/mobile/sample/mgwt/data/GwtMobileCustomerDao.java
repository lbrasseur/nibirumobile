package ar.com.oxen.nibiru.mobile.sample.mgwt.data;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.data.CollectionCallbackAdapter;
import ar.com.oxen.nibiru.mobile.gwt.data.ScalarCallbackAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

import com.google.gwt.core.client.GWT;
import com.gwtmobile.persistence.client.Entity;
import com.gwtmobile.persistence.client.Persistence;

public class GwtMobileCustomerDao implements CustomerDao {
	private final Entity<PCustomer> entity = GWT.create(PCustomer.class);

	@Override
	public void findAll(Callback<List<Customer>> callback) {
		checkNotNull(callback);
		try {
			entity.all().list(
					new CollectionCallbackAdapter<PCustomer>(callback));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void findById(Integer id, Callback<Customer> callback) {
		checkNotNull(id);
		checkNotNull(callback);
		try {
			this.entity.findBy("customerId", id,
					new ScalarCallbackAdapter<Customer, PCustomer>(callback));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public Customer create() {
		return entity.newInstance();
	}

	@Override
	public void save(Customer customer, Callback<Void> callback) {
		checkNotNull(customer);
		checkNotNull(callback);

		PCustomer pCustomer = (PCustomer) customer;
		Persistence.add(pCustomer);
		pCustomer.setCustomerId(pCustomer.getId().hashCode());
	}
}
