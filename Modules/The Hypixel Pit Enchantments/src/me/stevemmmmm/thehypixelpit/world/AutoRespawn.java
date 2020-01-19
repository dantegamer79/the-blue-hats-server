package me.stevemmmmm.thehypixelpit.world;

/*
 * Copyright (c) 2020. Created by the Pit Player: Stevemmmmm.
 */

import me.stevemmmmm.thehypixelpit.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class AutoRespawn implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getEntity().getKiller().sendMessage(ChatColor.RED + "You killed " + event.getEntity().getName() + "!");
        event.setDeathMessage("");
        Player player = event.getEntity();

        player.setHealth(player.getMaxHealth());
        player.teleport(new Location(player.getWorld(), 0.5, 115.5, -7.5));

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, () -> {
            player.setFireTicks(0);
            player.setVelocity(new Vector(0, 0, 0));
        }, 1);
    }
}