package net.currency.module.handler;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface CommandHandler {

    public void executeCommand(MessageReceivedEvent event);

}
