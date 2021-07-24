package cz.lukynka.aspfix;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Fix extends BukkitRunnable implements Listener  {
	
	Main plugin;
	
	public Fix(Main plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void OnInteractAtEntity(PlayerInteractAtEntityEvent event) {
		event.getRightClicked().getType();
		event.getHandlers().getRegisteredListeners().clone();
		if(event.getRightClicked().getType() == EntityType.ARMOR_STAND) {
		if(event.getPlayer().getWorld().getName() == "hub") {
			if(event.getPlayer().hasPermission("evrank.admin")) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
			}
				
		}
	}
	}


	@Override
	public void run() {
	}

}
