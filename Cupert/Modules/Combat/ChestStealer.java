package Cupert.Modules.Combat;

import org.lwjgl.input.Keyboard;

import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import Cupert.util.Timer;
import net.minecraft.inventory.ClickType;

import net.minecraft.inventory.ContainerChest;


public class ChestStealer extends Modules {
	public Timer time = new Timer();

	public ChestStealer() {
		super("ChestSteal", "ChestSteal",Keyboard.KEY_0, Categories.COMBAT);
		// TODO Auto-generated constructor stub
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
		
		NotificationManager.update();
	}
	public void onEvent(event e) {
		if(e instanceof EventUpdate) {
			if((this.mc.thePlayer.openContainer != null) && (this.mc.thePlayer.openContainer instanceof ContainerChest)) {
				ContainerChest chest = (ContainerChest) this.mc.thePlayer.openContainer;
				for(int i  = 0;  i < chest.getLowerChestInventory().getSizeInventory(); i++) {
					if((chest.getLowerChestInventory().getStackInSlot(i) != null) && (this.time.hasElapsed(40l, false)	)) {
						this.mc.playerController.windowClick(chest.windowId, i, 0, ClickType.QUICK_MOVE, mc.thePlayer);
						this.time.reset();
					}
				}
			
				
			}
		}
	}
			

}
