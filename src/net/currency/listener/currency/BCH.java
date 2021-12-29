package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class BCH extends CommandModule {

    public BCH() {
        super("bitcoincash", Settings.prefix, "bch", "bitcash", "btccash", "btcash");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Bitcoin Cash: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.BCH).getValue() + " USD").queue();
    }

}
