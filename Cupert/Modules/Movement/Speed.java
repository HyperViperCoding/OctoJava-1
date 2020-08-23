package Cupert.Modules.Movement;

import org.lwjgl.input.Keyboard;

import Cupert.Modules.Modules;
import Cupert.commands.Modes;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.util.MoveUtil;
import Cupert.util.Timer;

public class Speed extends Modules {

	public Speed() {
		
		super("Speed", "Speed", Keyboard.KEY_V, Categories.MOVEMENT);
		// TODO Auto-generated constructor stub
	}
	public static String mode;
	public void onEvent(event e) {
		if(e instanceof EventMotion && mc.gameSettings.keyBindForward.pressed || mc.gameSettings.keyBindLeft.pressed || mc.gameSettings.keyBindRight.pressed || mc.gameSettings.keyBindBack.pressed && !mc.gameSettings.keyBindSneak.pressed) {
			if(Modes.speedmode == 3) {
				double direction = MoveUtil.instance.getDirection();
				double speed = 0.7;
				mc.timer.timerSpeed = 1;
				mc.thePlayer.motionX = -Math.sin(direction) * speed / 1.5;
				mc.thePlayer.motionZ = Math.cos(direction) * speed / 1.5;
				if(mc.thePlayer.onGround) {
					mc.thePlayer.jump();
				}
				
				this.arrayname = "Speed \u00A77"  + "Hop";
				this.mode = "SlowHop";
			}
				
			}else if (Modes.speedmode == 4 && mc.gameSettings.keyBindForward.pressed) {
				double direction = MoveUtil.instance.getDirection();
				double speed = 0.899609999995555543934246432;
				mc.timer.timerSpeed = 1.05F;
				mc.thePlayer.motionX = -Math.sin(direction) * speed;
				mc.thePlayer.motionZ = Math.cos(direction) * speed;
				this.mode = "Normal";
				this.arrayname = "Speed \u00A77"  + "Normal";
			}
				
		
		
			
			}
	public void onUpdate() {
		
			this.name = "Speed \u00A77"  + mode;
		
		Timer.reset();
		
	}
	public void onDisable() {
		mc.timer.timerSpeed = 1;
	}
	public void onEnable() {
		
		NotificationManager.show(new Notification(null, "Octo Client", "Speed Has been toggled", 54));
		NotificationManager.update();
	}

}
