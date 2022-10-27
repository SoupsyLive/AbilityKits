package live.soupsy.ak.events;

import live.soupsy.ak.Ak;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

import java.util.UUID;

public class RideHeadEvent implements Listener {



    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent e){
        Entity v = e.getRightClicked(); //Victim
        Entity ap = e.getPlayer(); //Assaulter
        UUID a = ap.getUniqueId();
        if (ap instanceof Player){
            if(Ak.list_super_punch.contains(a)){
                if (((Player) ap).getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    v.addPassenger(ap);
                }
            }

        }
    }
}
