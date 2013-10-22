package uk.co.gossfunkel.citadel.io;

import org.lwjgl.input.Keyboard;

public class Keys {
	
	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;
	private static boolean space;
	
	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP) 
				|| Keyboard.isKeyDown(Keyboard.KEY_W)) {
			up = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) 
				|| Keyboard.isKeyDown(Keyboard.KEY_A)) {
			left = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) 
				|| Keyboard.isKeyDown(Keyboard.KEY_D)) {
			right = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) 
				|| Keyboard.isKeyDown(Keyboard.KEY_S)) {
			down = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			space = true;
		}
	}

	public static boolean isUp() {
		return up;
	}

	public static boolean isDown() {
		return down;
	}

	public static boolean isLeft() {
		return left;
	}

	public static boolean isRight() {
		return right;
	}

	public static boolean isSpace() {
		return space;
	}

}
