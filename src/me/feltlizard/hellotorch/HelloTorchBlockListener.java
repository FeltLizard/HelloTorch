package me.feltlizard.hellotorch;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HelloTorchBlockListener extends BlockListener {
	
	public static HelloTorch plugin; 
	
	public HelloTorchBlockListener(HelloTorch instance) {
		plugin = instance;
	}
	
	public void onBlockPlace(BlockPlaceEvent event) {
		
		Player player = event.getPlayer();
		//gets player
		String name = event.getPlayer().getDisplayName();
		//gets players username
		Block block = event.getBlockPlaced();
		//gets placed block
		
		
		if (block.getType() == Material.TORCH && Global.num == 1) {
			//if block is a torch it says what's in the " " and if it isn't then nothing happens.
			player.sendMessage("Hello, " + name);
		}
		
		
	}
	
}
