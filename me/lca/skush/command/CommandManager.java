package me.lca.skush.command;

import me.lca.skush.Ambien;
import me.lca.skush.command.impl.Bind;
import me.lca.skush.event.impl.EventChat;

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
                    Ambien.INSTANCE.sendMessage("Error, command not found");
                }
            }
        }
    }

}
