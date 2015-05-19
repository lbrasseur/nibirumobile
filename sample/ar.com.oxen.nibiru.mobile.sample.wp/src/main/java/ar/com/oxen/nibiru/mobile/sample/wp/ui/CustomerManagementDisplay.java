package ar.com.oxen.nibiru.mobile.sample.wp.ui;

import static com.google.common.base.Preconditions.checkNotNull;

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
import com.google.gwt.core.client.JsArrayString;

public class CustomerManagementDisplay extends BaseWindowsPhoneView implements
		Display {
	private List<Customer> customers;
	private Customer selectedCustomer;
	private ClickHandler rowClickHandler;

	@Inject
	public CustomerManagementDisplay(SampleMessages messages) {
		label("customerManagementTitle").setText(messages.customerManagement());
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		this.customers = checkNotNull(customers);
	    JsArrayString jsArrayString = JsArrayString.createArray().cast();
	    for (String s : ImmutableList.copyOf(Iterables.transform(
				customers, Customer.TO_NAME))) {
	        jsArrayString.push(s);
	    }
		setCustomersNative(jsArrayString);
	}

	private native void setCustomersNative(JsArrayString customers) /*-{
		var cmDisplay = this;
		var htmlList = $doc.getElementById("customerList");
        $wnd.WinJS.UI.process(htmlList).done(function() {
            var listView = htmlList.winControl;
            var array = new Array();
            for (var n in customers) {
                (function(index) {
	                var row = {
	                    rowText: customers[index],
	                    clickEvent: $wnd.WinJS.UI.eventHandler(function (ev) {
	                    	cmDisplay.@ar.com.oxen.nibiru.mobile.sample.wp.ui.CustomerManagementDisplay::selectCustomer(I)(index);
					    })
	                };
	                array.push(row);
                })(n);
            }
            listView.itemDataSource = new $wnd.WinJS.Binding.List(array).dataSource;
        });
	}-*/;

	public void selectCustomer(int pos) {
		selectedCustomer = customers.get(pos);
		if (rowClickHandler != null) {
			rowClickHandler.onClick();
		}
	}

	@Override
	public HasClickHandler getNewCustomer() {
		return new HasClickHandlersAdapter(image("add"));
	}

	@Override
	public HasClickHandler getEditCustomer() {
		return new HasClickHandler() {
			@Override
			public HandlerRegistration setClickHandler(ClickHandler clickHandler) {
				rowClickHandler = checkNotNull(clickHandler);
				return new HandlerRegistration() {
					@Override
					public void removeHandler() {
						rowClickHandler = null;
					}
				};
			}
		};
	}

	@Override
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}
}
