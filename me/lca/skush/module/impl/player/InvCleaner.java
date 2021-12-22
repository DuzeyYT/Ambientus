package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "InvCleaner", displayName = "InvCleaner", description = "drop items", category = Category.Player, color = 0xFF9dbae2)
public class InvCleaner extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("InvCleaner \u00A77" + "OpenInv");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}