package live.soupsy.ak.commands.subcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class akbilityCompleter implements TabCompleter {

    //private ArrayList<SubCommand> subcommands = new ArrayList<>();
    //public akCompleter(){
        //subcommands.add(new SuperPunchSubCommand());
    //}
    //public ArrayList<SubCommand> getSubcommands(){
        //return subcommands;
    //}

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1){

            //for (int i = 0; i < getSubcommands().size(); i++){
                //if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
            List<String> arguments = new ArrayList<>();
            arguments.add("dash");
            arguments.add("tridentthrow");
            return arguments;

                //}

            //}


        }
        return null;
    }
}
