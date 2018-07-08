package me.spawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.main.Main;

public class EventosSpawn implements Listener {
	
	//O EventJoinPlayer se encontra no package me.aUniversal

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		if(Main.localizacaospawn.getConfig().getString("Spawn.") != null){
			e.setRespawnLocation(Main.getLocationSpawn());
		}
	}
	
}
