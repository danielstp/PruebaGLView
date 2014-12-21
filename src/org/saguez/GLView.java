/**
 * 
 */
package org.saguez;

import java.util.Vector;

import android.content.Context;
import android.graphics.PixelFormat;

import javax.microedition.khronos.egl.EGLContext;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;

/**
 * @author Daniel Saguez
 *
 */
public class GLView extends GLSurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder mHolder = null;
	private GLRenderer mRenderer = null;
	private ContextFactory mContextFactory = null;
	private FrameLayout mLayout = null;
	private Vector<GLView> mChilds = null;

	/**
	 * @param context
	 */
	public GLView(Context context) {
		super(context);
		attach(true, 0, 8);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public GLView(Context context, AttributeSet attrs) {
		super(context, attrs);
		attach(true, 0, 8);
	}

	private EGLContext attach(boolean translucent, int i, int j) {
		mChilds = new Vector<GLView>();
		mLayout = new FrameLayout(this.getContext());
		mHolder = getHolder();
		mHolder.addCallback(this);
		mContextFactory = new ContextFactory();
		mRenderer = new GLRenderer(this);
		setEGLContextClientVersion(2);
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
			setEGLConfigChooser(8, 8, 8, 8, 0, 8);
		} else {
			setEGLConfigChooser(new ConfigChooser());
		}

		/*
		 * By default, GLSurfaceView() creates a RGB_565 opaque surface. If we
		 * want a translucent one, we should change the surface's format here,
		 * using PixelFormat.TRANSLUCENT for GL Surfaces is interpreted as any
		 * 32-bit surface with alpha by SurfaceFlinger.
		 */
		if (translucent) {
			mHolder.setFormat(PixelFormat.TRANSLUCENT);
		}
		/*
		 * Setup the context factory for 2.0 rendering. See ContextFactory class
		 * definition below
		 */
		setEGLContextFactory(mContextFactory);
		int depth = 0;
		int stencil = 0;
		/*
		 * We need to choose an EGLConfig that matches the format of our surface
		 * exactly. This is going to be done in our custom config chooser. See
		 * ConfigChooser class definition below.
		 */
		setEGLConfigChooser(translucent ? new ConfigChooser(8, 8, 8, 8, depth,
				stencil) : new ConfigChooser(5, 6, 5, 0, depth, stencil));

		setRenderer(mRenderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		mLayout.addView(this);

		return mContextFactory.getLastContext();
	}
	
	public FrameLayout getLayout() {
		return mLayout;
	}
	
	public void setHeight(int h) {
		getLayoutParams().height = h;
	}
	
	public void setWidth(int w) {
		getLayoutParams().width = w;
	}
	
	public void addGLView(GLView glview) {
		if(this == glview) return;
		mChilds.add(glview);
		orderGLViews();
	}
	
	public void orderGLViews() {
		mLayout.removeAllViews();
		for(int d = mChilds.size();d>0;d--) {
			GLView o = mChilds.get(d-1);
			mLayout.addView(o.getLayout());
			o.setX(o.getX()+getX());
			o.setY(o.getY()+getY());
			o.orderGLViews();
		}
		mLayout.addView(this);
	}
}
