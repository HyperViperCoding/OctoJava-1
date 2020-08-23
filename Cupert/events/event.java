package Cupert.events;

import Cupert.events.TYPES.eventTypes;

import Cupert.events.TYPES.eventdirection;

public class event<T> {
public boolean cancelled;
public eventTypes type;
public eventdirection direction;

public boolean isCancelled() {
	return cancelled;
}
public void setCancelled(boolean cancelled) {
	this.cancelled = cancelled;
}
public eventTypes getType() {
	return type;
}
public void setType(eventTypes type) {
	this.type = type;
}
public eventdirection getDirection() {
	return direction;
}
public void setDirection(eventdirection direction) {
	this.direction = direction;
}
public boolean isPre() {
	if (type == null) 
		
		return false;
		return type == eventTypes.PRE;
}
public boolean isPost() {
	if (type == null) 
		
		return false;
		return type == eventTypes.POST;
}
public boolean isIncoming() {
	if (direction == null) 
		
		return false;
		return direction == eventdirection.INCOMING;
}
public boolean isOutgoing() {
	if (direction == null) 
		
		return false;
		return direction == eventdirection.OUTGOING;
}
}
