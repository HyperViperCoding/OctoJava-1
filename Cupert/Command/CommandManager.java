package Cupert.Command;

import java.util.ArrayList;


import Cupert.Client;
import Cupert.commands.Bind;
import Cupert.commands.Help;
import Cupert.commands.Modes;


public class CommandManager {
	private ArrayList<Commands> commands;
	public int flyint = 0;
	public CommandManager() {
		commands = new ArrayList();
		addComand(new Bind());
		addComand(new Modes());
		addComand(new Help());
		
		}
	public void addComand(Commands c) {
		
		commands.add(c);
		
	}
	public ArrayList<Commands> getCommands(){
		return commands;
	}
	public void CallCommand(String input) {
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Commands c: getCommands()) {
			if(c.getAlias().equalsIgnoreCase(command)) {
				try {
					c.onCommand(args, args.split(" "));
				}catch (Exception e) {
					Client.addChatMessage("Bad CMD Usage!");
					Client.addChatMessage(c.getSynstax());
				}
				return;
			}
		}
		Client.addChatMessage("Command Not Found, Please Try Again! Use .help For more info!");
		
			
	}
}
