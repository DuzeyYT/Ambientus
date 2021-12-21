package me.lca.skush.module.impl.hud;

import com.google.common.eventbus.Subscribe;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.event.impl.Event2D;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;

@ModuleInterface(name = "HUD", category = Category.HUD, color = 0xFFFFFF)
public class HUD extends Module {

    @Override
    public void setup() {
        String[] watermarkMode = new String[] { "Basic" };
        addSetting(new Setting("Watermark Mode", this, "Basic", watermarkMode));

        String[] arrayListMode = new String[] { "Basic" };
        addSetting(new Setting("ArrayList Mode", this, "Basic", watermarkMode));
    }

    @Subscribe
    public void onRender(Event2D event) {
        renderWatermark();
        renderArrayList();
    }

    private void renderWatermark() {
        String mode = getSetting(this, "Watermark Mode").getValString();
    }

    private void renderArrayList() {
        String mode = getSetting(this, "ArrayList Mode").getValString();
    }
}
