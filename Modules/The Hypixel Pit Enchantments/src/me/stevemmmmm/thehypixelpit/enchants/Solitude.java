package me.stevemmmmm.thehypixelpit.enchants;

import me.stevemmmmm.thehypixelpit.managers.CustomEnchant;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2020. Created by the Pit Player: Stevemmmmm.
 */

public class Solitude extends CustomEnchant {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            triggerEnchant(((Player) event.getEntity()).getInventory().getLeggings(), event.getEntity(), event);
        }
    }

    @Override
    public void triggerEnchant(ItemStack sender, Object... args) {
        if (sender == null) return;

        EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) args[1];
        Player damaged = (Player) args[0];

        if (itemHasEnchant(sender, 1, this)) {
            List<Entity> entities = damaged.getNearbyEntities(7, 7, 7);
            List<Player> players = new ArrayList<>();

            for (Entity entity : entities) {
                if (entity instanceof Player) {
                    if (entity != damaged) {
                        players.add((Player) entity);
                    }
                }
            }

            if (players.size() <= 1) {
                event.setDamage(event.getDamage() * .60f);
            }
        }

        if (itemHasEnchant(sender, 2, this)) {
            List<Entity> entities = damaged.getNearbyEntities(7, 7, 7);
            List<Player> players = new ArrayList<>();

            for (Entity entity : entities) {
                if (entity instanceof Player) {
                    if (entity != damaged) {
                        players.add((Player) entity);
                    }
                }
            }

            if (players.size() <= 2) {
                event.setDamage(event.getDamage() * .50f);
            }
        }

        if (itemHasEnchant(sender, 3, this)) {
            List<Entity> entities = damaged.getNearbyEntities(7, 7, 7);
            List<Player> players = new ArrayList<>();

            for (Entity entity : entities) {
                if (entity instanceof Player) {
                    if (entity != damaged) {
                        players.add((Player) entity);
                    }
                }
            }

            if (players.size() <= 2) {
                event.setDamage(event.getDamage() * .40f);
            }
        }
    }

    @Override
    public String getName() {
        return "Solitude";
    }

    @Override
    public String getEnchantReferenceName() {
        return "Solitude";
    }

    @Override
    public ArrayList<String> getDescription(int level) {
        final String percent = level == 1 ? "-40%" : level == 2 ? "-50%" : level == 3 ? "-60%" : "";

        return new ArrayList<String>() {{
            add(ChatColor.GRAY + "Receive " + ChatColor.BLUE + percent + ChatColor.GRAY + " damage when two");
            add(ChatColor.GRAY + "or less players are within 7");
            add(ChatColor.GRAY + "blocks");
        }};
    }

    @Override
    public boolean isRareEnchant() {
        return true;
    }
}