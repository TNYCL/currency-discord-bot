package net.currency.listener;

import net.currency.module.CommandModule;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Commands extends ListenerAdapter {

    public List<CommandModule> commands;

    public Commands() {
        commands = new LinkedList();
    }

    @Nonnull
    public Commands registerCommands(@Nonnull CommandModule... commands) {
        Collections.addAll(this.commands, commands);
        return this;
    }

    public CommandModule getModuleWithName(String name) {
        return this.commands.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public CommandModule getModuleWithAliases(String aliases) {
        return this.commands.stream().filter(module -> module.getAliases().contains(aliases)).findFirst().orElse(null);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String commandName = event.getMessage().getContentRaw();
        String prefix = String.valueOf(commandName.charAt(0));
        String withoutPrefix = commandName.replace(prefix, "");

        CommandModule module;
        if((module = this.getModuleWithName(withoutPrefix)) != null || (module = this.getModuleWithAliases(withoutPrefix)) != null) {
            module.executeCommand(event);
            return;
        }
    }
}
