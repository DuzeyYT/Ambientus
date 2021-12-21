package me.lca.skush.module.impl.visual;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "NameTags", displayName = "NameTags", description = "giving players NameTags", category = Category.Visual, color = 0xFFb27e96)
public class NameTags extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}