package me.aUniversal;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.scheduler.BukkitRunnable;

import me.main.Main;

public class EventoVoid implements Listener{

	@EventHandler
	public void entityDamage(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		if (e.getEntity() instanceof Player && e.getCause().equals(DamageCause.VOID) && ((Player) e.getEntity()).getLocation().getY() <= 0) {
			e.setCancelled(true);
			new BukkitRunnable() {
			    public void run() {
			    	if(Main.localizacaospawn.getConfig().getString("Spawn.") == null){
						p.setFallDistance(0F);
			    		p.teleport(p.getWorld().getSpawnLocation());
			    	}else{
			    		p.setFallDistance(0F);
			    		p.teleport(Main.getLocationSpawn());
			    		p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
			    		p.playSound(p.getLocation(), Sound.valueOf(Main.mensagemvoid.getConfig().getString("Tipo_de_SOM")), 
			    												   Main.mensagemvoid.getConfig().getInt("args1"),
			    												   Main.mensagemvoid.getConfig().getInt("args2"));
			    		p.sendMessage(Main.mensagemvoid.getConfig().getString("Teleportado_pro_spawn").replace("&", "§"));
			        cancel();
			    	}
			    }
			}.runTaskLater(Main.getInstace(), 1L);

			
		}
	}
	
}
