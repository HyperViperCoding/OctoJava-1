package Cupert.Modules.Render;
import org.lwjgl.input.Keyboard;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
public class FullBright extends Modules
{
	
	//supports the module array in the class modules
public FullBright() {
	super("Fullbright", "Fullbright",Keyboard.KEY_NONE, Categories.RENDER);
	}

     int oldBrightness = (int) mc.gameSettings.gammaSetting;

//disable & enable function
	public void onEnable()
	{
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		NotificationManager.update();
	mc.gameSettings.gammaSetting = 100;
	
	}
	public void onDisable() 
	{
		mc.gameSettings.gammaSetting = oldBrightness;
	}
	
}
