package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

/**
 * {@link View} specialization that adds Android events.
 */
public interface AndroidView extends View {
	android.view.View asNative();

	boolean onPrepareOptionsMenu(Menu menu);

	boolean onCreateOptionsMenu(Menu menu);

	boolean onOptionsItemSelected(MenuItem item);

	void onCreateContextMenu(ContextMenu menu, android.view.View v,
			ContextMenuInfo menuInfo);

	boolean onContextItemSelected(MenuItem item);
	
	//Activity LifeCycle
	void onStart();
	void onResume();
	void onPause();
	void onDestroy();
	void onRestart();
}
