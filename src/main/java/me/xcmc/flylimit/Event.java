package me.xcmc.flylimit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.List;
import java.util.Objects;

import static me.xcmc.flylimit.FlyLimit.*;

public class Event implements Listener {
    @EventHandler
    public void PlayerToggleFlightEvent(PlayerToggleFlightEvent e){
        if(!e.isFlying())
            return;
        List<String> world= main.getConfig().getStringList("worlds");
        String name = e.getPlayer().getWorld().getName();
        for(String i : world){
            if(i.equals(name)){
                if(e.getPlayer().isOp())
                    return;
                e.setCancelled(true);
                e.getPlayer().setFlying(false);
                e.getPlayer().sendTitle(title, sub_title,3,5,3);
            }
        }
    }
}
