package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class USD extends CommandModule {

    public USD() {
        super("dolar", Settings.prefix, "usd", "rte");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Dolar: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.USD).getValue() + " TL").queue();
    }

}
