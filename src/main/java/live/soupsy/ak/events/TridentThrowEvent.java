package live.soupsy.ak.events;

import live.soupsy.ak.Ak;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

public class TridentThrowEvent implements Listener {



    @EventHandler
    public void onRightClick(ProjectileLaunchEvent e){
        EntityType tri = e.getEntityType();
        ProjectileSource ap = e.getEntity().getShooter();

        if(tri == EntityType.TRIDENT && ap instanceof Player || tri == EntityType.EGG && ap instanceof Player){

            Player player = (Player) ap;
            UUID a = player.getUniqueId();
            if(Ak.list_trident_ride.contains(a) && tri == EntityType.TRIDENT){
                e.getEntity().addPassenger(player);
            }else if(Ak.list_super_punch.contains(a) && tri == EntityType.EGG){
                e.getEntity().addPassenger(player);
            }
        }
    }
}
