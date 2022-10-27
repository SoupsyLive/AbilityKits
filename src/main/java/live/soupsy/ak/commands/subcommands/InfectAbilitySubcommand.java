package live.soupsy.ak.commands.subcommands;

import live.soupsy.ak.commands.SubCommand;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class InfectAbilitySubcommand extends SubCommand {


    @Override
    public String getName() {
        return "infect";
    }
    @Override
    public String getDescription() {
        return "Infect nearby individuals";
    }
    @Override
    public String getSyntax() {
        return "/akbility infect <Player name> <silent? (t or f)>";
    }


    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            Player t = Bukkit.getPlayer(args[1]);
            if(t instanceof Player && args[2].equalsIgnoreCase("t") || t instanceof Player && args[2].equalsIgnoreCase("f")){
                for (Entity ps : t.getNearbyEntities(20, 1, 20)){
                    //ps.addPotionEffect()
                }
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
