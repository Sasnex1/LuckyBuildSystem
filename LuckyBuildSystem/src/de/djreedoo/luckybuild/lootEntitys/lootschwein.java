package de.djreedoo.luckybuild.lootEntitys;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class lootschwein implements CommandExecutor, Listener {
    private final String PIG_TITLE = "§6§lTÖTE MICH";

    private void spawnFoodPig(Location location) {
        Pig pig = (Pig) location.getWorld().spawnEntity(location, EntityType.PIG);
        pig.setCustomName(PIG_TITLE);
        pig.setCustomNameVisible(true);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lucky.loot")) {
                if (args.length == 0) {
                    spawnFoodPig(p.getLocation());
                }
            }
        }
        return false;
    }

    @EventHandler
    public void handleFoodPigDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof Pig)) return;
        Pig pig = (Pig) e.getEntity();
        if (!pig.getCustomName().equals(PIG_TITLE)) return;
        e.getDrops().clear();
        ItemStack foodDrop = new ItemStack(Material.BEEF, 5);
        pig.getWorld().dropItemNaturally(pig.getLocation(), foodDrop);

        Player player = pig.getKiller();
        if (player.hasPermission("lucky.loot") && (player.getItemInHand().getType() == Material.STICK)) return;
        spawnFoodPig(pig.getLocation());
    }

}
