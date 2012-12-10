package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import javax.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContextScope;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import ar.com.oxen.nibiru.mobile.android.ui.place.IntentPlace;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

/**
 * An activity that delegates logic to a presenter.
 */
public class PresenterActivity extends RoboActivity {
	@Inject
	private PresenterMapper presenterMapper;

	@Inject
	protected ContextScope scope;

	private Presenter<?> presenter;
	private AndroidView view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Place place = new IntentPlace(this.getIntent(), this);

		synchronized (ContextScope.class) {
			scope.enter(this);
			try {
				this.presenter = this.presenterMapper.getPresenter(place
						.getId());
			} finally {
				scope.exit(this);
			}
		}

		this.view = (AndroidView) this.presenter.getView();
		this.setContentView(this.view.asNative());
		this.presenter.go(place);
	}

	@Override
	protected void onStop() {
		super.onStop();
		this.presenter.onStop();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return this.view.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return this.view.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return this.view.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		this.view.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return this.view.onContextItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.view.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
		this.view.onPause();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		this.view.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.view.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
		this.view.onStart();
	}
}
