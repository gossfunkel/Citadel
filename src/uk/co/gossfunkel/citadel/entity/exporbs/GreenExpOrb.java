package uk.co.gossfunkel.citadel.entity.exporbs;

import java.util.logging.Level;

import org.lwjgl.opengl.XRandR.Screen;
import org.lwjgl.util.vector.Vector3f;

public class GreenExpOrb extends ExpOrb {
	
	public GreenExpOrb(Vector3f pos) {
		this(pos, 10);
	}
	
	public GreenExpOrb(Vector3f pos, int i) {
		super();
		//dx = x+random.nextInt(20);
		//dy = y+random.nextInt(20);
		value = i;
	}
	
	@Override
	public void update() {
		/*TODO
		 * if (x > dx) {
			x--;
		} else if (x < dx) {
			x++;
		}
		if (y > dy) {
			y--;
		} else if (y < dy) {
			y++;
		}*/
	}

}
