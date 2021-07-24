package cz.lukynka.evtroll.commands;

import cz.lukynka.evtroll.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Gizmo implements CommandExecutor {

    Main main;
    private Main plugin;
    public Gizmo(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("spawngizmo").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if(player.hasPermission("ev.rank.admin")) {
            Entity pig = player.getWorld().spawnEntity(player.getLocation(), EntityType.PIG);
            Bukkit.broadcastMessage(plugin.getTranslated("&eAdmin &c" +player.getName() +"&e spawnul/a na lobby &e&o*magické*&e prase &c&lG&6&lI&e&lZ&a&lM&b&lO&e..\n&eZabij ho a možná něco dostaneš!"));
            pig.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&lG&6&lI&e&lZ&a&lM&b&lO &d&lT&c&lH&6&lE &e&lP&a&lI&b&lG"));
            pig.setCustomNameVisible(true);
            for(Player loopplayer : Bukkit.getOnlinePlayers()) {
                loopplayer.playSound(player.getLocation(), Sound.HORSE_SADDLE, 5, 0);
            }

        } else {
            plugin.errorMsgPerms("admin", player);
        }

        return false;
    }
}
