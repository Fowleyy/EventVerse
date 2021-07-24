package cz.lukynka.evtroll;

import cz.lukynka.evtroll.commands.*;
import cz.lukynka.evtroll.events.GizmoDeath;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) +min);
    }

    public String getTranslated(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        return (String) msg;
    }
    public void sendCredits(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(4, 1));
    }
    public void openDemoMenu(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 0));
    }

    public void sendTranslated(String msg, Player player) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        player.sendMessage(msg);
    }
    public void sendTranslatedToConsole(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', msg);
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }
    public void errorMsgPerms(String rank, Player player) {
        if(rank.equals("admin")) {
            sendTranslated("&cNa použití toho příkazu potřebuješ rank &4Admin&c!", player);
        }
        if(rank.equals("mcteam")) {
            sendTranslated("&cNa použití toho příkazu potřebuješ rank &4MCTeam&c!", player);
        }
    }
    public void spawnFireworks(Location location, int amount) {
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.setPower(0);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.FUCHSIA).flicker(true).build());

        fw.setFireworkMeta(fwm);
        fw.detonate();

        for(int i = 0;i<amount; i++){
            Firework fw2 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            fw2.setFireworkMeta(fwm);
        }
    }
    public void onEnable() {
        new thiscommandliterallydoesnothing(this);
        new hi(this);
        new credits(this);
        new demomenu(this);
        new Gizmo(this);
        Bukkit.getServer().getPluginManager().registerEvents(new GizmoDeath(this), this);

    }

}




