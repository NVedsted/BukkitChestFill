package dk.dragoncraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable(){
		getCommand("fill").setExecutor(new Fill());
		getCommand("sfill").setExecutor(new SpaceFill());
		getCommand("open").setExecutor(new Open());
		getCommand("empty").setExecutor(new Empty());
		getCommand("place").setExecutor(new Place());
	}
}