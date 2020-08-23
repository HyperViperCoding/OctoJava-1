package Cupert.Modules.Memes;
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
public class Kermit extends Modules
{
	//supports the module array in the class modules
public Kermit() {
	super("Kermit", "Kermit",Keyboard.KEY_NONE, Categories.MEMES);
}


//disable & enable function

		
	public void onEnable()
	{
		 mc.thePlayer.sendChatMessage("Kermit The Frog Here!");
		 this.toggle();
	}
	
//checking if is is before or after
     public void onEvent(event e) 
     {
         if(e instanceof EventUpdate) 
	     {
		     if (e.isPre()) {
				 mc.thePlayer.sendChatMessage("Kermit The Frog Here!");
				 this.toggle();
		 }
	 }
}

	
//checking if is is before or after
   
}