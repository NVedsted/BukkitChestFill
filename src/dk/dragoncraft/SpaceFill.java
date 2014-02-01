package dk.dragoncraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpaceFill extends BasicFill implements CommandExecutor{
	private int count;
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(sender instanceof Player){
			Player p=(Player)sender;
			if(checkHand(p))
				return true;
			Inventory ci=getInv(p);
			if(ci==null)
				return true;
			ItemMeta im=p.getItemInHand().getItemMeta();
			ItemStack is=p.getItemInHand().clone();
			is.setItemMeta(im);
			if(args.length>=1){
				if(args[0].equals("*")){
					count =ci.getSize();
				}else{
					try{
						count=Integer.parseInt(args[0]);
						if(count>ci.getSize())
							count=ci.getSize();
					}catch(NumberFormatException e){
						p.sendMessage("Must be a number!");
						return true;
					}
				}
			}else{
				count =ci.getSize();
			}
			if(args.length == 2){
				try{
					is.setAmount(Integer.parseInt(args[1]));
				}catch(NumberFormatException e){
					p.sendMessage("Must be a number!");
					return true;
				}
			}else{
				is.setAmount(is.getMaxStackSize());
			}
			specialFill(ci, count, is);
			p.sendMessage("Inventory filled.");
		}
		return true;
	}
}
