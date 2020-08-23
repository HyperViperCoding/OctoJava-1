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
import Cupert.util.Timer;
public class Spammer extends Modules
{
	public int count1 = 0;
	public String msg = "U SUCK ";
	//supports the module array in the class modules
public Spammer() {
	super("Spammer", "Spammer",Keyboard.KEY_NONE, Categories.MEMES);
}


//disable & enable function

		
	
	
//checking if is is before or after
     public void onEvent(event e) 
     {
         if(e instanceof EventUpdate) 
	     {
        	
        
	     String count = String.valueOf(count1);
	     if(count1 > 100) {
	    	 msg = "U SUCK 2 MUCH ";
	     }
	     if(count1 > 200) {
	    	 msg = "UR TRASH ";
	     }
	     if(count1 > 100) {
	    	 msg = "U SUCK 2 MUCH ";
	     }
	     if(count1 > 500) {
	    	 msg = "L DOOO DOOO ";
	     }
	     if(count1 > 1000) {
	    	 msg = "BOTTTTT";
	     }
		    if(Timer.hasElapsed(1500, true)) {
		    	
		    	mc.thePlayer.sendChatMessage(msg+ count1);
		    	count1++;
		    	System.out.println(count1);
		    }
	 }
}

	
//checking if is is before or after
   
}