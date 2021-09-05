package me.ogali.nohunger.food;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class foodItem extends ItemStack {

    public foodItem() {
        getCF1();
    }

    public ItemStack getCF1() {
        ItemStack item = new ItemStack(Material.COOKIE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName (ChatColor.translateAlternateColorCodes('&', "&6SPECIAL COOKIE"));
        meta.addEnchant(Enchantment.LURE,1 , true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        lore.add("");
        lore.add(ChatColor.translateAlternateColorCodes('&', "&fI am a special cookie."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&fRight Click me to see."));
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }
}
