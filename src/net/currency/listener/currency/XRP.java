package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class XRP extends CommandModule {

    public XRP() {
        super("ripple", Settings.prefix, "xrp");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Ripple: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.XRP).getValue() + " USD").queue();
    }

}
