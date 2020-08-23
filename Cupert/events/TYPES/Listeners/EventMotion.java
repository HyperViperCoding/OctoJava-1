package Cupert.events.TYPES.Listeners;

import Cupert.events.event;

public class EventMotion extends event<EventMotion>{
	public double x, y, z;
	public float yaw, pitch;
	public boolean Onground;
	public EventMotion(double x, double y, double z, float yaw, float pitch, boolean onground) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		Onground = onground;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public float getYaw() {
		return yaw;
	}
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	public float getPitch() {
		return pitch;
	}
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	public boolean isOnground() {
		return Onground;
	}
	public void setOnground(boolean onground) {
		Onground = onground;
	}
	
	
	
}
