package me.lca.skush.module;

import me.lca.skush.Ambien;
import me.lca.skush.clickgui.setting.Setting;
import me.lca.skush.interfaces.MinecraftInterface;
import me.lca.skush.interfaces.ModuleInterface;

public class Module implements MinecraftInterface {

    private ModuleInterface moduleInterface = getClass().getAnnotation(ModuleInterface.class);
    private String name = moduleInterface.name(), description = moduleInterface.description();
    private Category category = moduleInterface.category();
    private int color = moduleInterface.color();
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
        Ambien.INSTANCE.getEventBus().register(this);
        Ambien.INSTANCE.sendMessage("Enabled: " + this.name);
    }

    public void onDisable() {
        Ambien.INSTANCE.getEventBus().unregister(this);
        Ambien.INSTANCE.sendMessage("Disabled: " + this.name);
    }

    public void addSetting(Setting set) {
        Ambien.INSTANCE.getSettingsManager().rSetting(set);
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
        Ambien.INSTANCE.getSettingsManager().rSetting(setting);
    }

    protected final Setting getSetting(String name) {
        return Ambien.INSTANCE.getSettingsManager().getSettingByName(name);
    }

    protected final Setting getSetting(Module mod, String name) {
        return Ambien.INSTANCE.getSettingsManager().getSettingByMod(mod, name);
    }
}
