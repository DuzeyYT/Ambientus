package me.exeos.command.impl;

import me.exeos.Tutorial;
import me.exeos.command.Command;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {

    public Bind() {
        super("bind", "b",".bind [module] [key]");
    }

    @Override
    public void onCommand(String[] args) {
        if (args.length != 2) {
            Tutorial.INSTANCE.sendMessage(getHelp());
        } else {
            try {
                Tutorial.INSTANCE.getModuleManager().getModule(args[0]).setKey(Keyboard.getKeyIndex(args[1].toUpperCase()));
                Tutorial.INSTANCE.sendMessage("Bound " + Tutorial.INSTANCE.getModuleManager().getModule(args[0]).getName() +  " to: " + Keyboard.getKeyName(Tutorial.INSTANCE.getModuleManager().getModule(args[0]).getKey()));
            } catch (Exception e) {
                Tutorial.INSTANCE.sendMessage("Something went wrong!\nError: " + e.getMessage());
            }
        }
    }

}
