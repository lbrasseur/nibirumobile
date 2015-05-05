package ar.com.oxen.nibiru.mobile.sample.ios.data;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.robovm.apple.coredata.NSEntityDescription;
import org.robovm.apple.coredata.NSFetchRequest;
import org.robovm.apple.coredata.NSManagedObject;
import org.robovm.apple.coredata.NSManagedObjectContext;
import org.robovm.apple.coredata.NSManagedObjectModel;
import org.robovm.apple.coredata.NSPersistentStoreCoordinator;
import org.robovm.apple.coredata.NSPersistentStoreType;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.foundation.NSFileManager;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSPredicate;
import org.robovm.apple.foundation.NSSearchPathDirectory;
import org.robovm.apple.foundation.NSSearchPathDomainMask;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.Customer;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class CoreDataCustomerDao implements CustomerDao {
	private final static String ENTITY = "Customer";
	private final static String CUSTOMER_ID = "customerId";
	private final static String FIRST_NAME = "firstName";
	private final static String LAST_NAME = "lastName";
	private final static Function<NSManagedObject, Customer> ENTITY_TO_CUSTOMER = new Function<NSManagedObject, Customer>() {
		@Override
		public Customer apply(NSManagedObject managedObject) {
			NSNumber customerId = (NSNumber) managedObject
					.getValue(CUSTOMER_ID);
			NSString firstName = (NSString) managedObject.getValue(FIRST_NAME);
			NSString lastName = (NSString) managedObject.getValue(LAST_NAME);
			return new CustomerImpl(customerId.intValue(),
					firstName.toString(), lastName.toString());
		}
	};
	// TODO: fix ID generation
	private static int idCounter = 0;
	private final NSManagedObjectModel managedObjectModel;
	private final NSPersistentStoreCoordinator persistentStoreCoordinator;
	private final NSManagedObjectContext managedObjectContext;

	public CoreDataCustomerDao() {
		managedObjectModel = new NSManagedObjectModel(NSBundle.getMainBundle()
				.findResourceURL("dataModel", "mom"));
		persistentStoreCoordinator = new NSPersistentStoreCoordinator(
				managedObjectModel);
		NSArray<NSURL> nsa = NSFileManager.getDefaultManager()
				.getURLsForDirectory(NSSearchPathDirectory.DocumentDirectory,
						NSSearchPathDomainMask.UserDomainMask);
		NSURL nsu = nsa.get(0).newURLByAppendingPathComponent(
				"dataStore.sqlite");
		persistentStoreCoordinator
				.addPersistentStore(NSPersistentStoreType.SQLite, null, nsu, null);
		managedObjectContext = new NSManagedObjectContext();
		managedObjectContext
				.setPersistentStoreCoordinator(persistentStoreCoordinator);
	}

	@Override
	public void findAll(Callback<List<Customer>> callback) {
		checkNotNull(callback);
		try {
			callback.onSuccess(ImmutableList.copyOf(Iterables.transform(
					managedObjectContext
							.executeFetchRequest(new NSFetchRequest(ENTITY)),
					ENTITY_TO_CUSTOMER)));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public void findById(Integer id, Callback<Customer> callback) {
		checkNotNull(id);
		checkNotNull(callback);
		try {
			callback.onSuccess(Iterables.getFirst(Iterables.transform(
					managedObjectContext.executeFetchRequest(byId(id)),
					ENTITY_TO_CUSTOMER), null));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public Customer create() {
		return new CustomerImpl(null, null, null);
	}

	@Override
	public void save(Customer customer, Callback<Void> callback) {
		checkNotNull(customer);
		checkNotNull(callback);
		try {
			CustomerImpl customerImpl = (CustomerImpl) customer;
			NSManagedObject managedObject = null;
			if (!customerImpl.isNew()) {
				managedObject = Iterables.getFirst(managedObjectContext
						.executeFetchRequest(byId(customer.getCustomerId())),
						null);
			} else {
				customer.setCustomerId(++idCounter);
			}
			if (managedObject == null) {
				managedObject = new NSManagedObject(
						NSEntityDescription.getEntityByNameInContext(ENTITY,
								managedObjectContext), managedObjectContext);
			}
			managedObject.setValue(CUSTOMER_ID,
					NSNumber.valueOf(customer.getCustomerId()));
			managedObject.setValue(FIRST_NAME,
					new NSString(customer.getFirstName()));
			managedObject.setValue(LAST_NAME,
					new NSString(customer.getLastName()));
			managedObjectContext.save();
			callback.onSuccess(null);
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	private NSFetchRequest byId(int id) {
		NSFetchRequest request = new NSFetchRequest(ENTITY);
		request.setPredicate(NSPredicate.create("customerId == %@",
				NSNumber.valueOf(id)));
		return request;
	}
}
