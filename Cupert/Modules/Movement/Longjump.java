package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;

import Cupert.Modules.Modules;
import Cupert.commands.Modes;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.util.MoveUtil;
import net.minecraft.potion.Potion;
public class Longjump extends Modules
{
	//supports the module array in the class modules
public Longjump() {
	super("Longjump", "Longjump",Keyboard.KEY_J, Categories.MOVEMENT);
}
//checking if is is before or after

public void onEvent(event e) {
	if(e instanceof EventMotion) {
		if(Modes.JumpMode == 0) {
			 this.arrayname = "Longjump \u00A77"+"Normal";
			 float dir = mc.thePlayer.rotationYaw + ((mc.thePlayer.moveForward < 0) ? 180 : 0) + ((mc.thePlayer.moveStrafing > 0) ? (-90F * ((mc.thePlayer.moveForward < 0) ? -.5F : ((mc.thePlayer.moveForward > 0) ? .4F : 1F))) : 0);

	            float xDir = (float)Math.cos((dir + 90F) * Math.PI / 180);

	            float zDir = (float)Math.sin((dir + 90F) * Math.PI / 180);

	            if(mc.thePlayer.isCollidedVertically && (mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown()) && mc.gameSettings.keyBindJump.isKeyDown()) {

	                mc.thePlayer.motionX = xDir * .20F;

	                mc.thePlayer.motionZ = zDir * .20F;

	            }

	            if(mc.thePlayer.motionY == .33319999363422365 && (mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown())) {

	                if (mc.thePlayer.isPotionActive(Potion.getPotionById(8171462))) {

	                    mc.thePlayer.motionX = xDir * 1.34;

	                    mc.thePlayer.motionZ = zDir * 1.34;

	                } else {

	                    mc.thePlayer.motionX = xDir * 1.261;

	                    mc.thePlayer.motionZ = zDir * 1.261;

	                }
	               
	            }

	            }
		else if(Modes.JumpMode == 1) {
			  mc.thePlayer.jumpMovementFactor = 0.1F;

              mc.thePlayer.motionY += 0.0132099999999999999999999999999;

              mc.thePlayer.jumpMovementFactor = 0.09F;
              this.arrayname = "Longjump \u00A77"+ "Mineplex";
		}
		}
	}

	
public void onEnable() {
	
}
}
