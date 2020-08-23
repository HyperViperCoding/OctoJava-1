package Cupert;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import Cupert.Command.CommandManager;
import Cupert.Modules.Modules;
import Cupert.Modules.Modules.Categories;
import Cupert.Modules.Combat.Aimbot;
import Cupert.Modules.Combat.BowAimbot;
import Cupert.Modules.Combat.ChestStealer;
import Cupert.Modules.Combat.KillAura;
import Cupert.Modules.Memes.ISPED;
import Cupert.Modules.Memes.Kermit;
import Cupert.Modules.Memes.OkBoomer;
import Cupert.Modules.Memes.Spammer;
import Cupert.Modules.Movement.AirJump;
import Cupert.Modules.Movement.CreativeFly;
import Cupert.Modules.Movement.Flight;
import Cupert.Modules.Movement.Longjump;
import Cupert.Modules.Movement.Scaffold;
import Cupert.Modules.Movement.Speed;
import Cupert.Modules.Movement.Sprint;
import Cupert.Modules.Movement.Walk;
import Cupert.Modules.Movement.Player.AntiBot;
import Cupert.Modules.Movement.Player.FOV;
import Cupert.Modules.Movement.Player.InvMove;
import Cupert.Modules.Movement.Player.NoFall;
import Cupert.Modules.Render.FullBright;
import Cupert.Modules.Render.TabGUI;
import Cupert.Modules.Render.TargetHUD;
import Cupert.UI.HUD;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventKey;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.TextComponentString;
/*
 * Copyright (c) 2020 Creamsicle#2492.
 * Permission is hereby granted, free of charge. to any person that obtains a copy of this document must give appropriate credit and cannot pass this as his/her own, without any itteration or change to the document.
 * Any person to obtain this documeent CAN NOT SELL or redistribute without proper permission from the owner.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
public class Client {
public static String Name = "Octo Client"; public static String Version = "1";
public static CopyOnWriteArrayList<Modules> modules =  new CopyOnWriteArrayList <Modules>();
public static HUD hud = new HUD();

private static CommandManager cmdManager;
//what happens when there is a startup
public static void startup()
{
	
	System.out.println("Starting " + Name + " " + Version);
	//Changes Name!
	Display.setTitle(Name +  " v" + Version);
	modules.add(new TargetHUD());
	cmdManager = new CommandManager();
	modules.add(new AntiBot());
	modules.add(new InvMove());
	modules.add(new Speed());
	modules.add(new Longjump());
	
	modules.add(new CreativeFly());//0
	modules.add(new ChestStealer());

    modules.add(new FullBright());//2
    modules.add(new Cupert.Modules.Movement.Player.Timer());
   // modules.add(new FastPlace());/

    modules.add(new OkBoomer());//5
   //modules.add(new velocity());
    modules.add(new BowAimbot());//6
    modules.add(new Scaffold());
   
    
    modules.add(new KillAura());//2
    modules.add(new AirJump());
   
    
    modules.add(new Spammer());
    modules.add(new TabGUI());//5
    modules.add(new Aimbot());
    modules.add(new Kermit());

    
    modules.add(new NoFall());
    modules.add(new Sprint());//6
    modules.add(new Flight());
    modules.add(new ISPED());
    modules.add(new Walk());


    modules.add(new FOV());//8
}
//random stuff
public static void addChatMessage(String s) {
	Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("[Octo] " + s));
}
public static void onEvent (event e) {
	for(Modules m: modules) {
		if (!m.toggled)
			continue;
		m.onEvent(e);
	}
}

public static void keyPress(int key) {
	Client.onEvent(new EventKey(key));
	
	for(Modules m : modules){
		if (m.getKey() == key) {
			m.toggle();
		}
			
	}
}

public static List<Modules> getMods(){
	return Client.modules;
}

	public static List<Modules> getModulesByCategory(Categories c)
	{
	List<Modules> modules = new ArrayList<Modules>();
	  for (Modules m : Client.modules) {
		  if (m.category == c) 
			 modules.add(m);
		  
	  
	}
	  return modules;
}
	public static boolean onSendChatMessage(String s ) {
		if(s.startsWith(".")) {
			cmdManager.CallCommand(s.substring(1));
			return false;
		}
		for(Modules m: getMods()) {
			if(m.toggled) {
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	public static boolean onRecieveChatMessage(SPacketChat packet) {
		for(Modules m: getMods()) {
			if(m.toggled) {
				return m.onRecieveChatMessage(packet);
			}
			
		}
		return true;
	}
	
}
