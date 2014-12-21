/**
 * 
 */
package org.saguez;

import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

/**
 * @author daniel
 *
 */
public class GLRenderer implements Renderer {
	
	Vector<CustColor> mColors;
	static int c;
	/**
	 * @param glView 
	 * 
	 */
	public GLRenderer(GLView glView) {
		float alphaBase = 1	;
		mColors = new Vector<CustColor>();
		CustColor color = new CustColor();
		color.setAlpha(1f*alphaBase);
		color.setBlue(0.9f);
		color.setGreen(0.1f);
		color.setRed(0.1f);
		mColors.add(color);
		color = new CustColor();
		color.setAlpha(1f*alphaBase);
		color.setBlue(0.1f);
		color.setGreen(0.1f);
		color.setRed(0.9f);
		mColors.add(color);
		color = new CustColor();
		color.setAlpha(1f*alphaBase);
		color.setBlue(0.1f);
		color.setGreen(0.9f);
		color.setRed(0.9f);
		mColors.add(color);
		color = new CustColor();
		color.setAlpha(1f*alphaBase);
		color.setBlue(0.9f);
		color.setGreen(0.1f);
		color.setRed(0.9f);
		mColors.add(color);
		color = new CustColor();
		color.setAlpha(.61f*alphaBase);
		color.setBlue(0.1f);
		color.setGreen(0.9f);
		color.setRed(0.1f);
		mColors.add(color);
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onSurfaceCreated(javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig)
	 */
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearStencil(0);
        gl.glClear(GL10.GL_STENCIL_BUFFER_BIT);
		if( c >= mColors.size()) {
			c=0;
		}
		float red   = mColors.get(c).getRed();
		float green = mColors.get(c).getGreen();
		float blue  = mColors.get(c).getBlue();
		float alpha = mColors.get(c++).getAlpha();
		GLES20.glClearColor(red, green, blue, alpha);
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.microedition.khronos.opengles.GL10, int, int)
	 */
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
	}

	/* (non-Javadoc)
	 * @see android.opengl.GLSurfaceView.Renderer#onDrawFrame(javax.microedition.khronos.opengles.GL10)
	 */
	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
	}

}
