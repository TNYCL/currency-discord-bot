package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class EUR extends CommandModule {

    public EUR() { super("euro", Settings.prefix, "eur", "avrupa"); }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Euro: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.EUR).getValue() + " TL").queue();
    }

}
