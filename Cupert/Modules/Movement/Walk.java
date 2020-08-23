package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;

import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
public class Walk extends Modules
{
	//supports the module array in the class modules
public Walk() {
	super("Walk", "Walk",Keyboard.KEY_NONE, Categories.MOVEMENT);
	}

//disable & enable function
	public void onEnable()
	{
		mc.gameSettings.keyBindForward.pressed = true;
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		NotificationManager.update();
	}
	public void onDisable() 
	{
		mc.gameSettings.keyBindForward.pressed = false;
		
	}
	
//checking if is is before or after
     public void onEvent(event e) 
     {
         if(e instanceof EventUpdate) 
	     {
        	 String y  = String.valueOf(mc.thePlayer.motionY);
     		Client.addChatMessage(y);
		 }
	 }
}
