package Cupert.Modules.Movement.Player;

import org.lwjgl.input.Keyboard;


import Cupert.Modules.Modules;

import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventRender;
import Cupert.events.TYPES.Listeners.EventUpdate;
import Cupert.valuesystem.BooleanValue;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.GameSettings;

public class InvMove extends Modules {

	public InvMove() {
		super("InvMove", "InvMove",0, Categories.MOVEMENT);
		// TODO Auto-generated constructor stub
	}
   
GuiChat guiChat = new GuiChat();

GuiIngameMenu guiIngameMenu= new GuiIngameMenu();


	
    public void onEvent(event e) {
    	if(mc.currentScreen instanceof GuiInventory || mc.currentScreen instanceof GuiChest) {
    		if(GameSettings.isKeyDown(mc.gameSettings.keyBindForward)) {
    			mc.gameSettings.keyBindForward.pressed = true;
    		}else {
    			mc.gameSettings.keyBindForward.pressed = false;
    		}
    		if(GameSettings.isKeyDown(mc.gameSettings.keyBindLeft)) {
    			mc.gameSettings.keyBindLeft.pressed = true;
    		}else {
    			mc.gameSettings.keyBindLeft.pressed = false;
    		}
    		if(GameSettings.isKeyDown(mc.gameSettings.keyBindRight)) {
    			mc.gameSettings.keyBindRight.pressed = true;
    		}else {
    			mc.gameSettings.keyBindRight.pressed = false;
    		}
    		if(GameSettings.isKeyDown(mc.gameSettings.keyBindBack)) {
    			mc.gameSettings.keyBindBack.pressed = true;
    		}else {
    			mc.gameSettings.keyBindBack.pressed = false;
    		}
    		if(GameSettings.isKeyDown(mc.gameSettings.keyBindJump)) {
    			mc.gameSettings.keyBindJump.pressed = true;
    		}else {
    			mc.gameSettings.keyBindJump.pressed = false;
    		}
    	}
    }





    public void onDisable() {
    
        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindForward) || mc.currentScreen != null)

            mc.gameSettings.keyBindForward.pressed = false;

        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindBack) || mc.currentScreen != null)

            mc.gameSettings.keyBindBack.pressed = false;

        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindRight) || mc.currentScreen != null)

            mc.gameSettings.keyBindRight.pressed = false;

        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindLeft) || mc.currentScreen != null)

            mc.gameSettings.keyBindLeft.pressed = false;

        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindJump) || mc.currentScreen != null)

            mc.gameSettings.keyBindJump.pressed = false;

        if (!GameSettings.isKeyDown(mc.gameSettings.keyBindSprint) || mc.currentScreen != null)

            mc.gameSettings.keyBindSprint.pressed = false;

    }
}
