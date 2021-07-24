package cz.lukynka.evtroll.commands;

import cz.lukynka.evtroll.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class thiscommandliterallydoesnothing implements CommandExecutor {

    Main main;
    private Main plugin;

    public thiscommandliterallydoesnothing(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("thiscommandliterallydoesnothing").setExecutor(this);
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        plugin.sendTranslated("&eThis command literally does nothing...", player);
        player.playSound(player.getLocation(), Sound.SKELETON_IDLE, 1, 1);


        return false;
    }
}
