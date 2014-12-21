package org.saguez;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends Activity {
	private GLView mView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		try {			
			mView = new GLView(this);
			GLView view2 = new GLView(this);
			GLView view1 = new GLView(this);

			view1.setHeight(400);
			view1.setWidth(450);
//			view1.setX(50);
//			view1.setY(50);

			view2.setHeight(700);
			view2.setWidth(650);
			view2.setX(250);
			view2.setY(250);

			mView.addGLView(view2);
			view2.addGLView(view1);

			setContentView(mView.getLayout());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		mView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mView.onResume();
	}
}
