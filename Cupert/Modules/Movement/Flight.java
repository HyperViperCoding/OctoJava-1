package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;

import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.commands.Modes;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.util.MoveUtil;
import Cupert.util.Timer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;

public class Flight extends Modules
{
	

public boolean Damaged;
public double tvalue;
//disable & enable function
private int boostHypixelState = 1;
private final float aacMotion2 = 7f;
public static String Mode;


public Flight() {
		super("Flight", "Flight",Keyboard.KEY_F, Categories.MOVEMENT);
		}
public void onEnable(){//checking if is is before or after
	  double fallDistance = 3.0125; //add 0.0125 to ensure we get the fall dmg

      while (fallDistance > 0) {

          mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, mc.thePlayer.posY + 0.0624986421, mc.thePlayer.posZ, false));

          mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, mc.thePlayer.posY + 0.0625      , mc.thePlayer.posZ, false));

          mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, mc.thePlayer.posY + 0.0624986421, mc.thePlayer.posZ, false));

          mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, mc.thePlayer.posY + 0.0000013579, mc.thePlayer.posZ, false));

          fallDistance -= 0.0624986421;

      }
      
      if(Mode== "NewHyp") {
    	  
      }
}
public void onDisable() {
	mc.timer.timerSpeed = 1;
}


	 public void onEvent(event e) 
     {
		double motionY = mc.thePlayer.motionY;
		EntityRenderer renderer = new EntityRenderer(mc, null);
	
		boolean onGround  = mc.thePlayer.onGround;


		 if(Modes.mode == 0) {
			 Mode = ("Normal");
			 mc.thePlayer.cameraYaw = 0.10090807f;
			 int states = 0;
			
			 if(mc.thePlayer.onGround) {
				 mc.thePlayer.jump();
			 }else {
				 mc.thePlayer.motionY = 0;
				
				if(e.isPre()) {
					 mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + (1.0E-12D), mc.thePlayer.posZ);
				}else if(e.isPost()) {
			
					 mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY - (1.0E-12D), mc.thePlayer.posZ);
				
				 }
			 }
			 this.arrayname = "Flight \u00A77"  + "Normal";
		 }else if(Modes.mode == 1) {
			 Mode = ("MCCentral");
			 double y;

			 boolean KeyJumpDown = Keyboard.isKeyDown(Keyboard.KEY_SPACE);

			 boolean KeyCrouchDown = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);

			 if(e instanceof EventMotion) {

				 if(mc.thePlayer.onGround = true) {

					 mc.thePlayer.jump();

				 }

				 if(mc.thePlayer.isAirBorne) {
				
					 mc.thePlayer.motionY = 0;

					 mc.thePlayer.setPosition(mc.thePlayer.posX , KeyCrouchDown ?  mc.thePlayer.posY - 1 : mc.thePlayer.posY , mc.thePlayer.posZ);

				 }
				
		 }
			 this.arrayname = "Flight \u00A77"  + "MCcentral";
}
		 if(Modes.mode == 2) {
			 
			 Mode = ("Glide");
			 if(mc.thePlayer.isAirBorne) {
				 
				 mc.thePlayer.connection.sendPacket(new CPacketPlayer(true));
				 if(mc.thePlayer.fallDistance > 0.03){
					 mc.thePlayer.fall(1, 3);
				 }
				 if(mc.thePlayer.moveForward > 0) {
				
					 mc.thePlayer.motionY = 0.000021;
					 if(Timer.hasElapsed(100, false)) {
						 mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
					 }
					 Timer.reset();
				 }
			 }
			 this.arrayname = "Flight \u00A77"  + "Glide";

       

			}else if(Modes.mode == 3) {
				  Mode = ("Fast");
				  this.arrayname = "Flight \u00A77"  + "Fast";
				 
				  mc.thePlayer.cameraYaw = 0.10090807f;
				  int boost = 1;
				  if(mc.thePlayer.isAirBorne) {
					  mc.thePlayer.motionY = 0;
					  if(mc.gameSettings.keyBindForward.pressed) {
						  MoveUtil.instance.setPosition(1, 0); 
					  }
				  }          
			}else if(Modes.mode == 4) {
				  double y;
				  mc.thePlayer.connection.sendPacket(new CPacketAnimation());
		            double y1;
		            mc.thePlayer.cameraYaw = 0.10090807f;
		            mc.thePlayer.motionY = 0;
		            if(mc.thePlayer.ticksExisted % 3 == 0) {
                    y = mc.thePlayer.posY - 1.0E-10D;
		                mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, y, mc.thePlayer.posZ, true));
		            }
		            y1 = mc.thePlayer.posY + 1.0E-10D;
		            mc.thePlayer.setPosition(mc.thePlayer.posX, y1, mc.thePlayer.posZ);
		        	this.arrayname = "Flight \u00A77"  + "Hyp";
		        }else if(Modes.mode == 5) {
		        	double posX = MoveUtil.instance.getPosForSetPosX(3.2);
		        	double posZ = MoveUtil.instance.getPosForSetPosZ(3.2);
		        	mc.thePlayer.motionY = 0;
		        	if(Timer.hasElapsed(300, true) && mc.gameSettings.keyBindForward.pressed) {
		        		mc.thePlayer.setPosition(mc.thePlayer.posX + posX, mc.thePlayer.posY, mc.thePlayer.posZ + posZ);
		        		
		        	}
		        	if(mc.thePlayer.isAirBorne) {
		        		mc.thePlayer.onGround = true;
		        	}
		        
		        	this.arrayname = "Flight \u00A77" + "Tele";
		        }else if(Modes.mode == 6) {
		        		
			        	mc.thePlayer.motionY = 0;
			        	mc.thePlayer.onGround = true;
			        	mc.thePlayer.cameraYaw = 0.10090807f;
			        	
		        		this.arrayname = "Flight \u00A77" + "Airwalk";
		              }
		        	}
		        	
					
			
			
			 
     }

	

