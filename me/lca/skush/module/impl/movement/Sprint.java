package me.lca.skush.module.impl.movement;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "Sprint", displayName = "Sprint", description = "Will automatically Sprint", category = Category.Movement, color = 0xFFbc78cf)
public class Sprint extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if (!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0) {
            mc.thePlayer.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.thePlayer.setSprinting(false);
    }
}
