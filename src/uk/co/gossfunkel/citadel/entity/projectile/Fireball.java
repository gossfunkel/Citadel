package uk.co.gossfunkel.citadel.entity.projectile;

import org.lwjgl.util.vector.Vector3f;

public class Fireball extends Projectile {

	public Fireball(Vector3f pos, double dir) {
		super(pos, dir);
		range = 400 + random.nextInt(100);
		speed = 5;
		damage = 5;
		rate = 3;
		
		nx = Math.cos(angle) * speed;
		ny = Math.sin(angle) * speed;
	}

}
