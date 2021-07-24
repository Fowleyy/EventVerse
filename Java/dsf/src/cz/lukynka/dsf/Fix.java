package cz.lukynka.dsf;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Fix extends BukkitRunnable implements Listener {
	
	Main plugin;
	public Fix(Main plugin) {
		this.plugin = plugin;
	}
	
	
	
	@EventHandler
	public void onDisconnectSpam(PlayerKickEvent event) {
		if(event.getReason() == "disconnect.spam") {
			event.setCancelled(true);
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA +"[Disconnect.spam Fix] " +ChatColor.YELLOW +event.getPlayer().getName() +ChatColor.AQUA +" Should have been kicked for reason" +ChatColor.RED + " diconected.spam" +ChatColor.AQUA +" but wasn't!");
		}
	}



	@Override
	public void run() {
		
	}
	

}


// yeah thats all