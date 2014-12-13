/**
 * 
 */
package org.saguez.pruebagl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.opengl.GLSurfaceView.Renderer;

/**
 * @author daniel
 *
 */
public class PruebaRenderer implements Renderer {
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
		if (gl instanceof GL11) {
            int value[] = new int[1];
            ((GL11) gl).glGetIntegerv(GL11.GL_SAMPLES, value, 0);
        }
		gl.glClearStencil(0);
        gl.glClear(GL10.GL_STENCIL_BUFFER_BIT);
		//init((FullscreenActivity)mPruebaGLView.getContext());
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.microedition.khronos.opengles.GL10, int, int)
	 */
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		//update size
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onDrawFrame(javax.microedition.khronos.opengles.GL10)
	 */
	@Override
	public void onDrawFrame(GL10 gl) {
		// draw
	}
}
