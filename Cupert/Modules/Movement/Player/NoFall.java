package Cupert.Modules.Movement.Player;
import org.lwjgl.input.Keyboard;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import net.minecraft.network.play.client.CPacketPlayer;
public class NoFall extends Modules
{
	//supports the module array in the class modules
public NoFall() {
	super("NoFall", "NoFall",Keyboard.KEY_Y, Categories.PLAYER);
	}

//disable & enable function
	
	public void onEnable() {
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		NotificationManager.update();
	}
	  public void onEvent(event e) 
	     {
	         
			     if(this.toggled) {
			    	 if(mc.thePlayer.fallDistance > 2F) {
			    		 mc.thePlayer.connection.sendPacket(new CPacketPlayer(true));
			    	   
			     
			    	 }
	 
}}}
