package uk.co.gossfunkel.citadel.graphics;

import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FOG;
import static org.lwjgl.opengl.GL11.GL_FOG_COLOR;
import static org.lwjgl.opengl.GL11.GL_FOG_DENSITY;
import static org.lwjgl.opengl.GL11.GL_FOG_END;
import static org.lwjgl.opengl.GL11.GL_FOG_HINT;
import static org.lwjgl.opengl.GL11.GL_FOG_MODE;
import static org.lwjgl.opengl.GL11.GL_FOG_START;
import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glFog;
import static org.lwjgl.opengl.GL11.glFogf;
import static org.lwjgl.opengl.GL11.glFogi;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.newdawn.slick.Color;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.vector.Vector3f;

public class Graphics {
	
	private Camera cam;
    private static final Color fogColor = new Color(0f, 0f, 0f, 1f);
    private float fogNear = 9f;
    private float fogFar = 20f;
	
	public Graphics(Camera cam) {
		this.cam = cam;
		
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Citadel ||| pre-alpha 0.0.1");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		initOpenGL();
		
		Vector3f pos = null;
		
		while (!Display.isCloseRequested()) {
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			pos = cam.getPosition();
			glTranslatef(pos.getX(), pos.getY(), pos.getZ());
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}

	private void initOpenGL() {
		if (!GLContext.getCapabilities().OpenGL11) {
            System.err.println("Your OpenGL version doesn't support the required functionality.");
            Display.destroy();
            System.exit(1);
        }

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(30, (float) Display.getWidth() / (float) Display.getHeight(), fogNear, fogFar);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glEnable(GL_ALPHA_TEST);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glEnable(GL_FOG);
        
        {
            FloatBuffer fogColours = BufferUtils.createFloatBuffer(4);
            fogColours.put(new float[]{fogColor.r, fogColor.g, fogColor.b, fogColor.a});
            glClearColor(fogColor.r, fogColor.g, fogColor.b, fogColor.a);
            fogColours.flip();
            glFog(GL_FOG_COLOR, fogColours);
            glFogi(GL_FOG_MODE, GL_LINEAR);
            glHint(GL_FOG_HINT, GL_NICEST);
            glFogf(GL_FOG_START, fogNear);
            glFogf(GL_FOG_END, fogFar);
            glFogf(GL_FOG_DENSITY, 0.005f);
        }
	}

}
