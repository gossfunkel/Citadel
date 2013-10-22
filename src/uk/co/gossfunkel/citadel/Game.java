package uk.co.gossfunkel.citadel;
import org.lwjgl.opengl.Display;

import uk.co.gossfunkel.citadel.entity.mob.Player;
import uk.co.gossfunkel.citadel.graphics.Camera;
import uk.co.gossfunkel.citadel.graphics.Graphics;


public class Game {
	
	public static void main(String[] args) {
		new Game();
	}
	
	private Player local;
	private Camera cam;
	private Graphics g;
	private String username;
	private Timer timer;
	private final String TITLE = "Citadel ||| pre-alpha 0.0.1";
	private int ticker = 0;
	
	public Game() {
		cam = new Camera(0, 0, 0);
		local = new Player(cam);
		g = new Graphics(cam);
		timer = new Timer();
		
		while (!Display.isCloseRequested()) {
			timer.tick();
			if (System.currentTimeMillis() - getTimer().getSecond() > 1000) {
				// every second, add a second, print fps and mod title with fps
				getTimer().accumulateSecond();
				//System.out.println(getTimer().returnFPS());
				Display.setTitle(TITLE + "  |  " + getTimer().returnFPS());
				getTimer().resetTick();
				ticker++;
			}
			while (getTimer().getDelta() >= 1) {
				// every time delta goes greater than one, update and supertick
				update();
				getTimer().superTick();
			}
			if (getTimer().getFPS() > 100) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					System.err.println("Sleeping failed: " + e);
				}
			}
			if (ticker > 30) {
				ticker = 0;
				getTimer().hourTick();
			}
		}
	}
	
	private void update() {
		//TODO update
	}
	
	public String username() {
		return username;
	}
	
	public Timer getTimer() {
		return timer;
	}

}
