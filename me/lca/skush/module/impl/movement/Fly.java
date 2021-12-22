package me.lca.skush.module.impl.movement;

import me.lca.skush.Ambien;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventUpdate;
import me.lca.skush.interfaces.ModuleInterface;
import me.lca.skush.module.Category;
import me.lca.skush.module.Module;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

@ModuleInterface(name = "Fly", displayName = "Fly", description = "Fly", category = Category.Movement, color = 0xFFb7d719)
public class Fly extends Module {

    @Override
    public void setup() {
        super.setup();
        ArrayList<String> options = new ArrayList<>();
        options.add("Hypixel");
        options.add("AAC");
        options.add("NCP");
        rSetting(new Setting("Fly-Mode", this, "Hypixel", options));
        rSetting(new Setting("Fly-Speed", this, 1,1,3,false));
        rSetting(new Setting("Fly-Speed int", this, 1,1,3,true));
        rSetting(new Setting("Fly-AntiKick", this,true));
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        this.setDisplayName("Fly \u00A77" + getSetting(this, "Fly-Mode").getValString());

        switch (getSetting("Fly-Mode").getValString())
        {
            case "Hypixel":
                break;
            case "AAC":
                aac();
                break;
            case "NCP":
                ncp();
        }
    }


    private final void hypixel() {
        mc.thePlayer.motionY = 0;
        mc.thePlayer.jump();
    }

    private final void aac() {
        mc.thePlayer.motionY = 0;
    }

    private final void ncp() {
        mc.thePlayer.motionY = 0;
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();

        mc.timer.timerSpeed = 1.0F;
        mc.thePlayer.speedInAir = 0.02F;
    }
}
