package uk.co.gossfunkel.citadel.entity.projectile;

import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Level;

import org.lwjgl.util.vector.Vector3f;

import uk.co.gossfunkel.citadel.entity.Entity;

public abstract class Projectile extends Entity {
	
	protected Vector3f pos;
	protected double angle;
	protected double nx, ny;
	protected double speed, damage, range;
	protected static double rate;
	protected int dir;
	
	protected final Random random = new Random();
	
	public Projectile(Vector3f pos, double a) {
		this.pos = pos;
		angle = a;
	}
	
	@Override
	public void update() {
		move((int)nx, (int)ny);
		//if (calculateDistance() > range) {
			//this.remove();
			// projectiles.remove();
		//}
	}
	
	protected void move(int xa, int ya) {
		//TODO
	}

	private boolean collision() {
		//TODO
		return false;
	}
	
	//private double calculateDistance() {
		//return Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x) + 
	//								(yOrigin - y)*(yOrigin - y)));
	//}

	public static double getRate() {
		return rate;
	}

}
