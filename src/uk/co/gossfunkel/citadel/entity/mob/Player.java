package uk.co.gossfunkel.citadel.entity.mob;

import uk.co.gossfunkel.citadel.graphics.Camera;
import uk.co.gossfunkel.citadel.io.Keys;

import org.lwjgl.util.vector.Vector3f;

public class Player {
	
	Vector3f pos;		// current player position
	Camera cam;
	
	float speed;
	
	public Player(Camera cam) {
		this.cam = cam;
		pos = new Vector3f(0,0,0);
		speed = 1.0f;
	}
	
	public void update() {
		if (Keys.isUp()) {
			moveForward();
		}
		if (Keys.isDown()) {
			moveBackward();
		}
		if (Keys.isLeft()) {
			moveLeft();
		}
		if (Keys.isRight()) {
			moveRight();
		}

		/*TODO jumping
		if (Keys.isSpace()) {
			moveUp();
		}*/
		
	}

	private void moveForward() {
		//TODO collision detection
		cam.walkForward(speed);
	}

	private void moveBackward() {
		//TODO collision detection
		cam.walkBackwards(speed);
	}
	
	private void moveLeft() {
		//TODO collision detection
		cam.strafeLeft(speed);
	}

	private void moveRight() {
		//TODO collision detection
		cam.strafeRight(speed);
	}

}
