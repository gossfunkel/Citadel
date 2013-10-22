package uk.co.gossfunkel.citadel.entity.exporbs;

import java.util.Random;

import uk.co.gossfunkel.citadel.entity.Entity;

public abstract class ExpOrb extends Entity {
	
	protected int dx, dy;
	protected int value;
	protected Random random;
	
	public ExpOrb() {
		random = new Random();
	}
	
	public int getVal() {
		return value;
	}

}
