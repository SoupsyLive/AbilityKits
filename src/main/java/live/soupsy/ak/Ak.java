package live.soupsy.ak;

import jdk.internal.reflect.Reflection;
import live.soupsy.ak.commands.abilityCommand;
import live.soupsy.ak.commands.akCommand;
import live.soupsy.ak.commands.subcommands.akCompleter;
import live.soupsy.ak.commands.subcommands.akbilityCompleter;
import live.soupsy.ak.events.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class Ak extends JavaPlugin {

    //Lists
    public ArrayList<Player> test_list = new ArrayList<>();
    public static ArrayList<UUID> list_super_punch = new ArrayList<>();
    public static ArrayList<UUID> list_trident_ride = new ArrayList<>();


    @Override
    public void onEnable() {

        // Plugin startup logic
        getCommand("ak").setExecutor(new akCommand());
        getCommand("ak").setTabCompleter(new akCompleter());
        getCommand("akbility").setExecutor(new abilityCommand());
        getCommand("akbility").setTabCompleter(new akbilityCompleter());

        getServer().getPluginManager().registerEvents(new SuperPunchEvent(), this);
        getServer().getPluginManager().registerEvents(new RideHeadEvent(), this);
        getServer().getPluginManager().registerEvents(new TridentThrowEvent(), this);
        getServer().getPluginManager().registerEvents(new HealthPack(), this);
        getServer().getPluginManager().registerEvents(new ProjectHealthEvent(), this);



        System.out.println(ChatColor.BOLD+""+ChatColor.DARK_GREEN+"A"+ChatColor.GREEN+"K"+ChatColor.DARK_AQUA+" >"+ChatColor.RESET+" "+ChatColor.DARK_AQUA+"Plugin "+ChatColor.YELLOW+"Started.");


    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.BOLD+""+ChatColor.DARK_GREEN+"A"+ChatColor.GREEN+"K"+ChatColor.DARK_AQUA+" >"+ChatColor.RESET+" "+ChatColor.DARK_AQUA+"Plugin "+ChatColor.RED+"Closed.");

    }
}
