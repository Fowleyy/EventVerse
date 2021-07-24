package cz.lukynka.clientdetector;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;

public class Main extends JavaPlugin {

	
	public void onEnable() {
		
	    Messenger messenger = Bukkit.getMessenger();
	    messenger.registerIncomingPluginChannel(this, "MC|Brand", new BrandPluginMessageListener());
	}



	private static void addChannel(Player p, String channel) {
        try {
            p.getClass().getMethod("addChannel", String.class).invoke(p, channel);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }
    }
	
    
    
    public void PlayerJoinEvent(PlayerJoinEvent event) {
    	Player p = event.getPlayer();
    	addChannel(p, "MC|BRAND");
    }
    
    
    
    
}
