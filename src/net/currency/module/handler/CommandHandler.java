package net.currency.module.handler;

import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public interface CommandHandler {

    public void executeCommand(GenericMessageEvent event);

}
