package me.ogali.nohunger;

import me.ogali.nohunger.events.NoHunger;
import me.ogali.nohunger.events.foodEvent;
import me.ogali.nohunger.food.command;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("NoHunger").setExecutor(new command());
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new NoHunger(this), this);
        pm.registerEvents(new foodEvent(), this);
    }
    @Override
    public void onDisable() {
    }
}