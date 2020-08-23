package Cupert.Modules.Combat;
import java.util.Comparator;






import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.Settings.BooleanSetting;
import Cupert.Settings.ModeSettings;
import Cupert.Settings.NumberSetting;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventMotion;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.util.Timer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;

import net.minecraft.util.EnumHand;




public class KillAura extends Modules
{
	public Timer timer = new Timer();
	public NumberSetting range = new NumberSetting("Range", 4, 1, 6, 0.1);
	public NumberSetting APS = new NumberSetting("APS", 10, 1, 20, 1);
	public BooleanSetting noSwing = new BooleanSetting("NoSwing", false);
	public ModeSettings Test = new ModeSettings("Test", "One ", "Two");
	
	//supports the module array in the class modules
public KillAura() {
	super("Aura", "Aura",Keyboard.KEY_X, Categories.COMBAT);
	this.addSettings(range, APS, noSwing);
	}
float cooldown = 0;

public float Range = 5;
	public void isPost(event e) {
		if(e.isPost()) {
			
		}
	}
	 public void onEvent(event e) 
     {
	 
         if(e instanceof EventMotion) 
	     {
        	 if(mc.thePlayer.isDead) {
        		 this.toggle();
        		 Client.addChatMessage("Aura toggled off due to death");
        	 }
		     if (e.isPre()) {
		    	 EventMotion event = (EventMotion)e; 
		    
		    		List<Entity> targets = mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());


                   targets = targets.stream().filter(entity -> ((Entity) entity).getDistanceToEntity(mc.thePlayer) < 3.6 && entity != mc.thePlayer && !entity.isInvisible() && ((Entity) entity).canBeAttackedWithItem()).collect(Collectors.toList());
                   targets.sort(Comparator.comparingDouble( entity -> ((Entity)entity).getDistanceToEntity(mc.thePlayer)));
                   if(!targets.isEmpty()){
                	  Entity target = targets.get(0);
                	  ScaledResolution sr = new ScaledResolution(mc);
                	  
                	  //The attack and rotate function. :D
                	int height = mc.displayWidth / 2	;
                		  event.setYaw(getRotations(target)[0]);
                		  event.setPitch(getRotations(target)[1]);        	  
                	  if(timer.hasElapsed((long) (1000 / APS.getValue()) , true) && mc.thePlayer.getAttackingEntity() != target) {
                		  mc.thePlayer.connection.sendPacket(new CPacketUseEntity(target));
                		  if(noSwing.enabled) {
                			  mc.thePlayer.connection.sendPacket(new CPacketAnimation());
                		  }else {
                			  
                			  mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
                    		  }               		  
                  }
                  }
         
                   
                   
		     }
		  }
	     }
	  public float[] getRotations(Entity e) {
	        double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
	                deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
	                deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
	                distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));

	        float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ)),
	                pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));

	        if (deltaX < 0 && deltaZ < 0) {
	            yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
	        } else if (deltaX > 0 && deltaZ < 0) {
	            yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
	        }

	        return new float[] { yaw, pitch };
	 }
	
 }
 


