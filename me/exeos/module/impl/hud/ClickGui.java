package me.exeos.module.impl.hud;

import me.exeos.Tutorial;
import me.exeos.interfaces.ModuleInterface;
import me.exeos.module.Category;
import me.exeos.module.Module;

@ModuleInterface(name = "ClickGui", description = "UI for mods and setting", category = Category.HUD)
public class ClickGui extends Module {

    @Override
    public void onEnable() {
        super.onEnable();
        mc.displayGuiScreen(Tutorial.INSTANCE.getClickGui());
       // toggle();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
