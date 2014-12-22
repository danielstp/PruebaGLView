package org.saguez;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;

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
			view2.addGLView(view1);
			mView.addGLView(view2);
			setContentView(mView.getLayout());

			EditText editBox = new EditText(getApplicationContext());
			view2.getLayout().addView(editBox);
			editBox.setText("Phoenix Native Text");
			editBox.getLayoutParams().height=-2;
			editBox.getLayoutParams().width=-2;
			editBox.setY(5);
			editBox.setX(15);
			
			EditText editBox1 = new EditText(getApplicationContext());
			mView.getLayout().addView(editBox1);
			editBox1.setText("Phoenix Native Text");
			editBox1.getLayoutParams().height=-2;
			editBox1.getLayoutParams().width=-2;
			editBox1.setY(50);
			
			EditText editBox2 = new EditText(getApplicationContext());
			view1.getLayout().addView(editBox2);
			editBox2.setText("Phoenix Native Text");
			editBox2.getLayoutParams().height=-2;
			editBox2.getLayoutParams().width=-2;
			editBox2.setY(150);

			view1.setHeight(400);
			view1.setWidth(450);
			view1.setX(25);
			view1.setY(25);

			view2.setHeight(700);
			view2.setWidth(650);
			view2.setX(250);
			view2.setY(250);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
//		mView.onPause();
	}

	@Override
	protected void onResume() {
//		mView.onResume();
		super.onResume();
	}
}
