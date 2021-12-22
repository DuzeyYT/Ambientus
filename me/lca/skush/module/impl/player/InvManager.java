package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "InvManager", displayName = "InvManager", description = "Sort Your Items", category = Category.Player, color = 0xFFd7a22d)
public class InvManager extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("InvManager \u00A77" + "OpenInv");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}