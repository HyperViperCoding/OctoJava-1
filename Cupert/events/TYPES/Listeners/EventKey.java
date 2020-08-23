package Cupert.events.TYPES.Listeners;

import Cupert.events.event;

public class EventKey extends event<EventKey>{
   public int code;
   public EventKey(int code) {
	   this.code = code;
   }
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
   
   
}
