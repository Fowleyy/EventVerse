package cz.lukynka.evcsh;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class TagHelper extends BukkitRunnable implements Listener {

    Main main;
    private Main plugin;
    public TagHelper(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChickenSpawn(EntitySpawnEvent event) {
        World world = event.getLocation().getWorld();
        Entity entity = event.getEntity();
        Location entityloc = event.getLocation();


        if(Objects.equals(world.getName(), "arcade_chickenshoot")) {
            if(entity.getType() == EntityType.CHICKEN) {
                entity.setCustomNameVisible(false);
                int r = plugin.getRandomNumber(1, 5);

                if(r == 1) {
                    EntityType as = EntityType.ARMOR_STAND;
                    ArmorStand pass = (ArmorStand) entityloc.getWorld().spawnEntity(entityloc, EntityType.ARMOR_STAND);
                    entity.setPassenger(pass);
                    entity.setCustomName("+15");
                    entity.setCustomNameVisible(false);
                    pass.setVisible(false);
                    pass.setSmall(true);
                    pass.setHelmet(new ItemStack(Material.GOLD_BLOCK));
                    pass.setCustomNameVisible(true);
                    pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&6&l+15"));
                }
                if(r == 2) {
                    EntityType as = EntityType.ARMOR_STAND;
                    ArmorStand pass = (ArmorStand) entityloc.getWorld().spawnEntity(entityloc, as);
                    entity.setPassenger(pass);
                    entity.setCustomName("+10");
                    entity.setCustomNameVisible(false);
                    pass.setVisible(false);
                    pass.setSmall(true);
                    pass.setHelmet(new ItemStack(Material.IRON_BLOCK));
                    pass.setCustomNameVisible(true);
                    pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&f&l+10"));
                }
                if(r == 3) {
                    EntityType as = EntityType.ARMOR_STAND;
                    ArmorStand pass = (ArmorStand) entityloc.getWorld().spawnEntity(entityloc, as);
                    entity.setPassenger(pass);
                    entity.setCustomName("+5");
                    entity.setCustomNameVisible(false);
                    pass.setVisible(false);
                    pass.setSmall(true);
                    pass.setHelmet(new ItemStack(Material.HARD_CLAY));
                    pass.setCustomNameVisible(true);
                    pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&l+5"));
                }
                if(r == 4) {
                    EntityType as = EntityType.ARMOR_STAND;
                    ArmorStand pass = (ArmorStand) entityloc.getWorld().spawnEntity(entityloc, as);
                    entity.setPassenger(pass);
                    pass.setVisible(false);
                    pass.setSmall(true);
                    pass.setHelmet(new ItemStack(Material.TNT));
                    pass.setCustomNameVisible(true);
                    entity.setCustomName("1");
                    pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&l⚠ TNT Chicken ⚠"));
                    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
                        @Override
                        public void run() {

                            if(entity.isDead()) {
                                Bukkit.getServer().getScheduler().cancelTasks(plugin);
                            }

                            if(entity.getCustomName().equals("1")) {
                                pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&f&l⚠ TNT Chicken ⚠"));
                                entity.setCustomName("2");
                                return;
                            }
                            if(entity.getCustomName().equals("2")) {
                                pass.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&l⚠ TNT Chicken ⚠"));
                                entity.setCustomName("1");
                            }
                        }
                    }, 0, 15);

                }
            }
        }
    }


    @Override
    public void run() {
        // TO-DO Sub generated method

    }
}
