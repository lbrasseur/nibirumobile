package ar.com.oxen.nibiru.mobile.sample.app.impl.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.api.business.CustomerManager;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter.Display;

public class CustomerFormPresenter extends BasePresenter<Display> {
	public interface Display extends View {
		TakesValue<String> getFirstName();

		TakesValue<String> getLastName();

		HasClickHandler getSave();

		HasClickHandler getCancel();
	}

	private final PlaceManager placeManager;
	private final CustomerManager customerManager;
	private Customer customer;

	@Inject
	public CustomerFormPresenter(Display view, AlertManager alertManager,
			PlaceManager placeManager, CustomerManager customerManager) {
		super(view, alertManager);
		this.placeManager = checkNotNull(placeManager);
		this.customerManager = checkNotNull(customerManager);
	}

	@Override
	public void go(Place place) {
		Integer id = place.getParameter(Params.ID);
		if (id != null) {
			customerManager.getCustomer(id, new Cbk<Customer>() {
				@Override
				public void onSuccess(Customer customer) {
					updateCustomer(customer);
				}
			});
		} else {
			updateCustomer(customerManager.createCustomer());
		}

		getView().getSave().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				customer.setFirstName(getView().getFirstName().getValue());
				customer.setLastName(getView().getLastName().getValue());
				customerManager.saveCustomer(customer, new Cbk<Void>() {
					@Override
					public void onSuccess(Void result) {
					}
				});
				placeManager.back();
			}
		});
		getView().getCancel().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager.back();
			}
		});
	}

	private void updateCustomer(Customer customer) {
		this.customer = customer;
		getView().getFirstName().setValue(customer.getFirstName());
		getView().getLastName().setValue(customer.getLastName());
	}
}
