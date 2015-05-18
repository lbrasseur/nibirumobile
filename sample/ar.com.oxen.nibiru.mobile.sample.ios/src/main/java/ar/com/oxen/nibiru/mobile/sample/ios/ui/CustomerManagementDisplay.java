package ar.com.oxen.nibiru.mobile.sample.ios.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UINibLoadingOptions;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewDataSourceAdapter;
import org.robovm.apple.uikit.UITableViewDelegateAdapter;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Property;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

public class CustomerManagementDisplay extends BaseUIViewView implements
		Display {
	private final SampleMessages messages;
	private UIView container;
	private UIButton add;
	private UITableView customerList;
	private List<Customer> customers;
	private Customer selectedCustomer;
	private ClickHandler rowClickHandler;

	@Inject
	public CustomerManagementDisplay(SampleMessages messages) {
		this.messages = checkNotNull(messages);
		NSBundle.getMainBundle().loadNib("customerManagement", this,
				new UINibLoadingOptions());
	}

	@Property
	public void setContainer(UIView container) {
		this.container = checkNotNull(container);
	}

	@Property
	public void setTitle(UILabel title) {
		checkNotNull(title);
		title.setText(messages.customerManagement());
	}

	@Property
	public void setAdd(UIButton add) {
		this.add = checkNotNull(add);
	}

	@Property
	public void setCustomerList(UITableView customerList) {
		this.customerList = checkNotNull(customerList);
		customerList.setDelegate(new UITableViewDelegateAdapter() {
			@Override
			public void didSelectRow(UITableView tableView,
					NSIndexPath indexPath) {
				selectedCustomer = customers.get((int) indexPath.getRow());
				rowClickHandler.onClick();
			}
		});
		customerList.setDataSource(new UITableViewDataSourceAdapter() {
			@Override
			public long getNumberOfRowsInSection(UITableView tableView,
					long section) {
				return customers != null ? customers.size() : 0;
			}

			@Override
			public UITableViewCell getCellForRow(UITableView tableView,
					NSIndexPath indexPath) {
				Customer customer = customers.get((int) indexPath.getRow());
				UITableViewCell cell = new UITableViewCell();
				UILabel text = new UILabel();
				text.setFrame(new CGRect(20, 10, customerList.getFrame().getWidth() - 20, 32));
				text.setText(Customer.TO_NAME.apply(customer));
				cell.addSubview(text);
				return cell;
			}
		});
	}

	@Override
	public UIView asNative() {
		return container;
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		this.customers = checkNotNull(customers);
		customerList.reloadData();
	}

	@Override
	public HasClickHandler getNewCustomer() {
		return new UIButtonAdapter(add);
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
