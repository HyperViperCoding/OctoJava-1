package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;



  

import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
public class CreativeFly extends Modules
{
	//supports the module array in the class modules
public CreativeFly() {
	super("CreativeFly", "CreativeFly",Keyboard.KEY_G, Categories.MOVEMENT);
	}

//disable & enable function
	public void onEnable()
	{
		NotificationManager.show(new Notification(null, "Octo Client", "CreativeFly Has been toggled", 54));

		mc.thePlayer.capabilities.isFlying = true;
		mc.thePlayer.capabilities.allowFlying = true;
			
				
    
   	 }
	
	
	public void onDisable() 
	{
		double lastY = mc.thePlayer.posY;
		double lastX = mc.thePlayer.posX;
		double lastZ = mc.thePlayer.posZ;

		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
			
				
	}
	
//checking if is is before or after
     
	 
}
