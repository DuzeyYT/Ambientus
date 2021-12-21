package me.lca.skush.module.impl.combat;


import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "Velocity", displayName = "Velocity", description = "Reduce Your Velocity", category = Category.Combat, color = 0xFFa7bacd)
public class Velocity extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("Velocity \u00A77" + "Cancel");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}
