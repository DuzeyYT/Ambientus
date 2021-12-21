package me.exeos.module.impl.movement;

import com.google.common.eventbus.Subscribe;
import me.exeos.Tutorial;
import me.exeos.clickgui.setting.Setting;
import me.exeos.event.impl.EventUpdate;
import me.exeos.interfaces.ModuleInterface;
import me.exeos.module.Category;
import me.exeos.module.Module;

import java.util.ArrayList;

@ModuleInterface(name = "Fly", description = "Fly", category = Category.Movement)
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

    @Subscribe
    public void onUpdate(EventUpdate e) {
        switch (getSetting("Fly-Mode").getValString())
        {
            case "Hypixel":
                hypixel();
                break;
            case "AAC":
                aac();
                break;
            case "NCP":
                ncp();
        }
        Tutorial.INSTANCE.sendMessage("Mode is: " + getSetting("Fly-Mode").getValString());
    }


    private final void hypixel() {
        mc.thePlayer.motionY = 0;
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
    }
}
