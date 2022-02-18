package me.lca.skush.module.impl.movement;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

@ModuleInterface(name = "Speed", displayName = "Speed", category = Category.Movement)
public class Speed extends Module {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        /* Hypixel Test */
        if(mc.thePlayer.onGround) mc.thePlayer.jump();
        //mc.timer.timerSpeed = 3.0F;
        //if(mc.thePlayer.ticksExisted % 30 == 0) mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(0, 0, 0, true));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.timer.timerSpeed = 1.0F;
    }
}
