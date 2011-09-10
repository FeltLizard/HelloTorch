package me.feltlizard.hellotorch;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;


public class HelloTorch extends JavaPlugin {

	private final HelloTorchBlockListener blockListener = new HelloTorchBlockListener(this);
	
	Logger log = Logger.getLogger("Minecraft");
	public static Configuration config;
	
	public void onEnable(){
		log.info("HelloTorch_v0.3 enabled!");
		// when server is started, what's in the " " will be shown 
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		
		config = getConfiguration();
		config.load();
		
		
		
		for(Material m : Material.values()){
			if (config.getString(Integer.toString(m.getId())) == null) config.setProperty(Integer.toString(m.getId()), "You placed a " + m.toString());
		}
		
		config.save();
		config.load();
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
		log.info("HelloTorch_v0.3 disabled!");
		// opposite of when its started 		
	}
	
	
}
