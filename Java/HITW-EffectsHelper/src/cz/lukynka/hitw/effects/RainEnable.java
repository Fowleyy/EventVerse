package cz.lukynka.hitw.effects;

import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainEnable implements CommandExecutor {
	
	private Main plugin;
	
	public RainEnable(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hitweffects-rainenable").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		
		Player player = (Player) sender;
		
		player.setPlayerWeather(WeatherType.DOWNFALL);
		
		return false;
		
	}

}
