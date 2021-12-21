package me.lca.skush.module.impl.player;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ChestStealer", displayName = "ChestStealer", description = "Steals Your Chest", category = Category.Player, color = 0xFF15ae86)
public class ChestStealer extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}