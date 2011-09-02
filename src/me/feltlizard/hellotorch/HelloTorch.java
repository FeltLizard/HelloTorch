package me.feltlizard.hellotorch;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class HelloTorch extends JavaPlugin {

	private final HelloTorchBlockListener blockListener = new HelloTorchBlockListener(this);
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("HelloTorch_v0.2 enabled!");
		// when server is started, what's in the " " will be shown 
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		//gets server for block event	
	}
	
	
		
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			if (cmd.getName().equalsIgnoreCase("hellotorch")
					|| cmd.getName().equalsIgnoreCase("ht")) {	
				
				if (Global.num < 1) { 
					Global.num++;
				} else {
					Global.num--;
				}
			}
				
			return true;
	}
					
		
	
	
	
	

	
	public void onDisable(){
		log.info("HelloTorch_v0.2 disabled!");
		// opposite of when its started 		
	}
	
	
}
