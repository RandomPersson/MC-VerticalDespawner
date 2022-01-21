package pl.org.mensa.rp.mc.VerticalDespawner;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class CreatureSpawnListener implements Listener {
	
	public void onMobSpawn(CreatureSpawnEvent e) {
		if (!(e.getEntity() instanceof Monster) || e.getSpawnReason() != SpawnReason.NATURAL) return;
		
		for (Entity entity : e.getEntity().getNearbyEntities(VerticalDespawnerPlugin.range, VerticalDespawnerPlugin.range/3, VerticalDespawnerPlugin.range))
			if (entity instanceof Player) return;
		
		e.setCancelled(true);
	}
}
