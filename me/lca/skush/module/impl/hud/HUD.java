package me.lca.skush.module.impl.hud;

import me.lca.skush.Ambien;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.Event2D;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

@ModuleInterface(name = "HUD", displayName = "HUD", category = Category.HUD,color = 0xFFbf5002)
public class HUD extends Module {

    @Override
    public void setup() {
        String[] watermarkMode = new String[] { "Basic" };
        addSetting(new Setting("Watermark Mode", this, "Basic", watermarkMode));

        String[] arrayListMode = new String[] { "Basic" };
        addSetting(new Setting("ArrayList Mode", this, "Basic", watermarkMode));
    }

    @EventTarget
    public void onRender(Event2D event) {
       // renderWatermark();
        renderArrayList();
    }

    private void renderWatermark() {
        String mode = getSetting(this, "Watermark Mode").getValString();
        FontRenderer fr = mc.fontRendererObj;
        ScaledResolution sr = new ScaledResolution(mc);

        switch(mode) {
            case "Basic": {
                fr.drawStringWithShadow(Ambien.INSTANCE.name + " " + Ambien.INSTANCE.version, 3, 3, 0xFFFFFF);
                break;
            }
            /* More */
        }
    }

    private void renderArrayList() {
        String mode = getSetting(this, "ArrayList Mode").getValString();
        FontRenderer fr = mc.fontRendererObj;
        ScaledResolution sr = new ScaledResolution(mc);

        /* Sorting (Pretty hardcoded) */
        Collections.sort(Ambien.INSTANCE.moduleManager.getModules(), new Comparator<Module>() {
            @Override
            public int compare(Module m1, Module m2) {
                if (Ambien.INSTANCE.fontManager.ambienFont.getWidth(m1.getDisplayName()) > Ambien.INSTANCE.fontManager.ambienFont.getWidth(m2.getDisplayName())) {
                    return -1;
                }
                if (Ambien.INSTANCE.fontManager.ambienFont.getWidth(m1.getDisplayName()) < Ambien.INSTANCE.fontManager.ambienFont.getWidth(m2.getDisplayName())) {
                    return 1;
                }
                return 0;
            }
        });

        switch(mode) {
            case "Basic": {
                int index = 0;
                for(Module m : Ambien.INSTANCE.moduleManager.getModules()) {
                    if(!m.isToggled()) continue;
                    Gui.drawRect(sr.getScaledWidth() - Ambien.INSTANCE.fontManager.ambienFont.getWidth(m.getDisplayName()) - 5,
                            (index * 12.5F), sr.getScaledWidth(), 12.5F + (index * 12.5F), new Color(0, 0, 0).getRGB());
                    Ambien.INSTANCE.fontManager.ambienFont.drawStringWithShadow(m.getDisplayName(), sr.getScaledWidth() - Ambien.INSTANCE.fontManager.ambienFont.getWidth(m.getDisplayName()) - 3.5F,
                            1.5F + (index * 12.5F), m.getColor());
                    Gui.drawRect(sr.getScaledWidth() - 2, (index * 12.5F), sr.getScaledWidth(), 12.5F + (index * 12.5F),
                            m.getColor());
                    index++;
                }
                break;
            }
            /* More */
        }
    }
}
