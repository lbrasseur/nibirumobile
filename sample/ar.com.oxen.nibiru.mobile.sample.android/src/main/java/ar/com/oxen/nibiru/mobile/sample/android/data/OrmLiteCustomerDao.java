package ar.com.oxen.nibiru.mobile.sample.android.data;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.java.thread.ThreadHelper;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class OrmLiteCustomerDao implements CustomerDao {
	private final RuntimeExceptionDao<CustomerImpl, Integer> ormLiteDao;
	private final ThreadHelper threadHelper;

	@Inject
	public OrmLiteCustomerDao(OrmLiteSqliteOpenHelper helper,
			ThreadHelper threadHelper) {
		checkNotNull(helper);
		this.threadHelper = checkNotNull(threadHelper);
		this.ormLiteDao = helper.getRuntimeExceptionDao(CustomerImpl.class);
	}

	@Override
	public void findAll(Callback<List<Customer>> callback) {
		checkNotNull(callback);
		threadHelper.runOnNewThread(new Supplier<List<Customer>>() {
			@Override
			public List<Customer> get() {
				return ImmutableList.<Customer> copyOf(ormLiteDao.queryForAll());
			}
		}, callback);
	}

	@Override
	public void findById(final Integer id, Callback<Customer> callback) {
		checkNotNull(id);
		checkNotNull(callback);
		threadHelper.runOnNewThread(new Supplier<Customer>() {
			@Override
			public Customer get() {
				return ormLiteDao.queryForId(id);
			}
		}, callback);
	}

	@Override
	public Customer create() {
		return new CustomerImpl();
	}

	@Override
	public void save(final Customer customer, Callback<Void> callback) {
		checkNotNull(customer);
		checkNotNull(callback);
		threadHelper.runOnNewThread(new Supplier<Void>() {
			@Override
			public Void get() {
				CustomerImpl customerImpl = (CustomerImpl) customer;
				if (customerImpl.isNew()) {
					ormLiteDao.create(customerImpl);
				} else {
					ormLiteDao.update(customerImpl);
				}
				return null;
			}
		}, callback);
	}
}
