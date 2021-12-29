package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class LTC extends CommandModule {

    public LTC() {
        super("litecoin", Settings.prefix, "ltc", "lcoin", "lite");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Litecoin: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.LTC).getValue() + " USD").queue();
    }

}
