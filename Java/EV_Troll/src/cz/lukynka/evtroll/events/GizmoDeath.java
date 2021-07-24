package cz.lukynka.evtroll.events;

import cz.lukynka.evtroll.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GizmoDeath implements Listener {


    Main main;
    private Main plugin;
    public GizmoDeath(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onGizmoDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Location loc = entity.getLocation();
        Player killer = event.getEntity().getKiller();


        if(entity.getType() == EntityType.PIG) {
           // if(killer.getWorld().getName() == "hub") {
                Bukkit.broadcastMessage(plugin.getTranslated("&eHráč &b" +killer.getName() +"&e zabil/a prase &c&lG&6&lI&e&lZ&a&lM&b&lO&e a získal/a &d25&5✦&e!"));
                plugin.spawnFireworks(entity.getLocation(), 1);
                killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1, 1);
                for(Player loopplayer : Bukkit.getOnlinePlayers()) {
                    loopplayer.playSound(loopplayer.getLocation(), Sound.PIG_DEATH, 5, 0);
                    loopplayer.playSound(loopplayer.getLocation(), Sound.PIG_DEATH, 5, 3);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);
                    loopplayer.playEffect(entity.getLocation(), Effect.EXPLOSION, null);

            //    }
             }

        }
    }


}
