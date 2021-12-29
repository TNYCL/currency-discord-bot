package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class CHF extends CommandModule {

    public CHF() {
        super("frank", Settings.prefix, "chf", "isvicre");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("İsviçre Frangı: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.CHF).getValue() + " TL").queue();
    }

}
