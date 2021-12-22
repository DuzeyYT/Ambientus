package me.lca.skush;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.Hero.clickgui.ClickGUI;
import me.lca.skush.clickgui.Clickgui;
import me.lca.skush.clickgui.setting.SettingsManager;
import me.lca.skush.command.CommandManager;
import me.lca.skush.event.EventManager;
import me.lca.skush.event.EventTarget;
import me.lca.skush.event.impl.EventChat;
import me.lca.skush.event.impl.EventKey;
import me.lca.skush.file.FileManager;
import me.lca.skush.module.Module;
import me.lca.skush.module.ModuleManager;
import me.lca.skush.utils.fontRenderer.FontManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import viamcp.ViaMCP;

import java.awt.*;

public enum Ambien {

    INSTANCE;

    public SettingsManager settingsManager;
    public EventManager eventManager;
    public ModuleManager moduleManager;
    public CommandManager commandManager;
    private Clickgui clickGui;
    public ClickGUI heroCodeGui;
    public FileManager fileManager;
    public FontManager fontManager;

    public String name = "Ambien", version = "X", prefix = "[" + name + "]";
    public String[] authors = new String[] {"LCA_MODZ","Skush"};

    public final void init() {
        /* ViaVersion */
        try {
            ViaMCP.getInstance().start();
        } catch (Exception e) { e.printStackTrace(); }

        settingsManager = new SettingsManager();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        clickGui = new Clickgui();
        heroCodeGui = new ClickGUI();
        fontManager = new FontManager();

        fileManager = new FileManager();
        fileManager.createMainDirectory();
        fileManager.loadModules();
        fileManager.loadBinds();

        eventManager.register(this);
    }

    @EventTarget
    public void onKey(EventKey e) {
        for (Module m : moduleManager.getModules()) {
            if (m.getKey() == e.getKey()) {
                m.toggle();
            }
        }
    }

    @EventTarget
    public void onChat(EventChat e) {
        commandManager.handleChat(e);
    }

    public final void stop() {
        eventManager.unregister(this);
    }
    public final EventManager getEventManager() {
        return eventManager;
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
        if(Minecraft.getMinecraft().thePlayer == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Ambien.INSTANCE.name + " " + Ambien.INSTANCE.version + ": " + message));
    }
    public final Clickgui getClickGui() {
        return clickGui;
    }

}
