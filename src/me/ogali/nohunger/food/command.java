package me.ogali.nohunger.food;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor {

    foodItem item = new foodItem();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("NoHunger") || label.equalsIgnoreCase("nh")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console can't do that, you silly goose.");
                return true;
            }
            Player player = (Player) sender;
            if (player.getInventory().firstEmpty() == -1) {
                Location dl = player.getLocation();
                World dlw = player.getWorld();

                dlw.dropItemNaturally(dl, item.getCF1());
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cIUh Oh! Your inventory was full so the item was dropped at your feet!"));
                return true;
            }
            if (args.length >= 1) {
                player.getInventory().addItem(item.getCF1());
                player.updateInventory();
            } else {
                player.sendMessage("&cUsage: /nohunger <amount>");
            }
        }
        return false;
    }
}
