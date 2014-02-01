package dk.dragoncraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Open extends BasicFill implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player p=(Player)sender;
			Inventory i=getInv(p);
			if(i==null)
				return true;
			p.openInventory(i);
		}
		return true;
	}

}
