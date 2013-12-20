package fr.iwebster.wizardbook;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WizardBookHandler {
	
	public WizardBookHandler(){
	}
	
	/**
	 * Opens Player p's enderchest and decrements the used WizardBook durability
	 * @param p the Player whose EnderChest has to be opened
	 * @param i the WizardBook's ItemStack object of this player
	 */
	public void openEnderChest(Player p, ItemStack i){
		p.playSound(p.getLocation(), Sound.PORTAL, 0.5F, 1.5F);
		p.openInventory(p.getEnderChest());
		
		i.setDurability((short) (i.getDurability()-1));
		
		//destroy the thing
		if(i.getDurability()<=0){
			p.getInventory().remove(i);
			p.playSound(p.getLocation(), Sound.FIZZ, 0.2F, 0.5F);
			p.sendMessage(ChatColor.GRAY.toString()+ChatColor.ITALIC.toString()+"The WizardBook broke up.");
		} else {
			p.sendMessage(ChatColor.GRAY.toString()+ChatColor.ITALIC.toString()+"You still can open a book to the void "+i.getDurability() +" times.");
		}
	}

}
