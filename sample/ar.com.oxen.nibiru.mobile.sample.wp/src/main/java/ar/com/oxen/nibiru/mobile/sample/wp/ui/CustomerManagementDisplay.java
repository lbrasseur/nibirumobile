package ar.com.oxen.nibiru.mobile.sample.wp.ui;

import java.util.List;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;

public class CustomerManagementDisplay  implements Display {

	@Override
	public Object asNative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HasClickHandler getNewCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandler getEditCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getSelectedCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
