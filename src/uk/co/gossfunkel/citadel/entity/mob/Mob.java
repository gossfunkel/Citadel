package uk.co.gossfunkel.citadel.entity.mob;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import uk.co.gossfunkel.citadel.entity.Entity;
import uk.co.gossfunkel.citadel.entity.projectile.Projectile;

public abstract class Mob extends Entity {
	
	// -------------------- variables -----------------------------------------
	
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean swimming = false;
	
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	
	// -------------------- methods -------------------------------------------
	
	public void update() {}
	
	protected void move(Vector3f pos) {
		//TODO
	}

	private boolean collision() {
		//TODO
		return false;
	}
	
	protected void shoot(int x, int y, double d) {
		//TODO Projectile p = new Fireball(x + 6, y + 6, d);
		//projectiles.add(p);
	}

	// -------------------- getters -------------------------------------------
	
	
}
