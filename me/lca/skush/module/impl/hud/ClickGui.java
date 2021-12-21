package me.lca.skush.module.impl.hud;

import me.lca.skush.Ambien;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "ClickGui", description = "UI for mods and setting", category = Category.HUD)
public class ClickGui extends Module {

    @Override
    public void onEnable() {
        super.onEnable();
        mc.displayGuiScreen(Ambien.INSTANCE.getClickGui());
       // toggle();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
