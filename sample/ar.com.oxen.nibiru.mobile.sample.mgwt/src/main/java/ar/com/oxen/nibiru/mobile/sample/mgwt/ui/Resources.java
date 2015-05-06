package ar.com.oxen.nibiru.mobile.sample.mgwt.ui;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	@Source("styles.css")
	public Css css();

	@Source("logo_aaj.png")
	ImageResource aajLogo();

	@Source("logo_oxen.png")
	ImageResource oxenLogo();

	@Source("add.png")
	ImageResource add();

	public interface Css extends CssResource {
		String title();
	}
}
