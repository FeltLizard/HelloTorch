package me.feltlizard.hellotorch;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class HelloTorch extends JavaPlugin {
	private final HelloTorchBlockListener playerListener = new HelloTorchBlockListener(this);
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("HelloTorch_v0.1 enabled!");
		// when server is started, whats in the " " will be shown 
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACE, playerListener, Event.Priority.Normal, this);
		//gets server for block event
	}
	
	public void onDisable(){
		log.info("HelloTorch_v0.1 disabled!");
		// opposite of when its started 		
	}
	
	
}
