package live.soupsy.ak.commands;

import live.soupsy.ak.commands.subcommands.SuperPunchSubCommand;
import live.soupsy.ak.commands.subcommands.dashAbilitySubcommand;
import live.soupsy.ak.commands.subcommands.tridentAbilitySubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class abilityCommand implements CommandExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public abilityCommand(){
        subcommands.add(new dashAbilitySubcommand());
        subcommands.add(new tridentAbilitySubcommand());

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if(args.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }
        }
        return true;
    }
    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }
}
