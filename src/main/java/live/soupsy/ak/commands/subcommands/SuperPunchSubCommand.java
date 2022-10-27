package live.soupsy.ak.commands.subcommands;

import live.soupsy.ak.Ak;
import live.soupsy.ak.commands.SubCommand;
import live.soupsy.ak.utils.ArgNumbCheckUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SuperPunchSubCommand extends SubCommand {

    public SuperPunchSubCommand() {
    }
    @Override
    public String getName() {
        return "superpunch";
    }
    @Override
    public String getDescription() {
        return "Turn your fists into powerful weapons";
    }
    @Override
    public String getSyntax() {
        return "/ak superpunch <Player name> <uses> <silent? (t or f)>";
    }


    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            if(args.length==4){
                Player tar = Bukkit.getPlayer(args[1]);
                UUID t = tar.getUniqueId();
                if(t instanceof UUID && ArgNumbCheckUtil.isInt(args[2]) && args[3].equalsIgnoreCase("t") || args[3].equalsIgnoreCase("f")){
                    if (Ak.list_super_punch.contains(t)) {
                        Ak.list_super_punch.remove(t);
                        if (args[3].equalsIgnoreCase("f")){
                            tar.sendMessage("§2§lA§a§lK §3§l> §r§e" + "§cRemoved §efrom §6"+getName()+" §elist.");
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§2§lRemoved §a§l"+tar.getDisplayName()+" §2§lfrom §6§l"+getName()+"§2§l."));
                        }
                    }else{
                        Ak.list_super_punch.add(t);
                        if (args[3].equalsIgnoreCase("f")){
                            tar.sendMessage("§2§lA§a§lK §3§l> §r§e" + "§bAdded §eto §6"+getName()+" §elist.");
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§2§lAdded §a§l"+tar.getDisplayName()+" §2§lto §6§l"+getName()+"§2§l."));
                        }
                    }
                }else{
                    player.sendMessage("§2"+getSyntax());
                }
            }else{
                player.sendMessage("§2"+getSyntax());
            }

        }

    }
}
