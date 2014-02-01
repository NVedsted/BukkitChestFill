package dk.dragoncraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Place extends BasicFill implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player p=(Player)sender;
			if(checkHand(p))
				return true;
			Location loc=getLoc(p);
			loc.setY(loc.getY()+1);
			loc.getBlock().setType(Material.CHEST);
			InventoryHolder chest=(InventoryHolder)loc.getBlock().getState();
			Inventory inv=chest.getInventory();
			ItemMeta im=p.getItemInHand().getItemMeta();
			ItemStack is=p.getItemInHand().clone();
			is.setItemMeta(im);
			baseFill(inv,is);
		}
		return true;
	}

}
