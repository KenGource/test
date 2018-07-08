package me.sugestao;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandosSugestao implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
            sender.sendMessage("§cApenas players podem utilizar este comando!");
		}
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("sugestao")){
			if(args.length == 0){
	            p.sendMessage("§eUse: /sugestao <sugestao>");
			}
		}
		return false;
	}
}
