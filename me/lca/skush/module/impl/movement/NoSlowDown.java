package me.lca.skush.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "NoSlowDown", displayName = "NoSlowDown", description = "Not Slowing Down", category = Category.Movement, color = 0xFFc0cd44)
public class NoSlowDown extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}
