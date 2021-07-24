package cz.lukynka.evcsh;

import cz.lukynka.evcsh.commands.Test;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void sendTranslated(String msg, Player player) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        player.sendMessage(msg);
    }

    public void sendTranslatedConsole(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }

    @Override
    public void onEnable() {
        sendTranslatedConsole("ChickenShootHelper loaded!");
        Bukkit.getServer().getPluginManager().registerEvents(new TagHelper(this), this);
 //       new Deletenearbystands(this); (No need to register this, it was just for testing)
        new Test(this);

    }
}
