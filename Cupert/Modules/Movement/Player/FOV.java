package Cupert.Modules.Movement.Player;
import org.lwjgl.input.Keyboard;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
public class FOV extends Modules
{
	//supports the module array in the class modules
public FOV() {
	super("FOV", "FOV",Keyboard.KEY_C, Categories.RENDER);
	}
float oldFov = mc.gameSettings.fovSetting;

//disable & enable function
	public void onEnable()
	{
		mc.gameSettings.fovSetting = 10;
		
		
	}
	public void onDisable() 
	{
		mc.gameSettings.fovSetting = oldFov;
	}
	
}
