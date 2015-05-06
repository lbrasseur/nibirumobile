package ar.com.oxen.nibiru.mobile.sample.android.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SecondPresenter.Display;

public class SecondDisplay extends BaseAndroidView<LinearLayout> implements Display {
	private final Button backTrigger;

	@Inject
	public SecondDisplay(Context context, SampleMessages messages) {
		super(new LinearLayout(context));
		checkNotNull(context);
		checkNotNull(messages);
		asNative().setOrientation(LinearLayout.VERTICAL);

		backTrigger = new Button(context);
		backTrigger.setText(messages.back());
		asNative().addView(backTrigger);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new ViewAdapter(backTrigger);
	}
}
