package pl.org.mensa.rp.mc.VerticalDespawner;

import org.bukkit.plugin.java.JavaPlugin;

public class VerticalDespawnerPlugin extends JavaPlugin {
	public static final double range = 96.0D;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CreatureSpawnListener(), this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new DespawnerTask(), 120*20L, 60*20L);
	}
}
