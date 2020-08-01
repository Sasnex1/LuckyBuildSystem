package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)

import de.djreedoo.luckybuild.main.Things;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {
    private static String a = Things.zeichen;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    StringBuilder msg = new StringBuilder();
                    for (int i = 1; i < args.length; i++)
                        msg.append(args[i]).append(" ");
                    String s = msg.toString().trim();
                    t.sendMessage(a + "§5Nachricht §6von: §2" + p.getName() + "§e •§6● §8» " + t.getName() + "§e •§6● §8» \n" + s);
                    p.sendMessage(a + "§6Du hast eine §5Nachricht §6an " + t.getName() + " §6gesendet.");
                } else
                    p.sendMessage(a + "§6§lDieser Spieler ist nicht Online versuche es später erneut");
            }
        }
        return false;
    }
}
