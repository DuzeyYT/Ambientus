package me.lca.skush.module.impl.movement;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "NoSlowDown", displayName = "NoSlowDown", description = "Not Slowing Down", category = Category.Movement, color = 0xFFc0cd44)
public class NoSlowDown extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("NoSlowDown \u00A77" + "AAC");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}
