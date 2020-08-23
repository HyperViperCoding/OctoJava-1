package Cupert.events.TYPES.Listeners;

import Cupert.events.event;
import net.minecraft.network.Packet;

public class onPacket extends event {
	private Packet packet;

	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}
	public onPacket(Packet packet) {
		this.packet = packet;
	}
	

}
