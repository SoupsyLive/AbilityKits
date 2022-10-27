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
import org.bukkit.util.Vector;

import java.util.UUID;

public class SuperPunchEvent implements Listener {



    @EventHandler
    public void PlayerPunch(EntityDamageByEntityEvent e){
        Entity v = e.getEntity(); //Victim
        Entity ap = e.getDamager(); //Assaulter

        if (ap instanceof Player){
            UUID a = ap.getUniqueId();
            if(Ak.list_super_punch.contains(a)){
                if (((Player) ap).getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    if(((Player) ap).isSneaking()){
                        Vector vector = ap.getLocation().getDirection().setY(0.1);
                        vector = vector.multiply(6);
                        v.setVelocity(vector);

                        v.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, v.getLocation(), 0);
                        ((Player) ap).playSound(ap.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 100.0f, 1.0f);
                    }else{
                        Vector vector = ap.getLocation().getDirection().setY(0.1);
                        vector = vector.multiply(5);
                        v.setVelocity(vector);
                        v.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, v.getLocation(), 0);
                        ((Player) ap).playSound(ap.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 100.0f, 2.0f);
                    }
                }
            }

        }
    }
}
