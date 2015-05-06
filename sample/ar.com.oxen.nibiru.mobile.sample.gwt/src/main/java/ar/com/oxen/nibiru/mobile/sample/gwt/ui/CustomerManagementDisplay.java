package ar.com.oxen.nibiru.mobile.sample.gwt.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.button.ImageButton;
import com.googlecode.mgwt.ui.client.widget.list.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellSelectedHandler;

public class CustomerManagementDisplay extends BaseGwtView implements Display {
	interface CustomerManagementDisplayUiBinder extends
			UiBinder<Widget, CustomerManagementDisplay> {
	}

	@UiField
	ImageButton add;

	@UiField(provided = true)
	CellList<Customer> list;

	private List<Customer> customers;
	private ClickHandler rowClickHandler;
	private Customer selectedCustomer;

	@Inject
	public CustomerManagementDisplay(CustomerManagementDisplayUiBinder uiBinder) {
		checkNotNull(uiBinder);
		list = new CellList<Customer>(new BasicCell<Customer>() {
			@Override
			public String getDisplayString(Customer customer) {
				return customer.getLastName() + ", " + customer.getFirstName();
			}
		});
		list.addCellSelectedHandler(new CellSelectedHandler() {
			@Override
			public void onCellSelected(CellSelectedEvent event) {
				selectedCustomer = customers.get(event.getIndex());
				rowClickHandler.onClick();
			}
		});
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		this.customers = checkNotNull(customers);
		list.render(customers);
	}

	@Override
	public HasClickHandler getNewCustomer() {
		return new HasTapHandlersAdapter(add);
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
