package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import de.djreedoo.luckybuild.main.Things;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    public static String a = Things.zeichen;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lucky.heal")) {
                if (args.length == 0) {
                p.setFoodLevel(20);
                p.setHealth(20);
                p.sendMessage(a+"§6§lDu wurdest §2§lgeheilt§7§l!");
                } else
                p.sendMessage(a+"§6§lbitte benutze §2/heal");
            }else
                p.sendMessage("§4Dazu hast du keine berechtigung");
        }
        return false;
    }
}
