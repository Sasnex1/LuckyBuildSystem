package de.djreedoo.luckybuild.main;
/*written by DJREEDOO (GERMANY)
 *schreibe dieses plugin belieben um :)
 *falls du fragen hast Discord: DJREEDOO#5163
 */
import de.djreedoo.luckybuild.commands.*;
import de.djreedoo.luckybuild.listeners.*;
import de.djreedoo.luckybuild.lootEntitys.*;
import de.djreedoo.luckybuild.test.worldcommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    private static Main plugin;

    public void onEnable(){
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fliegen").setExecutor(new FliegenCommand());
        getCommand("hilfe").setExecutor(new Helpdeafultplayer());
        getCommand("hlist").setExecutor(new HelpAdminPlayer());
        getCommand("hdelete").setExecutor(new Helpymldelete());
        getCommand("commands").setExecutor(new commandsCommand());
        getCommand("pl").setExecutor(new slashpl());
        getCommand("plugins").setExecutor(new slashpl());
        getCommand("spieler").setExecutor(new onlinethisplayer());
        getCommand("lootpig").setExecutor(new lootschwein());
        getCommand("lootcreeper").setExecutor(new lootcreeper());
        getCommand("lootskellet").setExecutor(new lootskellet());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListeners(), this);
        pm.registerEvents(new lootschwein(), this);
        pm.registerEvents(new lootcreeper(), this);
        pm.registerEvents(new lootskellet(), this);

        System.out.println("§6LuckyBuild §8| §7System ist §aaktiviert§7.");

        lootschwein foodPig = new lootschwein();
        lootcreeper lootcreeper = new lootcreeper();
        lootskellet skellet = new lootskellet();
    }

    public static JavaPlugin getPlugin(){
        return plugin;
    }
}