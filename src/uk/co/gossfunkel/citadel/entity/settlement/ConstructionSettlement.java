package uk.co.gossfunkel.citadel.entity.settlement;

import org.lwjgl.util.vector.Vector3f;

import uk.co.gossfunkel.citadel.SoundEffect;
import uk.co.gossfunkel.citadel.entity.Entity;
import uk.co.gossfunkel.citadel.net.packets.Packet04Settlement;

public class ConstructionSettlement extends Entity {
	
	protected int level;
	private int progress = 0;
	private String maker;

	public ConstructionSettlement(Vector3f pos, String usnm) {
		maker = usnm;
		this.pos = pos;
		//TODO Packet04Settlement packet = new Packet04Settlement(game.username(),
		//													this.x, this.y);
		//TODO packet.writeData(game.getClient());
		SoundEffect.CONSTRUCT.play();
	}
	
	// -------------------- methods -------------------------------------------
	
	@Override
	public void update() {
		progress++;
		if (progress > 1000) complete();
	}
	
	private void complete() {
		Settlement s = new Settlement(pos, maker);
		//TODO game.addSett(s);
		//game.removeConSett(this);
	}

}
