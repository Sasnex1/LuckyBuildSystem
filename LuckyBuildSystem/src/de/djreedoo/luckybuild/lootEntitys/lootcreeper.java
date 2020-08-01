package de.djreedoo.luckybuild.lootEntitys;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class lootcreeper implements CommandExecutor, Listener {
    private final String CREEPER_TITLE = "§6§lTÖTE MICH";

    private void spawnLootCreeper(Location location) {
        Creeper creeper = (Creeper) location.getWorld().spawnEntity(location, EntityType.CREEPER);
        creeper.setExplosionRadius(0);
        creeper.setCustomName(CREEPER_TITLE);
        creeper.setCustomNameVisible(true);
        creeper.setHealth(1);
        creeper.setAI(true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lucky.loot")) {
                if (args.length == 0) {
                    spawnLootCreeper(p.getLocation());

                }
            }
        }
        return false;
    }

    @EventHandler
    public void handleFoodPigDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Creeper)) return;
        Creeper creeper = (Creeper) e.getEntity();
        if (!creeper.getCustomName().equals(CREEPER_TITLE)) return;
        e.getDrops().clear();
        ItemStack foodDrop = new ItemStack(Material.GUNPOWDER, 3);
        creeper.getWorld().dropItemNaturally(creeper.getLocation(), foodDrop);

        Player player = creeper.getKiller();
        if (player.hasPermission("lucky.loot") && (player.getItemInHand().getType() == Material.STICK)) return;
        spawnLootCreeper(creeper.getLocation());
    }
}
