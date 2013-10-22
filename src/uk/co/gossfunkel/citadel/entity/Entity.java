package uk.co.gossfunkel.citadel.entity;

import java.util.List;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

public abstract class Entity {
	
	// -------------------- variables -----------------------------------------
	
	protected Vector3f pos;
	protected int expDropVal;
	private boolean removed = false;
	protected final Random random = new Random();
	protected int SIZE;
	protected List<Entity> nearEntities;
	
	// -------------------- methods -------------------------------------------
	
	public void update() {}
	
	//public void render(Screen screen) {}
	
	public void dropExp() {
		// generate enough exp entities to distribute expVal
	}

	// -------------------- getters -------------------------------------------
	
	public boolean isRemoved() {
		return removed;
	}
	
	public Vector3f getPos() {
		return pos;
	}
	
	public int getSIZE() {
		return SIZE;
	}

	// -------------------- setters -------------------------------------------

	public void remove() {
		// destruction animation
		removed = true;
	}
	
	public void addNear(Entity e) {
		nearEntities.add(e);
	}
	
	public void teleport(Vector3f p) {
		this.pos = p;
		//System.out.println("> " + x + ", " + y);
	}

}
