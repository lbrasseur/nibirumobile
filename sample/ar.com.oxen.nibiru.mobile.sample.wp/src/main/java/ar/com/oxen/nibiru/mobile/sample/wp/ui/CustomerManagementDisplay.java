package ar.com.oxen.nibiru.mobile.sample.wp.ui;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.wp.ui.mvp.BaseWindowsPhoneView;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class CustomerManagementDisplay extends BaseWindowsPhoneView implements
		Display {

	@Inject
	public CustomerManagementDisplay(SampleMessages messages) {
		label("customerManagementTitle").setText(messages.customerManagement());
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		List<String> names = ImmutableList.copyOf(Iterables.transform(
				customers, Customer.TO_NAME));
		setCustomersNative(names.toArray(new String[names.size()]));
	}

	private static native void setCustomersNative(String[] customers) /*-{
		var listView = $doc.getElementById("customerList");
		var array = new Array();
		for (n in customers) {
			array.push({
				text: customers[n]
			});
		}
		listView.itemDataSource = new $wnd.WinJS.Binding.List(array).dataSource;
		$wnd.WinJS.UI.processAll();
	  	new Windows.UI.Popups.MessageDialog("ffffff").showAsync();
	}-*/;

	@Override
	public HasClickHandler getNewCustomer() {
		return new HasClickHandlersAdapter(image("add"));
	}

	@Override
	public HasClickHandler getEditCustomer() {
		// TODO Auto-generated method stub
		return new HasClickHandler() {

			@Override
			public HandlerRegistration setClickHandler(ClickHandler clickHandler) {
				// TODO Auto-generated method stub
				return new HandlerRegistration() {

					@Override
					public void removeHandler() {
						// TODO Auto-generated method stub

					}
				};
			}
		};
	}

	@Override
	public Customer getSelectedCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
