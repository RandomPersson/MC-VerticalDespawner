package pl.org.mensa.rp.mc.VerticalDespawner;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class DespawnerTask implements Runnable {
	
	@Override
	public void run() {
		for (World world : Bukkit.getWorlds()) {
			if (world.getPlayers() == null || world.getPlayers().isEmpty()) continue;
			
			for (Entity entity : world.getLivingEntities()) {
				if (!(entity instanceof Monster)) return;
				
				boolean player_found = false;
				for (Entity nearby_entity : entity.getNearbyEntities(VerticalDespawnerPlugin.range, VerticalDespawnerPlugin.range/2, VerticalDespawnerPlugin.range))
					if (nearby_entity instanceof Player) {
						player_found = true;
						break;
					}
				
				if (!player_found) entity.remove();
			}
		}
	}
}
