package cz.lukynka.evtroll.commands;

import cz.lukynka.evtroll.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hi implements CommandExecutor {

    Main main;
    private Main plugin;

    public hi(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("hi").setExecutor(this);
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        plugin.sendTranslated("&eHello there ( ﾟ◡ﾟ)/", player);
        player.playSound(player.getLocation(), Sound.SHEEP_IDLE, 1, 1);


        return false;
    }
}
