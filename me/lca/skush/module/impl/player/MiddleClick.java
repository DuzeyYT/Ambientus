package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "MiddleClick", displayName = "MiddleClick", description = "add Friends with MiddleClick", category = Category.Player, color = 0xFF8485c7)
public class MiddleClick extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}