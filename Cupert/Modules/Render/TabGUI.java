package Cupert.Modules.Render;
import java.awt.Color;

import java.io.File;
import java.util.List;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.lwjgl.input.Keyboard;
import Cupert.Client;
import Cupert.Modules.Modules;
import Cupert.Settings.BooleanSetting;
import Cupert.Settings.ModeSettings;
import Cupert.Settings.NumberSetting;
import Cupert.Settings.setting;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventKey;
import Cupert.events.TYPES.Listeners.EventRender;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.notifs.Notification;
import Cupert.notifs.NotificationManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.main.Main;
import net.minecraft.util.ResourceLocation;
public class TabGUI extends Modules
{


	//variables
	public int currentTab;
	public boolean expanded;
	
	//supports the super class
public TabGUI() {
	super("TabGUI", "TabGUI",Keyboard.KEY_NONE, Categories.RENDER);
	 toggled = true;
	}
public void onEvent(event e) {
	float hue = (System.currentTimeMillis() % 3050) / 3050f;
	int color = Color.HSBtoRGB(hue, (float) 0.7, 1);
	//making the Font Renderer Object Easier to access
	int fps = mc.getDebugFPS();
	
	String fpscount = String.valueOf(mc.getDebugFPS());
	
	FontRenderer fr = mc.fontRendererObj;
	//adding a little space for the current module

	
	if(e instanceof EventRender) {
		
		
		
		//draws the main rectangle
		 int primary = 0xff0090ff, secondry = 0xff0070aa;

		Gui.drawRect(5, 30, 70, 30 + Modules.Categories.values().length * 16 + 3, 0x90000000);
		Gui.drawRect(7, 33 + currentTab * 16, 9, 33 + currentTab * 16 + 12, color);
		
	
		//makes a frames per second counter & a rectangle depending on the size
		
				
		//an integer to separate the names
		int count = 0;
		
		//draws the category names
		for (Categories c : Modules.Categories.values()) {
			mc.fontRendererObj.drawString(c.name , 10 + 3, 35 + count * 16 , -1, true);
			
			count++;
		}
		//draws the second rectangle for the modules
		
		
		if(expanded) {
			
		List <Modules> module = Client.getModulesByCategory(Modules.Categories.values()[currentTab]);
		Categories category = Modules.Categories.values()[currentTab];
		Gui.drawRect(70, 30, 70 + 68, 30 + module.size() * 16 + 3, 0x90000000);
		Gui.drawRect(72, 33 + category.ModuleIndex * 16, 9 + 61, 33 + category.ModuleIndex * 16 + 12, color);
		
		
		//an integer to separate the names

		count = 0;
		//draws the category names
		
		
		for (Modules m : Client.getModulesByCategory(Modules.Categories.values()[currentTab])) {
			
			mc.fontRendererObj.drawString(m.name, 10 + 64, 35 + (count * 16) , -1, false);
	
			
			count++;
				
			}

			
			
			
		}
			
	
		
for (Modules m : Client.getModulesByCategory(Modules.Categories.values()[currentTab])) {
			int index1 = 0;
			if(count == category.ModuleIndex && m.expanded) {
				
				index = 0;
				for (setting settings :m.settings ) {
					
					if(settings instanceof BooleanSetting) {
						BooleanSetting bool = (BooleanSetting) settings;
						fr.drawStringWithShadow(settings.name + ": " + (bool.enabled ? "Enabled" : "Disabled"), 10 + 65 + 68 , 35 + index1 * 16 , -1);
					}
					if(settings instanceof NumberSetting) {
						NumberSetting number = (NumberSetting) settings;
						fr.drawStringWithShadow(settings.name + ": " + number.value, 10 + 65 + 68 , 35 + index1 * 16 , -1);
					}
					if(settings instanceof ModeSettings) {
						ModeSettings mode = (ModeSettings) settings;
						fr.drawStringWithShadow(settings.name + ": " + mode.getModes(), 10 + 65 + 68 , 35 + index1 * 16 , -1);
					}
				
				
					index1++;
				}
			}
			count++;
		}
		}
	
	
	
	//key detection
if(e instanceof EventKey) {
	List <Modules> module = Client.getModulesByCategory(Modules.Categories.values()[currentTab]);
	Categories category = Modules.Categories.values()[currentTab];
	int code = ((EventKey)e).code;
	//telling the rectangle to go up or down
	if(code == Keyboard.KEY_UP) {
		if(expanded && !module.isEmpty() && module.get(category.ModuleIndex).expanded ) {
			Modules modules = module.get(category.ModuleIndex);
			if(expanded) {
				if(expanded) {
					if (modules.index <= 0) {
						modules.index = modules.settings.size() - 1;
					}else
						modules.index--;
				}else {
				if (currentTab <= 0) {
					currentTab = Modules.Categories.values().length - 1;
				}else
					currentTab--;
				}
			}
		}else {
			if(expanded) {
				if (category.ModuleIndex <= 0) {
					category.ModuleIndex = module.size() - 1;
				}else
					category.ModuleIndex--;
			}else {
			if (currentTab <= 0) {
				currentTab = Modules.Categories.values().length - 1;
			}else
				currentTab--;
			}
		}
		
	}
	if(code == Keyboard.KEY_DOWN) {
		if(expanded && !module.isEmpty() && module.get(category.ModuleIndex).expanded ) {
			Modules modules = module.get(category.ModuleIndex);
			if(expanded) {
				if(modules.index >=  modules.settings.size() - 1) {
					
					modules.index = 0;
				}else
					modules.index++;
			}
		}else {
			if(expanded) {
				if(category.ModuleIndex >=  module.size() - 1) {
					
					category.ModuleIndex = 0;
				}else
					category.ModuleIndex++;
			}else {
			if(currentTab >= Modules.Categories.values().length - 1) {
				
				currentTab = 0;
			}else
				currentTab++;
			
			}
		}
		
	}
	
	if(code == Keyboard.KEY_RIGHT) {
		int hasBeenFocused = 1;
		if(expanded && !module.isEmpty() && module.get(category.ModuleIndex).expanded ) {
			
		}else {
			if(expanded) {
				module.get(category.ModuleIndex).toggle();
			}else
			expanded = true;
		}
		
	}
	if(code == Keyboard.KEY_LEFT) {
		if(expanded && !module.isEmpty() && module.get(category.ModuleIndex).expanded ) {
			module.get(category.ModuleIndex).expanded = false;
		}else
		{		
		expanded = false;
		}
		
	}
}
}
public void onEnable() {
	NotificationManager.show(new Notification(null, "Octo Client", this.name + " Has been toggled", 54));
	NotificationManager.update();
	NotificationManager.render();
}

}


