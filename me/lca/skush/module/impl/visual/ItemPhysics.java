package me.lca.skush.module.impl.visual;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ItemPhysics", displayName = "ItemPhysics", description = "giving Items Physics", category = Category.Visual, color = 0xFF1a69a3)
public class ItemPhysics extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}