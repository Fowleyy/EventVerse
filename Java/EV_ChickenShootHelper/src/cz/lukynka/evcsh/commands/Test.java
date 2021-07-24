package cz.lukynka.evcsh.commands;

import cz.lukynka.evcsh.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Test implements CommandExecutor {


    Main main;
    private Main plugin;

    public Test(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("test").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        Location playerloc = player.getLocation();

        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(playerloc, EntityType.ARMOR_STAND);
        stand.setHelmet(new ItemStack(Material.BEDROCK));


        return false;
    }
}
