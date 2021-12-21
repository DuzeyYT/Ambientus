package me.exeos;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.exeos.clickgui.Clickgui;
import me.exeos.clickgui.setting.SettingsManager;
import me.exeos.command.CommandManager;
import me.exeos.event.impl.EventChat;
import me.exeos.event.impl.EventKey;
import me.exeos.module.Module;
import me.exeos.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public enum Tutorial {

    INSTANCE;

    private EventBus eventBus;
    private SettingsManager settingsManager;
    private ModuleManager moduleManager;
    private CommandManager commandManager;
    private Clickgui clickGui;

    public final void init() {
        eventBus = new EventBus();
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        clickGui = new Clickgui();
        System.out.println("Adolf");

        eventBus.register(this);
    }

    @Subscribe
    public void onKey(EventKey e) {
        for (Module m : moduleManager.getModules()) {
            if (m.getKey() == e.getKey()) {
                m.toggle();
            }
        }
    }

    @Subscribe
    public void onChat(EventChat e) {
        commandManager.handleChat(e);
    }

    public final void stop() {
        eventBus.unregister(this);
    }
    public final EventBus getEventBus() {
        return eventBus;
    }
    public final ModuleManager getModuleManager() {
        return moduleManager;
    }
    public final CommandManager getCommandManager() {
        return commandManager;
    }
    public final SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public final void sendMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Tutorial: " + message));
    }
    public final Clickgui getClickGui() {
        return clickGui;
    }

}
