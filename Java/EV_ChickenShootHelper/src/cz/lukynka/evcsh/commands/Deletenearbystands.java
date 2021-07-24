package cz.lukynka.evcsh.commands;

import cz.lukynka.evcsh.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Deletenearbystands implements CommandExecutor {

    Main main;
    private Main plugin;

    public Deletenearbystands(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("deletenearbystands").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if(Objects.equals(player.getWorld().getName(), "Test")) {
            if(Objects.equals(player.getName(), "LukynkaCZE")) {
                plugin.sendTranslated("&aCleared all nearby ArmorStands!", player);
                for(Entity entity : player.getNearbyEntities(100, 100, 100)) {
                    if(entity.getType() == EntityType.ARMOR_STAND) {
                        entity.remove();
                    }
                    if(entity.getType() == EntityType.CHICKEN) {
                        entity.remove();
                    }
                }
            }
        }

        return false;
    }
}
