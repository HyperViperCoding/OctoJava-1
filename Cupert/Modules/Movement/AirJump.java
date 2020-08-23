package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;


  

import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;

public class AirJump extends Modules
{
	//supports the module array in the class modules
public AirJump() {
	super("Airjump", "Airjump",Keyboard.KEY_NONE, Categories.MOVEMENT);
	}

//disable & enable function
	public void onEnable()
	{

		NotificationManager.show(new Notification(null, "Octo Client", "Airjump Has been toggled", 54));
		NotificationManager.update();
	
	}
	public void onDisable() 
	{
		
				
	}
	public void onEvent(event e) {
		if(e instanceof EventMotion) {
			if(mc.thePlayer.isAirBorne = true) {
				mc.thePlayer.onGround = true;
			}
		}
	}
	
//checking if is is before or after
	
     
	 
}
