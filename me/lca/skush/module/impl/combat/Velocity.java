package me.lca.skush.module.impl.combat;


import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventPacket;
import me.lca.skush.event.impl.EventReceivedPacket;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

@ModuleInterface(name = "Velocity", displayName = "Velocity", description = "Reduce Your Velocity", category = Category.Combat, color = 0xFFa7bacd)
public class Velocity extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("Velocity \u00A77" + "Cancel");
    }

    @EventTarget
    public void eventRecivedPacket(EventReceivedPacket e) {
        Packet p = e.getPacket();
        if (p instanceof S12PacketEntityVelocity) {
            S12PacketEntityVelocity packet = (S12PacketEntityVelocity) p;
            //if (packet.getEntityID() == mc.thePlayer.getEntityId())
                e.setCancelled(true);
        }
        if (p instanceof net.minecraft.network.play.server.S27PacketExplosion)
            e.setCancelled(true);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
