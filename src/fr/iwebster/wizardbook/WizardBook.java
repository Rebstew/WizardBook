package fr.iwebster.wizardbook;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class WizardBook extends JavaPlugin{

	private ItemMeta booksMeta;
	private WizardBookHandler handler;
	
	public void onEnable(){
		//usual onEnable stuff
		this.getServer().getPluginManager().registerEvents(new WizardBookListener(this), this);
		this.handler = new WizardBookHandler();
		
		//create the book
		ItemStack wizardbook = new ItemStack(Material.ENCHANTED_BOOK);
		//TODO read the durability through a config file
		wizardbook.setDurability((short) 64);
		
		//set its meta
		booksMeta = wizardbook.getItemMeta();
		List<String> lore = new ArrayList<String>();
		String description = new String(ChatColor.GRAY.toString() + ChatColor.ITALIC.toString() + "Opens a chest into the void.");
		lore.add(description);
		booksMeta.setDisplayName(ChatColor.DARK_PURPLE+"WizardBook");
		booksMeta.setLore(lore);
		wizardbook.setItemMeta(booksMeta);
		
		//create the recipe
		ShapelessRecipe recipe = new ShapelessRecipe(wizardbook);
		recipe.addIngredient(Material.BOOK);
		recipe.addIngredient(Material.EYE_OF_ENDER);
	
		//add the recipe
		this.getServer().addRecipe(recipe);
		
	}
	
	/**
	 * Gets the ItemMeta of a proper WizardBook
	 * @return the ItemMeta of a WizardBook
	 */
	public ItemMeta getBooksMeta(){
		return booksMeta;
	}
	
	/**
	 * Gets this plugin's event handler
	 * @return this plugin's event handler
	 */
	public WizardBookHandler getHandler(){
		return handler;
	}
	
	public void onDisable(){
		
	}
}
