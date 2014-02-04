package ar.com.oxen.nibiru.mobile.sample.android;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter.Display;

public class SecondDisplay extends BaseAndroidView implements Display {
	private final LinearLayout view;
	private final Button backTrigger;

	@Inject
	public SecondDisplay(Context context, SampleMessages messages) {
		checkNotNull(context);
		checkNotNull(messages);
		view = new LinearLayout(context);
		view.setOrientation(LinearLayout.VERTICAL);

		backTrigger = new Button(context);
		backTrigger.setText(messages.back());
		view.addView(backTrigger);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new ViewAdapter(backTrigger);
	}
	
	@Override
	public View asNative() {
		return view;
	}
}
