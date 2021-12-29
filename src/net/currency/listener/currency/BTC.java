package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class BTC extends CommandModule {

    public BTC() {
        super("bitcoin", Settings.prefix, "btc", "satoshi");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Bitcoin: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.BTC).getValue() + " USD").queue();
    }

}
