package cz.lukynka.hitw.effects;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		new RainEnable(this);
		new RainDisable(this);
		
	}

}
