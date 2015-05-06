package ar.com.oxen.nibiru.mobile.sample.app.impl.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.api.business.CustomerManager;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;

public class CustomerManagementPresenter extends BasePresenter<Display> {
	public interface Display extends View {
		void setCustomers(List<Customer> customers);

		HasClickHandler getNewCustomer();

		HasClickHandler getEditCustomer();

		Customer getSelectedCustomer();
	}

	private final PlaceManager placeManager;
	private final CustomerManager customerManager;

	@Inject
	public CustomerManagementPresenter(Display view, AlertManager alertManager,
			PlaceManager placeManager, CustomerManager customerManager) {
		super(view, alertManager);
		this.placeManager = checkNotNull(placeManager);
		this.customerManager = checkNotNull(customerManager);
	}

	@Override
	public void go(Place place) {
		getView().getNewCustomer().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager.createPlace(Places.CUSTOMER_FORM).go(true);
			}
		});
		getView().getEditCustomer().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager
						.createPlace(Places.CUSTOMER_FORM)
						.addParameter(Params.ID,
								getView().getSelectedCustomer().getCustomerId())
						.go(true);
			}
		});
	}

	@Override
	public void onActivate() {
		customerManager.getAllCustomers(new Cbk<List<Customer>>() {
			@Override
			public void onSuccess(List<Customer> customers) {
				getView().setCustomers(customers);
			}
		});
	}
}
