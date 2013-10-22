package uk.co.gossfunkel.citadel.graphics;

import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
    private Vector3f position;
    private float yaw   = 0.0f; // rotation on Y axis
    private float pitch = 0.0f; // rotation on X axis
    
    public Camera (float x, float y, float z) {
        position = new Vector3f(x, y, z);
    }
    
    public void yaw(float amount) {
        yaw += amount;
    }
    
    public void pitch(float amount) {
        pitch += amount;
    }
    
    public void walkForward(float distance) {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    }
    
    public void walkBackwards(float distance) {
        position.x += distance * (float)Math.sin(Math.toRadians(yaw));
        position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    }
    
    public void strafeLeft(float distance) {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
    }
    
    public void strafeRight(float distance) {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
    }

	public Vector3f getPosition() {
		return position;
	}

}
