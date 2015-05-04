package ar.com.oxen.nibiru.mobile.sample.android.data;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "customers")
public class CustomerImpl implements Customer {
	@DatabaseField(generatedId = true)
	private Integer customerId;
	@DatabaseField
	private String firstName;
	@DatabaseField
	private String lastName;

	@Override
	public int getCustomerId() {
		return customerId;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = checkNotNull(customerId);
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		checkNotNull(firstName);
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		checkNotNull(lastName);
		this.lastName = lastName;
	}

	public boolean isNew() {
		return customerId == null;
	}
}
