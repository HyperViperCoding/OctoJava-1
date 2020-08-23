package Cupert.commands;

import org.lwjgl.input.Keyboard;

import Cupert.Client;
import Cupert.Command.CommandManager;
import Cupert.Command.Commands;
import Cupert.Modules.Modules;
import Cupert.Modules.Movement.Flight;

public class Modes extends Commands{

	public static int mode = 0;
	public static int speedmode = 4;
	public static int AuraMode = 0;
	public static int JumpMode =0;
	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "mode";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sets Modes";
	}

	@Override
	public String getSynstax() {
		// TODO Auto-generated method stub
		return ".mode Normal | .mode MCcentral | .mode Glide | .mode Hypixel | .mode SpeedHop | .mode SpeedNormal | .mode Pre | .mode  hypixel | .mode newHypixel | .mode NormalJump | .mode MineplexJump  ";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		if(args[0].equalsIgnoreCase("Normal")) {
			Flight.Mode = "Normal";
			mode = 0;
			Client.addChatMessage("Fly mode is now Normal");
		}else if(args[0].equalsIgnoreCase("MCcentral")) {
			Flight.Mode = "MCcentral";
			
			mode = 1;
			Client.addChatMessage("Fly mode is now MCCentral");
		}else if(args[0].equalsIgnoreCase("Glide")) {
			Flight.Mode = "Glide";
			mode = 2;
			Client.addChatMessage("Fly mode is now Glide");
		}else if(args[0].equalsIgnoreCase("fast")) {
			Flight.Mode = "Fast";
			mode = 3;
			Client.addChatMessage("Fly mode is now Fast");
		}else if(args[0].equalsIgnoreCase("Hypixel")) {
			Flight.Mode = "Hypixel";
			mode = 4;
			Client.addChatMessage("Fly mode is now Hypixel");
		}else if(args[0].equalsIgnoreCase("Teleport")) {
			Flight.Mode = "Teleport";
			mode = 5;
			Client.addChatMessage("Fly mode is now Teleport");
		}else if(args[0].equalsIgnoreCase("SpeedHop")) {
		
			speedmode = 3;
			Client.addChatMessage("Speed mode is now Hop");
		}else if(args[0].equalsIgnoreCase("SpeedNormal")) {
		
			speedmode = 4;
			Client.addChatMessage("Speed mode is now Normal");
		}
		else if(args[0].equalsIgnoreCase("NormalJump")) {
			JumpMode = 0;
			Client.addChatMessage("LongJump mode is now Normal");
		}	else if(args[0].equalsIgnoreCase("MineplexJump")) {
			JumpMode = 1;
			Client.addChatMessage("LongJump mode is now Mineplex");
		}	else if(args[0].equalsIgnoreCase("TestJump")) {
			JumpMode = 2;
			Client.addChatMessage("LongJump mode is now Test");
		}	else if(args[0].equalsIgnoreCase("Test")) {
			mode = 6;
			Client.addChatMessage("Fly mode is now Test");
		}
		
		
			}
		
	}
	

