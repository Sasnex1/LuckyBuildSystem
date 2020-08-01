package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import de.djreedoo.luckybuild.main.Things;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    public static String a = Things.zeichen;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("lucky.gm")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(a+"§6§ldu hast dein Spielmodus zu §5§l" + GameMode.SURVIVAL + " §6§lgeändert");
                    }
                    if (args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(a+"§6§ldu hast dein Spielmodus zu §5§l" + GameMode.CREATIVE + " §6§lgeändert");
                    }
                    if (args[0].equalsIgnoreCase("2")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(a+"§6§ldu hast dein Spielmodus zu §5§l" + GameMode.SPECTATOR + " §6§lgeändert");
                    }
                    if (args[0].equalsIgnoreCase("3")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(a+"§6§ldu hast dein Spielmodus zu §5§l" + GameMode.ADVENTURE + " §6§lgeändert");
                    }
                }else
                    player.sendMessage("§6Bitte benutze §2/gm <0, 1, 2, 3>");
            }
        }
        return false;
    }

}