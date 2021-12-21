package me.exeos.command;

import me.exeos.Tutorial;
import me.exeos.command.impl.Bind;
import me.exeos.event.impl.EventChat;

import java.util.ArrayList;

public class CommandManager {

    ArrayList<Command> commands = new ArrayList<>();

    public CommandManager() {
        init();
    }

    private final void init() {
        commands.add(new Bind());
    }

    public void handleChat(EventChat e) {
        for (Command command : commands) {
            if (e.getMessage().startsWith(command.getPrefix())) {
                e.setCancelled(true);

                if (e.getMessage().startsWith(command.getPrefix() + (command.getName())) || e.getMessage().startsWith(command.getPrefix() + command.getAlias())) {
                    String message = e.getMessage().replace(command.getPrefix() + (e.getMessage().startsWith(command.getPrefix() + (command.getName())) ? command.getName() : command.getAlias()) + " ","");

                    command.onCommand(message.split(" "));
                } else {
                    Tutorial.INSTANCE.sendMessage("Error, command not found");
                }
            }
        }
    }

}
