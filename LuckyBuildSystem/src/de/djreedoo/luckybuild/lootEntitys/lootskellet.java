package de.djreedoo.luckybuild.lootEntitys;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class lootskellet implements CommandExecutor, Listener {
    private final String name = "§6§lTÖTE MICH";

    private void spawnFoodSkellet(Location location) {
        Skeleton skl = (Skeleton) location.getWorld().spawnEntity(location, EntityType.SKELETON);
        skl.setCustomName(name);
        skl.setCustomNameVisible(true);
        skl.setAI(true);
        skl.setTarget(null);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lucky.loot")) {
                if (args.length == 0) {
                    spawnFoodSkellet(p.getLocation());
                }
            }
        }
        return false;
    }

    @EventHandler
    public void handleFoodPigDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Pig)) return;
        Skeleton skl = (Skeleton) e.getEntity();
        if (!skl.getCustomName().equals(name)) return;
        e.getDrops().clear();
        ItemStack foodDrop = new ItemStack(Material.BEEF, 5);
        skl.getWorld().dropItemNaturally(skl.getLocation(), foodDrop);

        Player player = skl.getKiller();
        if (player.hasPermission("lucky.loot") && (player.getItemInHand().getType() == Material.STICK)) return;
        spawnFoodSkellet(skl.getLocation());
    }
}
