package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class DOGE extends CommandModule {

    public DOGE() {
        super("dogecoin", Settings.prefix, "doge", "dogcoin", "dcoin");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Dogecoin: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.DOGE).getValue() + " USD").queue();
    }

}
