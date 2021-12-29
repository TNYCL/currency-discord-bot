package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class SAR extends CommandModule {

    public SAR() {
        super("riyal", Settings.prefix, "suudi", "sar", "arabistan");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Suudi Arabistan Riyali: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.SAR).getValue() + " TL").queue();
    }

}
