package Cupert.Modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Cupert.Client;
import Cupert.Settings.setting;
import Cupert.events.event;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.network.play.server.SPacketChat;

//imports
//Setting Up Module structure :)
public class Modules {
	//some variables
	public  boolean toggled;
	public  String name;
	public String arrayname;
	public int index;
	public  int keyCode;
	public boolean expanded;
	public List<setting> settings = new ArrayList<setting>();
	public Categories category;
	//THE MINECRAFT VARIABLE
	public Minecraft mc = Minecraft.getMinecraft();
	public void addSettings(setting...setting)	{
		this.settings.addAll(Arrays.asList(setting));
			
		
	}
	public Modules(String name, String arrayname,int key, Categories c) {
		this.name = name;
		this.arrayname = arrayname;
		this.keyCode = key;	
		this.category = c;
		
		
		
	}
	//check if if Toggled = True
	public boolean IsEnabled() {
		return toggled;
	}
	//getting the key
	public int getKey() {
		return keyCode;
	}
	//toggle function
	public void toggle() {
		
		toggled = !toggled;
		//enabling and disabling certain functions when either toggled is true or false :D
		if (toggled) {
			
			onEnable();
		} 
		else {
		    onDisable();
		}
	}
	//disable & enable function
	public void onEnable() {
	
		
	}
	public void onDisable() {
		
	}
	
	//the categories
	public enum Categories {
		COMBAT("Combat"),
		MOVEMENT("Movement"),
		PLAYER("Player"),
		RENDER("Render"),
		MEMES("Memes");
		
		public int ModuleIndex;
		public String name;
		Categories(String name){
			this.name = name;
   		}
		
		public static int size(Categories c) {
       
		int i = 0;
		
		for(Modules m : Client.modules) {
			if(m.category.equals(c)) {
				i++;
			}
				
		}
		return i; 
		
			
		}
		public static int placeInListRender(Modules m) {
			int i = 0;
			for(Modules mod : Client.modules) {
				if(mod.category.equals(RENDER) && !mod.equals(m)) {
					i++;
					continue;
					
				}
				if(mod.category.equals(RENDER) && mod.equals(m)) {					
					return i;
				}
			}
			return 0;
		}
		public static int placeInListMovement(Modules m) {
			int i = 1;
			for(Modules mod : Client.modules) {
				if(mod.category.equals(MOVEMENT) && !mod.equals(m)) {
					i++;
					continue;
					
				}
				if(mod.category.equals(MOVEMENT) && mod.equals(m)) {					
					return i;
				}
			}
			return 0;
		}
		public static int placeInListCombat(Modules m) {
			int i = 1;
			for(Modules mod : Client.modules) {
				if(mod.category.equals(COMBAT) && !mod.equals(m)) {
					i++;
					continue;
					
				}
				if(mod.category.equals(COMBAT) && mod.equals(m)) {					
					return i;
				}
			}
			
			return 0;
		}
		public static int placeInListPlayer(Modules m) {
			int i = 1;
			for(Modules mod : Client.modules) {
				if(mod.category.equals(PLAYER) && !mod.equals(m)) {
					i++;
					continue;
					
				}
				if(mod.category.equals(PLAYER) && mod.equals(m)) {					
					return i;
				}
			}
			return 0;
		}
		public static int placeInListMemes(Modules m) {
			int i = 1;
			for(Modules mod : Client.modules) {
				if(mod.category.equals(MEMES) && !mod.equals(m)) {
					i++;
					continue;
					
				}
				if(mod.category.equals(MEMES) && mod.equals(m)) {					
					return i;
				}
			}
			return 0;
		}
	}

	public void onEvent(event e) {
		 
	}
	public boolean onSendChatMessage(String s) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean onRecieveChatMessage(SPacketChat packet) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
