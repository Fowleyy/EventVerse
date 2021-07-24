package cz.lukynka.clientdetector;

import java.io.UnsupportedEncodingException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BrandPluginMessageListener implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] msg) {
        try {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY +"[DEV] " +ChatColor.GOLD +p.getDisplayName() +ChatColor.YELLOW +" se pøipojil/a pøes " +ChatColor.AQUA +new String(msg, "UTF-8").substring(1));
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            	if(all.isOp()) {
            		all.sendMessage(ChatColor.GRAY +"[DEV] " +ChatColor.GOLD +p.getDisplayName() +ChatColor.YELLOW +" se pøipojil/a pøes " +ChatColor.AQUA +new String(msg, "UTF-8").substring(1));
            	}
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}