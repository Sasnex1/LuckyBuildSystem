package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import de.djreedoo.luckybuild.main.Things;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    public static String a = Things.zeichen;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args) {
        if(sender instanceof Player){
            Player p =(Player)sender;
            if(args.length == 0){
                p.sendMessage(a+ "§5§lDiscord§6 Link: DEIN LINK");
            }else
                p.sendMessage(a+"§6§lBitte benutze nur /discord");
        }
        return false;
    }
}

