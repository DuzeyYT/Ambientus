package me.lca.skush.module.impl.player;

import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "AutoArmor", displayName = "AutoArmor", description = "Equip Your Armor", category = Category.Player, color = 0xFF0b97d4)
public class AutoArmor extends Module {

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("AutoArmor \u00A77" + "OpenInv");
    }

    @Override
    public void onDisable() {
        super.onDisable();

    }
}