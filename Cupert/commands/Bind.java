package Cupert.commands;

import org.lwjgl.input.Keyboard;

import Cupert.Client;

import Cupert.Command.Commands;
import Cupert.Modules.Modules;

public class Bind extends Commands{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "bind";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sets Module Binds";
	}

	@Override
	public String getSynstax() {
		// TODO Auto-generated method stub
		return ".bind set [Modules] [Key] | .bind del [Modules] | .bind clear all";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		// TODO Auto-generated method stub
		if(args[0].equalsIgnoreCase("set")) {
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2].toString());
			for(Modules m : Client.getMods()) {
				if(args[1].equalsIgnoreCase(m.name)) {
					m.keyCode = Keyboard.getKeyIndex(Keyboard.getKeyName(key));
					Client.addChatMessage(args[1] + " Has been binded to " + args[2]);
				}
			}
			
		}else if(args[0].equalsIgnoreCase("del")) {
			for(Modules m : Client.getMods()) {
				if(m.name.equalsIgnoreCase(args[1])) {
					m.keyCode =0;
					Client.addChatMessage(args[1] + " Has been unbinded");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")) {
			for(Modules m : Client.getMods()) {
				m.keyCode = 0;
			}
			Client.addChatMessage(" All Binds have been cleared");
		}
	}

}
