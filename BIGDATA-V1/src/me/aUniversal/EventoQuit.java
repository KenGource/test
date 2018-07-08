package me.aUniversal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.main.Main;


public class EventoQuit implements Listener{
	
	@EventHandler
	public void onQuitServer(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(p.isOp() == true){
			e.setQuitMessage(Main.universal.getConfig().getString("ADMIN_QUIT_SERVER").replace("&", "§").replace("{Admin}", p.getName()));
			return;
		}
		e.setQuitMessage(null);	
	}

}
