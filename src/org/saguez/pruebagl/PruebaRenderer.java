/**
 * 
 */
package org.saguez.pruebagl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

/**
 * @author daniel
 *
 */
public class PruebaRenderer implements GLSurfaceView.Renderer {
	private final static String TAG = "PhoenixRenderer";
	private final PruebaGLView mPruebaGLView;
	/**
	 * @param pruebaGLView 
	 * 
	 */
	public PruebaRenderer(PruebaGLView pruebaGLView) {
		mPruebaGLView=pruebaGLView;
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onSurfaceCreated(javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig)
	 */
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		if (gl instanceof GLES20) {
            int value[] = new int[1];
            GLES20.glGetIntegerv(GLES20.GL_SAMPLES, value, 0);
        }
		gl.glClearStencil(0);
        gl.glClear(GL10.GL_STENCIL_BUFFER_BIT);
		
		GLES20.glClearColor(1.0f, 0.612f, 0.192f, 0.80f);
		//init((FullscreenActivity)mPruebaGLView.getContext());
		Log.i(TAG, "...onSurfaceCreated");
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.microedition.khronos.opengles.GL10, int, int)
	 */
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
		Log.i(TAG, "...onSurfaceChanged("+Integer.valueOf(width).toString()+","+Integer.valueOf(height)+")");
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onDrawFrame(javax.microedition.khronos.opengles.GL10)
	 */
	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
	}
}
