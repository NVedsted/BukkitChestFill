package dk.dragoncraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class BasicFill{
	public boolean checkHand(Player p){
		if(p.getItemInHand().getType()==Material.AIR){
			p.sendMessage("No item in hand!");
			return true;
		}else{
			return false;
		}
	}
	@SuppressWarnings("deprecation")
	public Block getBlock(Player p){
		return p.getTargetBlock(null, 100);
	}
	public Location getLoc(Player p){
		return getBlock(p).getLocation();
	}
	public Inventory getInv(Player p){
		Block block=getBlock(p);
		if(block.getState() instanceof InventoryHolder)
			return ((InventoryHolder) block.getState()).getInventory();
		else if(block.getType()==Material.ENDER_CHEST){
			return p.getEnderChest();
		}else{
			p.sendMessage("You must look at an inventory block!");
			return null;
		}
	}
	public void baseFill(Inventory inv, ItemStack is){
		baseFill(inv,inv.getSize(),is);
	}
	public void baseFill(Inventory inv,int count,ItemStack is){
		for(int i=0;i<count;i++){
			inv.setItem(i,is);
		}
	}
	public void specialFill(Inventory inv, ItemStack is){
		specialFill(inv,inv.getSize(),is);
	}
	public void specialFill(Inventory inv,int count,ItemStack is){
		for(int i=0;i<inv.getSize();i++){
			if(inv.getItem(i)==null){
				if(count>0){
					inv.setItem(i,is);
					count--;
				}else
					break;
			}
		}
	}
}
