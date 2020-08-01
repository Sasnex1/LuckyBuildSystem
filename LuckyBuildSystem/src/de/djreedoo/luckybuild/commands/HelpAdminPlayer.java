package de.djreedoo.luckybuild.commands;
//written by DJREEDOO (GERMANY)
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpAdminPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("lucky.hlist")){
                if(args.length == 0){
                   try{
                       File file = new File("plugins//ServerSystem//hilfe.yml");
                       Scanner Leser = new Scanner(file);
                       while(Leser.hasNextLine()){
                           String data = Leser.nextLine();
                           p.sendMessage("§6§l"+data);
                       }
                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   }
                }else
                p.sendMessage("§6§l/hlist");
            }else
                p.sendMessage("§4Dazu hast du keine berechtigung");
        }
        return false;
    }
}
