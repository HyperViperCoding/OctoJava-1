package Cupert.commands;

import org.lwjgl.input.Keyboard;

import Cupert.Client;

import Cupert.Command.Commands;
import Cupert.Modules.Modules;

public class Help extends Commands{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "help";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "displays help";
	}

	@Override
	public String getSynstax() {
		// TODO Auto-generated method stub
		return ".help";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		// TODO Auto-generated method stub
		Client.addChatMessage("To change a keybind: .bind set [MOD] [Key]");
		Client.addChatMessage("To delete a keybind: .bind del [MOD]");
		Client.addChatMessage("To remove all Binds: .bind clear all");
		Client.addChatMessage("To change flight mode to Normal: .mode Normal");
		Client.addChatMessage("To change flight mode to MCCentral: .mode MCCentral");
		Client.addChatMessage("To change flight mode to Fast: .mode Fast");
		Client.addChatMessage("To change flight mode to Hypixel: .mode Hypixel");
		Client.addChatMessage("To change flight mode to Teleport: .mode Teleport");
		Client.addChatMessage("To change Speed mode to normal : .mode SpeedNormal");
		Client.addChatMessage("To change Speed mode to Hop: .mode SpeedHop");
		Client.addChatMessage("To change Longjump mode to Normal: .mode NormalJump");
		Client.addChatMessage("To change Longjump  mode to Mineplex: .mode MineplexJump");
	}

}
