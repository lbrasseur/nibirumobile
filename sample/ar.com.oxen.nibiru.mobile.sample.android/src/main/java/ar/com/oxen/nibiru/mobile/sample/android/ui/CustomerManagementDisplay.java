package ar.com.oxen.nibiru.mobile.sample.android.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.android.R;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

import com.google.common.collect.Lists;

public class CustomerManagementDisplay extends BaseAndroidView<View> implements
		Display {
	private final View add;
	private final BaseAdapter customersAdapter;
	private final List<Customer> customers;
	private Customer selectedCustomer;
	private ClickHandler rowClickHandler;

	@Inject
	public CustomerManagementDisplay(Context context,
			final LayoutInflater layoutInflater, SampleMessages messages) {
		super(layoutInflater.inflate(R.layout.customer_management, null));
		checkNotNull(messages);
		findViewById(R.id.title, TextView.class).setText(
				messages.customerManagement());
		add = findViewById(R.id.add);
		ListView customersView = findViewById(R.id.customers);
		customers = Lists.newArrayList();
		customersAdapter = new ArrayAdapter<Customer>(context, 0, customers) {
			@Override
			public View getView(int position, View view, ViewGroup parent) {
				if (view == null) {
					view = layoutInflater.inflate(
							android.R.layout.simple_list_item_1, parent, false);
				}
				TextView tv = (TextView) view.findViewById(android.R.id.text1);
				Customer customer = getItem(position);
				tv.setText(Customer.TO_NAME.apply(customer));
				return view;
			}

		};
		customersView.setAdapter(customersAdapter);
		customersView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				selectedCustomer = customers.get(position);
				rowClickHandler.onClick();
			}
		});
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		checkNotNull(customers);
		this.customers.clear();
		this.customers.addAll(customers);
		customersAdapter.notifyDataSetChanged();
	}

	@Override
	public HasClickHandler getNewCustomer() {
		return new ViewAdapter(add);
	}

	@Override
	public HasClickHandler getEditCustomer() {
		return new HasClickHandler(){
			@Override
			public HandlerRegistration setClickHandler(ClickHandler clickHandler) {
				rowClickHandler = checkNotNull(clickHandler);
				return new HandlerRegistration() {
					@Override
					public void removeHandler() {
						rowClickHandler = null;
					}
				};
			}};
	}

	@Override
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}
}
