package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ChestStealer", displayName = "ChestStealer", description = "Steals Your Chest", category = Category.Player, color = 0xFF15ae86)
public class ChestStealer extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}