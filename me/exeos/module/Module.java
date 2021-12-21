package me.exeos.module;

import me.exeos.Tutorial;
import me.exeos.clickgui.setting.Setting;
import me.exeos.interfaces.MinecraftInterface;
import me.exeos.interfaces.ModuleInterface;
import net.minecraft.client.Minecraft;

import java.nio.channels.AsynchronousByteChannel;

public class Module implements MinecraftInterface {

    private ModuleInterface moduleInterface = getClass().getAnnotation(ModuleInterface.class);
    private String name = moduleInterface.name(), description = moduleInterface.description();
    private Category category = moduleInterface.category();
    private int key;
    private boolean toggled;

    public Module() {
        setup();
    }

    public void setup() {

    }

    public final void toggle() {
        if (toggled) {
            onDisable();
            toggled = false;
        } else {
            onEnable();
            toggled = true;
        }
    }

    public final void setToggled(boolean toggled) {
        if (toggled) {
            if (!this.toggled)
                toggle();
        } else {
            if (this.toggled)
                toggle();
        }
    }

    public void onEnable() {
        Tutorial.INSTANCE.getEventBus().register(this);
        Tutorial.INSTANCE.sendMessage("Enabled: " + this.name);
    }

    public void onDisable() {
        Tutorial.INSTANCE.getEventBus().unregister(this);
        Tutorial.INSTANCE.sendMessage("Disabled: " + this.name);
    }

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final int getKey() {
        return key;
    }

    public final void setKey(int key) {
        this.key = key;
    }

    public final boolean isToggled() {
        return toggled;
    }

    public final Category getCategory() {
        return category;
    }

    protected final void rSetting(Setting setting) {
        Tutorial.INSTANCE.getSettingsManager().rSetting(setting);
    }

    protected final Setting getSetting(String name) {
        return Tutorial.INSTANCE.getSettingsManager().getSettingByName(name);
    }

}
