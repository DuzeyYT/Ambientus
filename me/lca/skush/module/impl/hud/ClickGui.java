package me.lca.skush.module.impl.hud;

import me.lca.skush.Ambien;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

import java.util.ArrayList;

@ModuleInterface(name = "ClickGui", description = "UI for mods and setting", category = Category.HUD)
public class ClickGui extends Module {

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        Ambien.INSTANCE.settingsManager.rSetting(new Setting("Design", this, "New", options));
        Ambien.INSTANCE.settingsManager.rSetting(new Setting("Sound", this, false));
        Ambien.INSTANCE.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        Ambien.INSTANCE.settingsManager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
        Ambien.INSTANCE.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.displayGuiScreen(Ambien.INSTANCE.heroCodeGui);
       // toggle();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
