package Cupert.Modules.Movement.Player;

import org.lwjgl.input.Keyboard;

import Cupert.Modules.Modules;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;

public class Timer extends Modules {
	    public Timer() {
	        super("Timer", "Timer",Keyboard.KEY_PERIOD, Categories.PLAYER);
	    }
public void onEnable() {
	    mc.timer.timerSpeed = 0.3F;
	    NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		NotificationManager.update();
	   
	}
public void onDisable() {
	mc.timer.timerSpeed = 1;
}
	    
}


