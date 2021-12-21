package me.lca.skush.module.impl.visual;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ESP", displayName = "ESP", description = "drawing other Players", category = Category.Visual, color = 0xFFb8d81c)
public class ESP extends Module {

    @Subscribe
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("ESP \u00A77" + "Shader");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}