package me.ogali.nohunger.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class foodEvent implements Listener {

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		ItemMeta meta = item.getItemMeta();

		if (item.getType().equals(Material.AIR)) return;
		if (!(item.hasItemMeta())) return;
		if (!(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&6SPECIAL COOKIE"))))
			return;

		if (e.getAction() == (Action.RIGHT_CLICK_BLOCK) || e.getAction() == (Action.RIGHT_CLICK_AIR)) {
			ItemStack food = p.getInventory().getItemInMainHand();
			food.setAmount(food.getAmount() - 1);
			p.getInventory().setItemInMainHand(food);
			e.getPlayer().updateInventory();
			e.setCancelled(true);
			p.setFoodLevel(20);
			p.setSaturation(20);
		}
	}
}
