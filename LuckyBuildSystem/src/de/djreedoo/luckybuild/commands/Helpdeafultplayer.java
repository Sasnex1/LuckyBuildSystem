package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import de.djreedoo.luckybuild.main.Things;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.*;
import java.util.ArrayList;

public class Helpdeafultplayer implements Serializable, CommandExecutor {
    private static String x = Things.zeichen;
    public static ArrayList<String> hilfe = new ArrayList<>();
    public static void saveCustomYml() {
        File file = new File("plugins//ServerSystem//hilfe.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("lists.hilfe", hilfe);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                Player target = Bukkit.getPlayer(args[0]);
                StringBuilder a = new StringBuilder();
                for (int i = 0; i < args.length; i++)
                    a.append(args[i]).append(" ");
                String msg = a.toString().trim();
                hilfe.add("Spieler: " + p.getName() +" braucht Hilfe: " +msg);
                p.sendMessage("§6Deine Hilfe wurde gespeichert\n ein Admin/Inhaber wird sich das anschauen");
                String f = Things.prefix;
                Bukkit.broadcastMessage(f+"§6Spieler: §2" +p.getName()+ "§6 braucht Hilfe von einem admin oder/Inhaber");
                saveCustomYml();
            }
        }
        return false;
    }
}
