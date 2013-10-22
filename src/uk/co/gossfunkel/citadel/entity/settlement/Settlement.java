package uk.co.gossfunkel.citadel.entity.settlement;

import org.lwjgl.opengl.XRandR.Screen;
import org.lwjgl.util.vector.Vector3f;

import uk.co.gossfunkel.citadel.entity.Entity;

public class Settlement extends Entity {
	
	protected int level;
	protected int xp;
	protected String owner;

	public Settlement(Vector3f pos, String usnm) {
		System.out.println("Making new Hamlet\n" + pos);
		owner = usnm;
	}
	
	// -------------------- methods -------------------------------------------
	
	@Override
	public void update() {
		xp++;
		if (xp > 5000) {
			levelUp();
		}
	}
	
	public void levelUp() {
		//TODO add level states
		level++;
		if (level%10==0) {
			if (level == 10) {
			} else if (level > 29) {
			}
		}
	}
}
