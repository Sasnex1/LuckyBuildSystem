package de.djreedoo.luckybuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class onlinethisplayer implements CommandExecutor {//damit kannst du ingame /onkine <spieler> checken ob dieser online ist ich finde es ist ein cooles feature
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p =(Player)sender;
            Player target = Bukkit.getPlayer(args[0]);
            if(args.length == 1){
                if(target != null){
                    p.sendMessage("§6"+target.getName()+" §4ist Online");
                }else
                    p.sendMessage("§c§lDieser Spieler ist nicht Online");
            }
        }
        return false;
    }
}
