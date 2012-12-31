package com.krowcraft.highmode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import net.minecraft.server.v1_4_6.Block;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;




public class highmode extends JavaPlugin{
	public static final Logger logger = Logger.getLogger("Minecraft");
	public static HashMap<Player, ArrayList<Block>> highp = new HashMap<Player, ArrayList<Block>>();
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new FallListener(), this);
		PluginDescriptionFile pdfFile = getDescription();
		highmode.logger.info(pdfFile.getName() + " Version: " + pdfFile.getVersion() + " has now been Enabled");	
	}
	

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (sender instanceof Player){
			Player player = (Player)sender;
			if (player.hasPermission("high.use") || player.isOp()){
				if (label.equalsIgnoreCase("high")){
					if (highp.containsKey(player)){
						highp.remove(player);
						player.removePotionEffect(PotionEffectType.CONFUSION);
						player.removePotionEffect(PotionEffectType.SPEED);
						player.removePotionEffect(PotionEffectType.JUMP);
						player.sendMessage(ChatColor.DARK_RED + "Highmode is now Disabled");
						return false;
					} else {
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20000, 6));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
					player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 10));	
					highp.put(player, null);
					player.sendMessage(ChatColor.DARK_GREEN + "Highmode is now Enabled");
					return false;
					}
				}
		
		
			} else {
				
				/* future commands */
				
				
			  }
		}
	return false;
		
	}
	
	
	
	
	

}


