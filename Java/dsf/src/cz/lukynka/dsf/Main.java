package cz.lukynka.dsf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	
    public void onEnable() {
    	ConsoleCommandSender c = Bukkit.getConsoleSender();
    	c.sendMessage(" ");
    	c.sendMessage(ChatColor.DARK_GREEN +"[Disconnect.spam Fix] " +ChatColor.GREEN + "By LukynkaCZE " +ChatColor.GRAY +"|" +ChatColor.YELLOW + " www.lukynka.cz");
    	c.sendMessage(" ");
    	
    	Bukkit.getServer().getPluginManager().registerEvents(new Fix(this), this);
    	new Help(this);
    }
	

}


