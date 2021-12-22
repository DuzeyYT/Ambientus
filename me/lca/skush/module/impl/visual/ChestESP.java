package me.lca.skush.module.impl.visual;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ChestESP", displayName = "ChestESP", description = "drawing your Chests", category = Category.Visual, color = 0xFFc54d00)
public class ChestESP extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("ChestESP \u00A77" + "Shader");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}