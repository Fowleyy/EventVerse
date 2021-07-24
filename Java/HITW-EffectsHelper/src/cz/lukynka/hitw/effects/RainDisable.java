package cz.lukynka.hitw.effects;

import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainDisable implements CommandExecutor {
	
	private Main plugin;
	
	public RainDisable(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hitweffects-raindisable").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
		Player player = (Player) sender;
		
		player.setPlayerWeather(WeatherType.CLEAR);
		
		return false;
		
	}

}
