package Cupert.Modules.Combat;
import java.util.Comparator;


import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.util.Timer;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketUseEntity.Action;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;


public class BowAimbot extends Modules
{
	public Timer timer = new Timer();
	//supports the module array in the class modules
public BowAimbot() {
	super("BowAimbot", "BowAimbot",Keyboard.KEY_NONE, Categories.COMBAT);
	}
float cooldown = 0;
	public void isPost(event e) {
		if(e.isPost()) {
			
		}
	}
	public void onEnable() {
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 34));
	}
	 public void onEvent(event e) 
     {
	
			 
		 
		 
         if(e instanceof EventMotion) 
	     {
		     if (e.isPre()) {
		    	 EventMotion event = (EventMotion)e; 
		    
		    		List<Entity> targets = mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());


                   targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 15 && entity != mc.thePlayer && !entity.isInvisible() && entity.canBeAttackedWithItem()).collect(Collectors.toList());
                   targets.sort(Comparator.comparingDouble( entity -> ((Entity)entity).getDistanceToEntity(mc.thePlayer)));
                   if(!targets.isEmpty()){
                	  Entity target = targets.get(0);
                	  if((mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND) != null) && (mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemBow)) {
                		  mc.thePlayer.rotationYaw = (getRotations(target)[0]);
                		  mc.thePlayer.rotationPitch = (getRotations(target)[1]);        	  
                	  }        	  
                	  
                   
                   
                   }}}
		  
	     }
	 public float[] getRotations(Entity e) {
		  double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
				  deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
				  deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
				  distance = Math.sqrt(Math.pow(deltaX, 2) + (Math.pow(deltaZ, 2)));
		 float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ)),
				 pitch =  (float) -Math.toDegrees(Math.atan(deltaY / distance));
		 if(deltaX < 0 && deltaZ < 0) {
			 yaw = (float)( 90 +  Math.toDegrees(Math.atan(deltaX / deltaZ)));
		 }
		 else if(deltaX > 0 && deltaZ < 0 ) {
			 yaw = (float)(- 90 +  Math.toDegrees(Math.atan(deltaX / deltaZ)));
		 }
		 return new float[] {yaw, pitch};
				 
		 
	 }
 }
 


