package me.lca.skush.command.impl;

import me.lca.skush.Ambien;
import me.lca.skush.command.Command;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {

    public Bind() {
        super("bind", "b",".bind [module] [key]");
    }

    @Override
    public void onCommand(String[] args) {
        if (args.length != 2) {
            Ambien.INSTANCE.sendMessage(getHelp());
        } else {
            try {
                Ambien.INSTANCE.getModuleManager().getModule(args[0]).setKey(Keyboard.getKeyIndex(args[1].toUpperCase()));
                Ambien.INSTANCE.sendMessage("Bound " + Ambien.INSTANCE.getModuleManager().getModule(args[0]).getName() +  " to: " + Keyboard.getKeyName(Ambien.INSTANCE.getModuleManager().getModule(args[0]).getKey()));
                Ambien.INSTANCE.fileManager.saveBinds();
            } catch (Exception e) {
                Ambien.INSTANCE.sendMessage("Something went wrong!\nError: " + e.getMessage());
            }
        }
    }
}
