package me.lca.skush.module.impl.visual;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "BedESP", displayName = "BedESP", description = "drawing your Bed", category = Category.Visual, color = 0xFFbc7ef2)
public class BedESP extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}