package me.ogali.nohunger.events;

import me.ogali.nohunger.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class NoHunger implements Listener {

    private final Main m;
    public NoHunger(Main m) {
        this.m = m;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (!(p.hasPermission(m.getConfig().getString("nohunger-perm"))) || p.getFoodLevel() == 20) {
            return;
        }
        p.setFoodLevel(20);
    }
    @EventHandler
    public void noHunger(FoodLevelChangeEvent e) {
        Entity t = e.getEntity();
        if (e.getEntityType() == EntityType.PLAYER) {
            if (t.hasPermission(m.getConfig().getString("nohunger-perm"))) {
                e.setCancelled(true);
            }
        }
    }
}