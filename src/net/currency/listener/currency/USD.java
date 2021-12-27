package net.currency.listener.currency;

import net.currency.Main;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class USD extends CommandModule {

    public USD() {
        super("dolar", "$", "usd", "rte");
    }

    @Override
    public void executeCommand(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Dolar: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.USD).getValue()).queue();
    }
}
