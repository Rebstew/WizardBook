package fr.iwebster.wizardbook;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WizardBookListener implements Listener{

	private WizardBook plugin;
	
	public WizardBookListener(WizardBook plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e){
		//if player right clicked with a wizardbook
		if((e.getAction() == Action.RIGHT_CLICK_AIR) && (e.getPlayer().getItemInHand().getItemMeta().equals(plugin.getBooksMeta()))){
			plugin.getHandler().openEnderChest(e.getPlayer(), e.getPlayer().getItemInHand());
		}
	}
}
