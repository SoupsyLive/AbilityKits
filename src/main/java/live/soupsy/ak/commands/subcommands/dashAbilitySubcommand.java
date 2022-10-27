package live.soupsy.ak.commands.subcommands;

import live.soupsy.ak.Ak;
import live.soupsy.ak.commands.SubCommand;
import live.soupsy.ak.utils.ArgNumbCheckUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class dashAbilitySubcommand extends SubCommand {


    @Override
    public String getName() {
        return "dash";
    }
    @Override
    public String getDescription() {
        return "Dash away";
    }
    @Override
    public String getSyntax() {
        return "/akbility dash <Player name> <silent? (t or f)>";
    }


    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            Player t = Bukkit.getPlayer(args[1]);
            if(t instanceof Player && args[2].equalsIgnoreCase("t") || t instanceof Player && args[2].equalsIgnoreCase("f")){

                if (t.isSneaking()){
                    Vector vector = t.getLocation().getDirection().setY(-0.1);
                    vector = vector.multiply(-3);
                    t.setVelocity(vector);
                }else{
                    Vector vector = t.getLocation().getDirection().setY(0.1);
                    vector = vector.multiply(3);
                    t.setVelocity(vector);
                }


                if (args[2].equalsIgnoreCase("f")){
                    t.sendMessage("§2§lA§a§lK §3§l> §r§e" + "Dashed.");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§2§lDashed §a§l"+t.getDisplayName()+"§2§l."));
                }
            }else{
                player.sendMessage("§2"+getSyntax());
            }
        }

    }
}
