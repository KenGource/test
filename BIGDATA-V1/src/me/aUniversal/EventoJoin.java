package me.aUniversal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.main.Main;

public class EventoJoin implements Listener {
	
	@EventHandler
	public void onJoinServer(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.isOp() == true){
			e.setJoinMessage(Main.universal.getConfig().getString("ADMIN_JOIN_SERVER").replace("&", "§").replace("{Admin}", p.getName()));
			if(Main.localizacaospawn.getConfig().getString("Spawn.") != null){
			p.teleport(Main.getLocationSpawn());
			}
		}else if(p.isOp() == false){
			e.setJoinMessage(null);
			if(Main.localizacaospawn.getConfig().getString("Spawn.") != null){
			p.teleport(Main.getLocationSpawn());
			}
		}
	}

}
