package me.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.main.Main;

public class ComandosSpawn implements CommandExecutor{
	
	
	   @Override
	    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	        if (!(sender instanceof Player)) {
        		sender.sendMessage(Main.universal.getConfig().getString("Console_Player").replace("&", "§"));
	            return true;
	        }
	        Player p = (Player) sender;
	        if (command.getName().equalsIgnoreCase("spawn")) {
	        	if(!(p.hasPermission("spawn.spawn"))){
	        		p.sendMessage(Main.universal.getConfig().getString("Nao_tem_permissao").replace("&", "§"));
	        	}else{
	            if (Main.localizacaospawn.getConfig().getString("Spawn.") == null) {
					p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn_Nao_Existe_Spawn").replace("&", "§"));
	                return true;
	            }
	            p.teleport(Main.getLocationSpawn());
	            p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn").replace("&", "§"));
	        	}
	        }
	        if (command.getName().equalsIgnoreCase("setspawn")) {
	        	if(!(p.hasPermission("spawn.spawn"))){
	        		p.sendMessage(Main.universal.getConfig().getString("Nao_tem_permissao").replace("&", "§"));
	        	}else{
	            if (Main.localizacaospawn.getConfig().getString("Spawn.") != null) {
	               	p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn_Ja_Existe").replace("&", "§"));
	                return true;
	            }
	                Main.localizacaospawn.getConfig().set("Spawn.World", p.getLocation().getWorld().getName());
	                Main.localizacaospawn.getConfig().set("Spawn.X", p.getLocation().getX());
	                Main.localizacaospawn.getConfig().set("Spawn.Y", p.getLocation().getY());
	                Main.localizacaospawn.getConfig().set("Spawn.Z", p.getLocation().getZ());
	                Main.localizacaospawn.getConfig().set("Spawn.Pitch", p.getLocation().getPitch());
	                Main.localizacaospawn.getConfig().set("Spawn.Yaw", p.getLocation().getYaw());
	                Main.localizacaospawn.saveConfig();
                	p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn_Setado").replace("&", "§"));
	            }
	        }
	            if (command.getName().equalsIgnoreCase("delspawn")) {
		        	if(!(p.hasPermission("spawn.spawn"))){
		        		p.sendMessage(Main.universal.getConfig().getString("Nao_tem_permissao").replace("&", "§"));
		        	}else{
	                if (Main.localizacaospawn.getConfig().getString("Spawn.") == null) {
	                	p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn_Nao_Existe_Delete").replace("&", "§"));
	                    return true;
	                }
	                Main.localizacaospawn.getConfig().set("Spawn", null);
	                p.sendMessage(Main.mensagemspawn.getConfig().getString("Spawn_Deletado").replace("&", "§"));
		        	}
	            }
				return false;
	   }
}
