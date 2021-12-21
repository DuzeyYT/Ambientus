package me.lca.skush.module.impl.combat;


import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventPacket;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

@ModuleInterface(name = "Velocity", displayName = "Velocity", description = "Reduce Your Velocity", category = Category.Combat, color = 0xFFa7bacd)
public class Velocity extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("Velocity \u00A77" + "Cancel");



    }

    @Subscribe
    public void eventPacket(EventPacket e) {
        if (e instanceof EventPacket) {
            Packet p = EventPacket.INSTANCE.getPacket();
            if (p instanceof S12PacketEntityVelocity) {
                S12PacketEntityVelocity packet = (S12PacketEntityVelocity) p;
                if (packet.getEntityID() == mc.thePlayer.getEntityId())
                    EventPacket.INSTANCE.setCancelled(true);
            }
            if (p instanceof net.minecraft.network.play.server.S27PacketExplosion)
                EventPacket.INSTANCE.setCancelled(true);
        }
    }


    @Override
    public void onDisable() {
        super.onDisable();

    }
}
