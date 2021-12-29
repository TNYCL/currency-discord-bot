package net.currency.listener.currency;

import net.currency.Main;
import net.currency.Settings;
import net.currency.module.CommandModule;
import net.currency.scheduler.CurrencyTimer;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

public class ETH extends CommandModule {

    public ETH() {
        super("ethereum", Settings.prefix, "eth", "ether");
    }

    @Override
    public void executeCommand(GenericMessageEvent event) {
        event.getChannel().sendMessage("Ethereum: " + Main.getCurrencyTimer().getValueWithType(CurrencyTimer.Type.ETH).getValue() + " USD").queue();
    }

}
