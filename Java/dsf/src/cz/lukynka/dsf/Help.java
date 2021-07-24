package cz.lukynka.dsf;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Help(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("disconect-spam").setExecutor(this);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.GOLD +" ");
			sender.sendMessage(ChatColor.DARK_GREEN +"[Disconnect.spam Fix] " +ChatColor.GREEN + "By LukynkaCZE " +ChatColor.GRAY +"|" +ChatColor.YELLOW + " www.lukynka.cz");
			sender.sendMessage(ChatColor.GOLD +" ");
			return true;
	}
		
		Player player = (Player) sender;
		player.sendMessage(ChatColor.GOLD +" ");
		player.sendMessage(ChatColor.DARK_GREEN +"[Disconnect.spam Fix] " +ChatColor.GREEN + "By LukynkaCZE " +ChatColor.GRAY +"|" +ChatColor.YELLOW + " www.lukynka.cz");
		player.sendMessage(ChatColor.GOLD +" ");
		return false;
}

}
