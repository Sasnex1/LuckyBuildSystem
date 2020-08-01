package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.File;

public class Helpymldelete implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("lucky.deletefile")) {
                if (args.length == 0) {
                    File file = new File("plugins//ServerSystem//hilfe.yml");
                    if (file.exists()) {
                        file.delete();
                        p.sendMessage("§6§lDatei gelöscht");
                    } else
                    p.sendMessage("§6§lDie Datei 'hilfe.yml' wurde nicht gelöscht");
                }
            }else
                p.sendMessage("§4Dazu hast du keine berechtigung");
        }
        return false;
    }
}
