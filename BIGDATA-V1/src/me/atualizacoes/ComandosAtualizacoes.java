package me.atualizacoes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.main.Main;

public class ComandosAtualizacoes implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
            sender.sendMessage("§cApenas players podem utilizar este comando!");
            return true;
		}
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("atualizacoes")){
			if(args.length == 0){
				for(String atualizacoes : Main.getInstace().getConfig().getStringList("Atualizacoes")){
					p.sendMessage(atualizacoes);
				}
			
			}else if(args.length == 1){
				if(Main.getInstace().getConfig().getStringList("Atualizacao." + args[0]) == null){
					p.sendMessage("§cEssa atualizacao não existe!");
					return true;
				}
				for(String atualizacao : Main.getInstace().getConfig().getStringList("Atualizacao." + args[0])){
					atualizacao.replace("&", "§");
					p.sendMessage(atualizacao);
				}
				
			}
		}
		return false;
	}

}
