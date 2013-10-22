package uk.co.gossfunkel.citadel.entity.mob;

import java.net.InetAddress;

import org.lwjgl.util.vector.Vector3f;

import uk.co.gossfunkel.citadel.Game;
import uk.co.gossfunkel.citadel.Timer;

public class OnlinePlayer {

	public InetAddress ip;
	public int port;
	
	private Vector3f pos;

	public OnlinePlayer(Timer timer, String username,
			InetAddress ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	// spawn locale constructor
	public OnlinePlayer(Vector3f pos, Timer timer, String username, 
			InetAddress ip, int port) {
		this(timer, username, ip, port);
		teleport(pos); 
	}

	/*
	@Override
	public void update() {
		super.update();
	}*/
	
	/*TODO
	public void move(int xa, int ya) {
	
		super.move(xa, ya);
		Packet02Move packet = new Packet02Move(username, xa, ya);
		packet.writeData(game.getClient());
	}*/
	
	private void teleport(Vector3f pos) {
		//TODO check if permitted
		this.pos = pos;
	}
	
}
