package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "PingSpoof", displayName = "PingSpoof", description = "Spoof Your Ping", category = Category.Player, color = 0xFFcb942f)
public class PingSpoof extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("PingSpoof \u00A77" + "AAC");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}