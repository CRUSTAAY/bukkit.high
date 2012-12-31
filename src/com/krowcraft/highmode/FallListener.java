package com.krowcraft.highmode;


import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class FallListener implements Listener{
@EventHandler (priority= EventPriority.HIGHEST)
	public void onPlayerDamage(EntityDamageEvent event){
	Entity entity = event.getEntity();
		if (entity instanceof Player){
			Player theplayer = (Player) entity;
			theplayer.getName();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
				if (highmode.highp.containsKey(theplayer) && (theplayer.hasPermission("highmode.nofall") || theplayer.isOp())){
					event.setCancelled(true);
				}
			}
		}
	}
}
				