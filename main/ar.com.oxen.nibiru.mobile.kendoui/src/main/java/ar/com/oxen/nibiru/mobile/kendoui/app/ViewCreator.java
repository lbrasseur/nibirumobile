package ar.com.oxen.nibiru.mobile.kendoui.app;

/**
 * Component for creating views during app startup. KendoUI requires the views
 * to be pre-created before creating the application. Because of this. such
 * component is needed.
 */
public interface ViewCreator {
	void createViews();
}
