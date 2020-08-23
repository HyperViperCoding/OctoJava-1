package Cupert.Modules.Movement.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.events.TYPES.Listeners.onPacket;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.valuesystem.BooleanValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketSpawnPlayer;

public class AntiBot extends Modules {
	 private final BooleanValue tabValue = new BooleanValue("Tab", true);

	    private final BooleanValue entityIDValue = new BooleanValue("EntityID", true);

	    private final BooleanValue colorValue = new BooleanValue("Color", false);

	    private final BooleanValue livingTimeValue = new BooleanValue("LivingTime", false);

	    private final BooleanValue groundValue = new BooleanValue("Ground", true);

	    private final BooleanValue airValue = new BooleanValue("Air", false);

	    private final BooleanValue invalidGroundValue = new BooleanValue("InvalidGround", true);

	    private final BooleanValue swingValue = new BooleanValue("Swing", false);

	    private final BooleanValue healthValue = new BooleanValue("Health", false);

	    private final BooleanValue derpValue = new BooleanValue("Derp", true);

	    private final BooleanValue wasInvisibleValue = new BooleanValue("WasInvisible", false);

	    private final BooleanValue armorValue = new BooleanValue("Armor", false);

	    private final BooleanValue pingValue = new BooleanValue("Ping", false);

	    private final BooleanValue needHitValue = new BooleanValue("NeedHit", false);

	    private final BooleanValue duplicateInWorldValue = new BooleanValue("DuplicateInWorld", false);

	    private final BooleanValue duplicateInTabValue = new BooleanValue("DuplicateInTab", false);



	    private final List<Integer> ground = new ArrayList<>();

	    private final List<Integer> air = new ArrayList<>();

	    private final Map<Integer, Integer> invalidGround = new HashMap<>();

	    private final List<Integer> swing = new ArrayList<>();

	    private final List<Integer> invisible = new ArrayList<>();

	    private final List<Integer> hitted = new ArrayList<>();
	public AntiBot() {
		super("Antibot", "Antibot",0, Categories.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public void onRecievePacket(onPacket event)
	{
		 final SPacketEntity packetEntity = (SPacketEntity) event.getPacket();
		final Entity entity = packetEntity.getEntity(mc.theWorld);
		if(event.getPacket() instanceof SPacketSpawnPlayer) {
			SPacketEntity PacketBot = (SPacketEntity)event.getPacket();
			final Entity Bot = PacketBot.getEntity(mc.theWorld);
			double posX = Bot.posX / 32d;
			double posZ = Bot.posY / 32d;
			double posY = Bot.posY/ 32d;
			double difX = mc.thePlayer.posX - posX;
			double difY = mc.thePlayer.posZ - posY;
			double difZ = mc.thePlayer.posZ - posZ;
			double dist = Math.sqrt(difX * difX + difY * difY + difZ * difZ);
			if(dist <= 17D && posX  != mc.thePlayer.posX && posZ  != mc.thePlayer.posZ && posY  != mc.thePlayer.posY) {
				event.setCancelled(true);
				Client.addChatMessage("Bot: " +  " has been removed");
				if(!(Bot instanceof EntityPlayer)) {
					mc.theWorld.removeEntity(Bot);
					Client.addChatMessage("Bot: " + Bot.getName()  + " has been removed");
				}
			
			}
			 if(entity instanceof EntityPlayer) {

	                if(packetEntity.getOnGround() && !ground.contains(entity.getEntityId()))

	                    ground.add(entity.getEntityId());



	                if(!packetEntity.getOnGround() && !air.contains(entity.getEntityId()))

	                    air.add(entity.getEntityId());



	                if(packetEntity.getOnGround()) {

	                    if(entity.prevPosY != entity.posY)

	                        invalidGround.put(entity.getEntityId(), invalidGround.getOrDefault(entity.getEntityId(), 0) + 1);

	                }else{

	                    final int currentVL = invalidGround.getOrDefault(entity.getEntityId(), 0) / 2;



	                    if (currentVL <= 0)

	                        invalidGround.remove(entity.getEntityId());

	                    else

	                        invalidGround.put(entity.getEntityId(), currentVL);

	                }



	                if(entity.isInvisible() && !invisible.contains(entity.getEntityId()))

	                    invisible.add(entity.getEntityId());

	            }

	        }
			


		}
	   private void clearAll() {

	        hitted.clear();

	        swing.clear();

	        ground.clear();

	        invalidGround.clear();

	        invisible.clear();

	    }
	   
	
	public void onEnable() {
		if(mc.thePlayer.isDead) {		
			clearAll();
		}
	}
}
