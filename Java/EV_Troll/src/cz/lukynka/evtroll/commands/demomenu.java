package cz.lukynka.evtroll.commands;

import cz.lukynka.evtroll.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class demomenu implements CommandExecutor {

    Main main;
    private Main plugin;
    public demomenu(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("demomenu").setExecutor(this);
    }




    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if(player.hasPermission("ev.rank.admin")) {
            for(Player loopplayer : Bukkit.getOnlinePlayers()) {
                plugin.openDemoMenu(loopplayer);
                plugin.sendTranslated("&aOpening demo menu to " +loopplayer.getName() +"!", player);
            }
        } else {
            plugin.errorMsgPerms("admin", player);
        }



        return false;
    }
}
