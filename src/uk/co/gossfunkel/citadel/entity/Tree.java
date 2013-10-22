package uk.co.gossfunkel.citadel.entity;

import java.awt.Rectangle;

import org.lwjgl.util.vector.Vector3f;

public class Tree {
	
	private Vector3f pos;
	private Rectangle boundingBox; //TODO this

	private int brokenness = 0;
	
	public Tree(Vector3f pos) {
		this.pos = pos;
	}
	
	/*public void render(Screen screen, Level level) {
		tile.render(coord, screen);
		this.level = level;
	}*/
	
	public Vector3f getPos() {
		return pos;
	}
	
	public Rectangle getRect() {
		return boundingBox;
	}

	public void damage() {
		System.out.println("brokenness: " + brokenness);
		brokenness++;
		if (brokenness > 100) {
			//TODO collapse();
		}
	}
	
	/*TODO add treeDeath to level
	 * public void collapse() {
	 *
		level.treeDeath(coord);
	}*/

}
