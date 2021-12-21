package me.lca.skush;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.Hero.clickgui.ClickGUI;
import me.lca.skush.clickgui.Clickgui;
import me.lca.skush.clickgui.setting.SettingsManager;
import me.lca.skush.command.CommandManager;
import me.lca.skush.event.impl.EventChat;
import me.lca.skush.event.impl.EventKey;
import me.lca.skush.file.FileManager;
import me.lca.skush.module.Module;
import me.lca.skush.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public enum Ambien {

    INSTANCE;

    public EventBus eventBus;
    public SettingsManager settingsManager;
    public ModuleManager moduleManager;
    public CommandManager commandManager;
    private Clickgui clickGui;
    public ClickGUI heroCodeGui;
    public FileManager fileManager;

    public String name = "Ambien", version = "X", prefix = "[" + name + "]";
    public String[] authors = new String[] {"LCA_MODZ","Skush"};

    public final void init() {
        eventBus = new EventBus();
        settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        clickGui = new Clickgui();
        heroCodeGui = new ClickGUI();

        fileManager = new FileManager();
        fileManager.createMainDirectory();;

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
