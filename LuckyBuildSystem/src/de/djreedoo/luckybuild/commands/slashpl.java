package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class slashpl implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage("Plugins (1): §aDasKannDirEgalSein");
            } else
            p.sendMessage("§6§lbenutze/pl");
        }
        return false;
    }
}
