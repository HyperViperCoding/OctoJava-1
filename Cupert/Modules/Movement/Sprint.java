package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
public class Sprint extends Modules
{
	//supports the module array in the class modules
public Sprint() {
	super("Sprint", "Sprint",Keyboard.KEY_N, Categories.MOVEMENT);
	}

//disable & enable function
	public void onEnable()
	{
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		NotificationManager.update();
		mc.gameSettings.keyBindSprint.pressed = true;
	}
	public void onDisable() 
	{
		mc.gameSettings.keyBindSprint.pressed = false;
	}
	
//checking if is is before or after
     public void onEvent(event e) 
     {
         if(e instanceof EventUpdate) 
	     {
		     
		 }
	 }
}
