package me.lca.skush.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "InventoryMove", displayName = "InventoryMove", description = "Walk on your guis", category = Category.Movement, color = 0xFF4cbe7b)
public class InventoryMove extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("InventoryMove \u00A77" + " AACP");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}
