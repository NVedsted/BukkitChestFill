package dk.dragoncraft;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Empty extends BasicFill implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player p=(Player)sender;
			Inventory ci=getInv(p);
			if(ci==null)
				return true;
			ItemStack is=new ItemStack(Material.AIR, 0);
			baseFill(ci, is);
			p.sendMessage("Inventory emptied.");
		}
		return true;
	}
}
