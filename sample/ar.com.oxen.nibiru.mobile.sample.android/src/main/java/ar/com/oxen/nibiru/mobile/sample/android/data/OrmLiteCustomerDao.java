package ar.com.oxen.nibiru.mobile.sample.android.data;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

import com.google.common.collect.ImmutableList;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class OrmLiteCustomerDao implements CustomerDao {
	private final RuntimeExceptionDao<CustomerImpl, Integer> ormLiteDao;

	@Inject
	public OrmLiteCustomerDao(OrmLiteSqliteOpenHelper helper) {
		checkNotNull(helper);
		this.ormLiteDao = helper.getRuntimeExceptionDao(CustomerImpl.class);
	}

	@Override
	public void findAll(Callback<List<Customer>> callback) {
		checkNotNull(callback);
		try {
			callback.onSuccess(ImmutableList.<Customer> copyOf(ormLiteDao
					.queryForAll()));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void findById(Integer id, Callback<Customer> callback) {
		checkNotNull(id);
		checkNotNull(callback);
		try {
			callback.onSuccess(ormLiteDao.queryForId(id));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public Customer create() {
		return new CustomerImpl();
	}

	@Override
	public void save(Customer customer, Callback<Void> callback) {
		checkNotNull(customer);
		checkNotNull(callback);
		try {
			CustomerImpl customerImpl = (CustomerImpl) customer;
			if (customerImpl.isNew()) {
				ormLiteDao.create(customerImpl);
			} else {
				ormLiteDao.update(customerImpl);
			}
			callback.onSuccess(null);
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}
}
